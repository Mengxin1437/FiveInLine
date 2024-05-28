package lianjei;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

class ServerThread extends Thread {
    private DatagramSocket datagramSocket;
    private int clientCount;

    public ServerThread() {
        this.clientCount = 0;
    }

    public ServerThread(DatagramSocket socket) {
        this.datagramSocket = socket;
        this.clientCount = 0;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 创建数据包对象
                byte[] buffer = new byte[1024 * 64];
                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

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

                // 增加客户端计数
                clientCount++;

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
