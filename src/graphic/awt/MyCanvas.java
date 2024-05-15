package graphic.awt;

import java.awt.*;

public class MyCanvas extends Canvas {
    static Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.png");
    static Image blackChess = Toolkit.getDefaultToolkit().getImage("imgs/black.png");
    static Image whiteChess = Toolkit.getDefaultToolkit().getImage("imgs/white.png");
    static int boardWidth = AwtShow.boardWidth;
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(desk, 0, 0, boardWidth, boardWidth, this);

        //绘制边框
        g.drawRect(1, 1, boardWidth-2, boardWidth-2);

        //绘制棋盘
        drawBoard(g, 19, 19);

        //绘制棋子示例
        g.drawImage(blackChess, 10, 10, 40, 40, this);
        g.drawImage(whiteChess, 100, 100, 40, 40, this);
    }

    public void drawBoard(Graphics g, int row, int column){
        int horizontal = 0;
        int vertical = 0;
        for(int a = row ; a >= 0 ; a--){
            g.drawLine(4,4+vertical,boardWidth-5,4+vertical);
            vertical += (boardWidth-7)/row;
        }
        for(int b = column ; b >= 0 ; b--){
            g.drawLine(4+horizontal,4,4+horizontal,boardWidth-5);
            horizontal += (boardWidth-7)/column;
        }
    }

}
