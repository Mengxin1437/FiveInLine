package lianjei;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientThread {
    public static void main(String[] args) {
        try {
            System.out.println("发送端启动");

            // 创建发送端对象，发送端自带默认端口号
            DatagramSocket socket = new DatagramSocket(6667);

            // 创建数据包对象封装数据
            byte[] buffer = "zhi zhe bu ru ai he".getBytes();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName("255.255.255.255"), 9990);

            // 发送数据
            socket.send(packet);

            // 关闭发送端
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


