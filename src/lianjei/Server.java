package lianjei;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) {
        startServer();

    }
    public static void startServer() {
        try {
            System.out.println("接收端启动");

            // 创建接收端对象，注册端口
            DatagramSocket datagramSocket = new DatagramSocket(9990);

            // 创建并启动接收数据的线程
            ServerThread serverThread = new ServerThread(datagramSocket);
            serverThread.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

