package Sever;

import logic.Chess;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UserThread extends Thread{
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public UserThread(Socket socket){
        try {
            out=new ObjectOutputStream(socket.getOutputStream());
            in=new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){

            try {
                User message=(User)in.readObject();
                processMessage(message) ;
               while(true){
                   Chess chess=(Chess)in.readObject() ;
                   processChess(chess) ;
               }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


    }
    SeverMain severMain = SeverMain.getSeverMain() ;


    //处理消息
    private void processMessage(User message) throws IOException {
        Map<String,UserThread> map = severMain.getUserThreadMap() ;
        String username = message.getUsername() ;
        //this调用当前线程
        map.put(username,this) ;

        if(SeverMain.list.size()>=2){
            String username1=SeverMain.list.get(0).getUsername();
            String username2=SeverMain.list.get(1).getUsername();
            UserThread userThread1 = map.get(username1) ;
            UserThread userThread2 = map.get(username2) ;
            userThread1.out.writeObject("匹配成功");
            userThread2.out.writeObject("匹配成功");
            User message2=SeverMain.list.get(0);
            User message3=SeverMain.list.get(1);
            userThread1.out.writeObject(message2);
            //向当前用户传递对手信息，客户端应将对手用户名添加进自己的文件里作为receiver
            userThread2.out.writeObject(message3);
            userThread1.out.flush();
            userThread2.out.flush();
            SeverMain.list.remove(0);
            SeverMain.list.remove(1);

        }
    public void processChess(Chess chess){
        Map<String,UserThread> map = severMain.getUserThreadMap() ;
        String receiveUsername = chess.getReceiveUser().getUsername() ;
        UserThread userThreadServer = map.get(receiveUsername) ;
        try {
            userThreadServer.out.writeObject(chess);
            userThreadServer.out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
