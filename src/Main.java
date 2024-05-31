import graphic.awt.AwtShow;
import logic.Chess;
import logic.FiveInLine;
import logic.Go;
import logic.Reversi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("请选择游戏类型：1.五子棋 2.黑白棋 3.围棋");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        Chess chess = null;
        switch (choice) {
            case 2:
                chess = new Reversi();
                chess.init(8, 8);
                break;
            case 3:
                chess = new Go();
                chess.init(19, 19);
                break;
            default:
            case 1:
                chess = new FiveInLine();
                chess.init(19, 19);
                break;
        }
        if (chess != null)
            new AwtShow(chess);
    }


}
