package Sever;

import Xinxi.src.User;
import graphic.Message;
import graphic.Pos;
import logic.Chess;

import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserThread extends Thread{
    Message message0 = new Message("chuanshu");
    Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public UserThread(Socket socket){
        try {
            System.out.println("666");
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            this.socket = socket ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){

            try {
                Message message = (Message) in.readObject() ;
                System.out.println(message.getUsername()) ;
                System.out.println("777") ;
                processMessage(message) ;
               while(true){
                   in = new ObjectInputStream(socket.getInputStream());
                   Point chess = (Point) in.readObject() ;
                   System.out.println(chess.x);
                   System.out.println(chess.y);
                   processChess(chess,message.getReceiveUserName()) ;
               }

            } catch (IOException e) {
                e.printStackTrace() ;
            } catch (ClassNotFoundException e) {
                e.printStackTrace() ;
            }


    }
    SeverMain severMain = SeverMain.getSeverMain() ;

    private String username;
    //处理消息
    private void processMessage(Message message) throws IOException {
        Map<String, UserThread> map = severMain.getUserThreadMap() ;
        username = message.getUsername() ;
        //this调用当前线程
        System.out.println(username) ;
        System.out.println(444) ;
        map.put(username, this) ;
        severMain.list.add(message) ;
        System.out.println(username) ;
        System.out.println(username+"777") ;

        System.out.println(severMain.list.size());
        if (SeverMain.list.size() >= 2) {
            String username1 = SeverMain.list.get(0).getUsername() ;
            String username2 = SeverMain.list.get(1).getUsername() ;
            UserThread userThread1 = map.get(username1) ;
            UserThread userThread2 = map.get(username2) ;
            userThread1.out.writeObject("匹配成功1") ;
            userThread1.out.flush() ;
            System.out.println("11111111") ;
            userThread2.out.writeObject("匹配成功2") ;
            userThread2.out.flush() ;
            System.out.println("22222222") ;
            System.out.println("33333333") ;
            Message message2 = SeverMain.list.get(0) ;
            Message message3 = SeverMain.list.get(1) ;
            message2.setReceiveUserName(message3.getUsername());
            message3.setReceiveUserName(message2.getUsername());
            System.out.println(message2.getReceiveUserName());
            userThread1.out.writeObject(message2) ;
            //向当前用户传递对手信息，客户端应将对手用户名添加进自己的文件里作为receiver
            userThread2.out.writeObject(message3) ;
            System.out.println("44444444") ;
            userThread1.out.flush() ;
            userThread2.out.flush() ;
            Point point = null;
            userThread1.out.writeObject(point) ;
            userThread2.out.flush();
            System.out.println("55555555") ;
            SeverMain.list.remove(0) ;
            SeverMain.list.remove(0) ;
            System.out.println("66666666") ;
        }
    }
    //转发
    public void processChess(Point chess,String receiveUsername){
        Map<String, UserThread> map = severMain.getUserThreadMap();

        UserThread userThreadServer = map.get(receiveUsername);
        System.out.println(receiveUsername);
        System.out.println(chess.x);
        System.out.println(chess.y);
        try {
            userThreadServer.out.writeObject(chess);
            userThreadServer.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
