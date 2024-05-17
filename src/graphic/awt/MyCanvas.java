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
        drawBoard(g, 9, 9);

        //绘制棋子示例
        g.drawImage(blackChess, 10, 10, 40, 40, this);
        g.drawImage(whiteChess, 100, 100, 40, 40, this);
    }

    public void drawBoard(Graphics g, int row, int column){
        int arrV = (int) Math.round(boardWidth / 2.0 / row);
        int arrH = (int) Math.round(boardWidth / 2.0 / column);
        int horizontal = 0;
        int vertical = 0;
        for(int a = 0; a<row; a++){
            vertical = boardWidth * a / row; //先乘再做整除，精度更高
            g.drawLine(arrH, arrV+vertical, arrH+boardWidth*(column-1)/column, arrV+vertical);
        }
        for(int b = 0; b<column; b++){
            horizontal = boardWidth * b / column;
            g.drawLine(arrH+horizontal, arrV, arrH+horizontal, arrV+boardWidth*(row-1)/row);
        }
    }

}
