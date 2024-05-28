package lianjei;
//package src.Main;

import graphic.awt.AwtShow;
import graphic.swing.Login;
import logic.Chess;
import logic.FiveInLine;

import java.awt.event.ActionEvent;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.Socket;

class GameThread extends Thread {
    private DatagramSocket socket;
    private InetSocketAddress clientAddress;
    private String data;
    private ActionEvent e;

    public GameThread(DatagramSocket socket, InetSocketAddress clientAddress, String data) {
        this.socket = socket;
        this.clientAddress = clientAddress;
        this.data = data;
    }

    @Override
    public void run() {
        Qidong qidong = new Qidong();

            qidong.dispose();

        // 在这里实现游戏逻辑
        Login login = new Login();
        if (login.radioButton1(e)){
            Chess chess=null;
            chess = new FiveInLine();
            chess.init(19, 19);
            //if(chess != null)
               // new AwtShow(chess,socket,this);


        }



    }
}
