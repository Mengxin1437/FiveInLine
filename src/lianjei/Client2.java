package lianjei;

import graphic.awt.AwtShow;
import graphic.swing.Login;
import logic.Chess;
import logic.FiveInLine;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

public class Client2 {
    public static String clientIP;
    public static int clientPort;
    public static void main(String[] args) {
        startClient();
    }
    public static void startClient() {
        try {
            System.out.println("发送端启动");

            // 创建发送端对象，发送端自带默认端口号
            DatagramSocket socket = null;
            try {
                socket = new DatagramSocket(6667);
            } catch (SocketException e) {
                e.printStackTrace();
            }

            // 创建数据包对象封装数据
            byte[] buffer = "zhi zhe bu ru ai he".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), 9990);

            // 发送数据
            try {
                socket.send(packet);
                socket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            ServerSocket serverSocket = null;
            Socket clientSocket = null;
            try {
                serverSocket = new ServerSocket(6666);
                clientSocket = serverSocket.accept(); // Accept connection from client
                System.out.println("Client connected");
                InputStream inputStream = clientSocket.getInputStream(); // Get input stream from client socket
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                clientIP = reader.readLine(); // Read client IP from input
                System.out.println(clientIP);
                int startIndex = clientIP.indexOf(":") + 2; // 找到冒号后的第一个字符索引
                String numericPart = clientIP.substring(startIndex); // 提取从该索引开始的子字符串
                System.out.println(numericPart);


                Login login = new Login();
                ActionEvent e=null;
                if (login.radioButton1(e)) {
                    Chess chess = null;
                    chess = new FiveInLine();
                    chess.init(19, 19);

                    Thread ClientThread = new ClientThread(numericPart, 8888,chess);

                    ClientThread.start();
                    // 关闭发送端
                    if (chess != null)
                        new AwtShow(chess,ClientThread);
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error: Failed to establish connection or read data.");
            } finally {
                // Disconnecting message
                System.out.println("Disconnecting...");
                // Close resources
                try {
                    if (clientSocket != null) {
                        clientSocket.close(); // Close the client socket
                    }
                    if (serverSocket != null) {
                        serverSocket.close(); // Close the server socket
                    }
                } catch (SocketException e) {
                    // 捕获连接重置的异常
                    // 在这里你可以执行特定的操作，例如记录错误信息、关闭资源等
                    System.err.println("连接被重置: " + e.getMessage());
                    e.printStackTrace(); // 打印异常堆栈信息
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }  catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

}


