package lianjei;
//package src.Main;

import graphic.awt.AwtShow;
import graphic.swing.Login;
import logic.Chess;
import logic.FiveInLine;

import java.awt.event.ActionEvent;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

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

    public GameThread() {
    }


    @Override
    public void run() {


        // 在这里实现游戏逻辑
        System.out.println("youxikaishi");


        }



    }

