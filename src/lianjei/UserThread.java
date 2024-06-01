package lianjei;


import Xinxi.src.User;
import graphic.Message;
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
    String count;
    public UserThread(Socket socket,String count){
        try {
            System.out.println("666");
            out = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("777");
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("888");
            this.socket = socket ;
            this.count = count;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){

        try {
            //Message message = (Message) in.readObject() ;
            //System.out.println(message.getUsername()) ;
            System.out.println("777") ;
            processMessage(count) ;
            if(count == "2") count = "1";
            else count = "2";
            while(true){
                in = new ObjectInputStream(socket.getInputStream());
                Point chess = (Point) in.readObject() ;
                System.out.println(chess.x);
                System.out.println(chess.y);

                processChess(chess,count) ;
            }

        } catch (IOException e) {
            e.printStackTrace() ;
        } catch (ClassNotFoundException e) {
            e.printStackTrace() ;
        }


    }
    SeverMain severMain = SeverMain.getSeverMain();

    //private String username;
    //处理消息
    private void processMessage(String count) throws IOException {
        System.out.println("aaaaaaaaaaaaaaaaaa");
        Map<String, UserThread> map = severMain.getUserThreadMap() ;
        System.out.println("bbbbbbbbbbbbbbbbbbb");
        //count = message.getUsername() ;
        System.out.println("ccccccccccccccccccc");
        //this调用当前线程
        System.out.println(count) ;
        System.out.println(444) ;
        map.put(count, this) ;
        severMain.list.add(count) ;
        System.out.println(count) ;
        System.out.println(count+"777") ;

        System.out.println(severMain.list.size());
        if (SeverMain.list.size() >= 2) {
            String username1 = SeverMain.list.get(0) ;
            String username2 = SeverMain.list.get(1) ;
            UserThread userThread1 = map.get(username1) ;
            UserThread userThread2 = map.get(username2) ;
            //userThread1.out.writeObject("匹配成功1") ;
           // userThread1.out.flush() ;
            System.out.println("11111111") ;
          //  userThread2.out.writeObject("匹配成功2") ;
          //  userThread2.out.flush() ;
            System.out.println("22222222") ;
            System.out.println("33333333") ;
            String message2 = SeverMain.list.get(0) ;
            String message3 = SeverMain.list.get(1) ;
            String message4 = message2;
            message2 = message3;
            message3 = message4;
            //System.out.println(message2.getReceiveUserName());
           // userThread1.out.writeObject(message4) ;
            //向当前用户传递对手信息，客户端应将对手用户名添加进自己的文件里作为receiver
            //userThread2.out.writeObject(message5) ;
            System.out.println("44444444") ;
           // userThread1.out.flush() ;
           // userThread2.out.flush() ;
            Point point = null;
            userThread1.out.writeObject(point) ;
            userThread1.out.flush();
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
        System.out.println("tousername"+receiveUsername);
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

