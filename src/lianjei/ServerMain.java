package lianjei;



import Xinxi.src.User;
import graphic.Message;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

class SeverMain{
    public static List<String> list=new ArrayList<>();
    public static List<User> list1=new ArrayList<>();
    public static List<User> list2=new ArrayList<>();
    private Map<String,UserThread> userThreadMap=new HashMap<>();
    private static SeverMain severMain;

    public Map<String, UserThread> getUserThreadMap() {
        return userThreadMap;
    }

    /**
     * 启动线程
     */
    public void start() {
        /* try {
            ServerSocket serverSocket=new ServerSocket(9990);
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("555");
                UserThread userThread=new UserThread(socket);
                userThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    public static SeverMain getSeverMain() {
        if(severMain==null){
            severMain= new SeverMain();
        }
        return severMain;
    }

    public static void main(String[] args) {
        SeverMain severMain1=SeverMain.getSeverMain();
        severMain1.start();
    }

}

