import Xinxi.src.GameStorage;
import Xinxi.src.User;
import graphic.Thread.wUserThread;
import graphic.awt.AwtShow;
import logic.Chess;
import logic.FiveInLine;
import logic.Go;
import logic.Reversi;

import java.util.Scanner;


import java.io.IOException;
public class Main2 {
    public static void main(String[] args) throws IOException {
        GameStorage gameStorage = new GameStorage();
        System.out.println("请选择游戏类型：1.五子棋 2.黑白棋 3.围棋");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Chess chess=null;
        //得到用户信息
        User user = gameStorage.loadUser(".\\filename2");
        switch (choice){
            case 2:
                chess = new Reversi();
                chess.init(10, 10);
                break;
            case 3:
                chess = new Go();
                chess.init(19, 19);
                break;
            default: case 1:
                chess = new FiveInLine();
                chess.init(19, 19);
                break;
        }
        user.setType(chess);
        //启动用户线程
        Thread userThread = new wUserThread(chess, user);
        userThread.start();
        if(chess != null)
            new AwtShow(chess, userThread);
    }


}