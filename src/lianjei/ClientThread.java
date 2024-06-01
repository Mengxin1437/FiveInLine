package lianjei;



import Xinxi.src.User;
import graphic.Message;

import graphic.awt.ChessOnAwt;
import graphic.awt.MyCanvas;
import logic.Chess;
import logic.FiveInLine;
import logic.Reversi;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    Socket socket;
    Chess chess;
    Client client;
    ChessOnAwt chessOnAwt;
    MyCanvas myCanvas;
    Message message;
    Message dmessage;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    String ip;
    int port;
    public ClientThread(Chess chess, Client client) throws IOException {



        this.chess = chess;
        this.client= client;
    }
    public ClientThread(String ip,int port,Chess chess){
        this.port = port;
        this.ip = ip;
        this.chess = chess;
        try {
            socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("65165416549649");
           // in = new ObjectInputStream(socket.getInputStream());
            System.out.println("65165416549649");
            out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("65165416549649");
           // System.out.println(client.getUsername());
           // message = new Message(user.getUsername());
            //向服务端上传用户基本信息
           // out.writeObject(message);
//            System.out.println("111");
      //      String a = (String) in.readObject();
     //       System.out.println(a);
     //       message = (Message) in.readObject();
            //等待服务端传输对方的下一步，执行完毕将ChessOnAwt实例的keyi改为true，令其能够进行下一步
            while (true){
                System.out.println("222");
                System.out.println("65165416549649");

                System.out.println("65165416549649");
                Point pos = (Point) in.readObject();
                System.out.println("65165416549649");
                System.out.println("?????");

                if(pos == null){
                    chessOnAwt.setKeyi(true);
                }

                else{
                    System.out.println(pos.x);
                    System.out.println(pos.y);
                    int x = pos.x;
                    int y = pos.y;
                    if(chess.isMovePositionOk(x, y)){
                        chess.moveDown(x, y);
                        myCanvas.repaint();
                        Boolean result = chess.isWin(x, y);
                        if(result != null){
                            System.out.println((result?"黑方":"白方") + "胜利");
                            myCanvas.repaint();
                            chessOnAwt.setReaction(false);
                        }
                    }else{
//            positionNotAllowedInfo();//当输入的位置不合法时的提示信息
                    }
                    chessOnAwt.setKeyi(true);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    //确保Mycanvas和ChessOnAwt实例的唯一性
    public void setMyCanvas(MyCanvas myCanvas){
        this.myCanvas = myCanvas;
    }
    public void setChessOnAwt(ChessOnAwt chessOnAwt){
        this.chessOnAwt = chessOnAwt;
    }
    public Socket getSocket(){return socket;}
    public void sendchess(Point point){
        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(point);
            out.flush();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Message getMessage(){
        return message;
    }
}
