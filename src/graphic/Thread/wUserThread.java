package graphic.Thread;

import Xinxi.src.User;
import graphic.Message;
import graphic.awt.ChessOnAwt;
import graphic.awt.MyCanvas;
import logic.Chess;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
//0531zh
public class wUserThread extends Thread{
    Socket socket;
    Chess chess;
    User user;
    ChessOnAwt chessOnAwt;
    MyCanvas myCanvas;
    Message message;
    Message dmessage;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public wUserThread(Chess chess, User user) throws IOException {
        socket = new Socket("bj.frp.one", 37283);
        this.chess = chess;
        this.user = user;
    }

    @Override
    public void run() {
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println(user.getUsername());
            message = new Message(user.getUsername());
            //向服务端上传用户基本信息
            out.writeObject(message);
            out.flush();
            System.out.println("111");
            String a = (String) in.readObject();
            System.out.println(a);
            message = (Message) in.readObject();
            //等待服务端传输对方的下一步，执行完毕将ChessOnAwt实例的keyi改为true，令其能够进行下一步
            while (true){
                System.out.println("222");
                Point pos = (Point) in.readObject();

                System.out.println("?????");
                if(pos == null){
                    chessOnAwt.setKeyi(true);
                }
                else{
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
