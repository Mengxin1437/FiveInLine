package lianjei;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;

class ServerThread extends Thread {
    private DatagramSocket datagramSocket;
    private int clientCount;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket clientSocketture;
    private int i=1;
    public ServerThread() {
        this.clientCount = 0;
    }
    UserThread userThread2;
    UserThread userThread;
    public ServerThread(DatagramSocket socket) {
        this.datagramSocket = socket;
        this.clientCount = 0;

    }


    @Override
    public void run() {
        try {
            ServerSocket Socketture = new ServerSocket(8888);

            while (true) {
                // 创建数据包对象
                System.out.println("9887654321");
                byte[] buffer = new byte[1024 * 64];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                System.out.println("9887654321");
                // 等待接收数据
                datagramSocket.receive(datagramPacket);

                // 从数据包中获取信息
                int len = datagramPacket.getLength();
                String receivedData = new String(buffer, 0, len);
                System.out.println("接收到的数据：" + receivedData);

                // 获取发送端的IP地址和端口
                InetSocketAddress senderAddress = (InetSocketAddress) datagramPacket.getSocketAddress();
                String senderIP = senderAddress.getAddress().toString().substring(1); // 去除开头的 "/"
                int senderPort = senderAddress.getPort();

                // 输出发送端的IP地址和端口
                System.out.println("对方的IP地址：" + senderIP);
                System.out.println("对方的端口：" + senderPort);


                clientCount++;


                    Socket socket = new Socket(senderIP, 6666);
                    InetAddress clientAddress = socket.getLocalAddress();
                    int clientPort = socket.getLocalPort();
                    OutputStream outputStream = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(outputStream, true);
                    writer.println("Client IP: " + clientAddress.getHostAddress());
                    writer.println("Client Port: " + clientPort);
                    socket.close();
                Socket clientSocketture = Socketture.accept();



               // in = new ObjectInputStream(clientSocketture.getInputStream());
                //out = new ObjectOutputStream(clientSocketture.getOutputStream());
                System.out.println("1354245234663546475367");



                    int c=clientCount;
                    c = 1;
                    abd:{
                        do{
                            for (; i < 100; )
                            {
                                if(i%2==1){
                                    String a = "1";
                                    System.out.println("666566");
                                    System.out.println(clientSocketture.getPort());
                                    userThread = new UserThread(clientSocketture, a);
                                    System.out.println("aaaaaaaa");
                                    userThread.start();
                                    System.out.println("pppppppppp");
                                    c = 0;
                                    i++;
                                    break abd;
                                }else {
                                    String b = "2";
                                    System.out.println("666766");

                                    userThread2 = new UserThread(clientSocketture, b);
                                    userThread2.start();
                                    c = 0;
                                    i++;
                                    break abd;
                                }
                            }


                        }while (c>0);
                    }

                System.out.println("456987123");







                // 增加客户端计数


                // 当有两个客户端连接时才启动游戏线程
                if (clientCount == 2) {
                    // 启动游戏线程
                    GameThread gameThread = new GameThread(datagramSocket, senderAddress, receivedData);
                    gameThread.start();
                    clientCount = 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
