package graphic.awt;

import java.awt.*;

public class MyCanvas extends Canvas {
    static Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.png");
    static Image blackChess = Toolkit.getDefaultToolkit().getImage("imgs/black.png");
    static Image whiteChess = Toolkit.getDefaultToolkit().getImage("imgs/white.png");
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int UL = AwtShow.UL;
        g.drawImage(desk, 0, 0, 576*UL, 576*UL, this);

        //绘制边框
        g.drawRect(1, 1, 574*UL, 574*UL);

        //绘制棋盘
        drawBoard(g, 19, 19);

        //绘制棋子示例
        g.drawImage(blackChess, 10, 10, 40, 40, this);
        g.drawImage(whiteChess, 100, 100, 40, 40, this);
    }

    public void drawBoard(Graphics g, int row, int column){

    }

}
