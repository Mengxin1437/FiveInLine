package graphic.awt;

import java.awt.*;

public class MyCanvas extends Canvas {
    static Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.png");
    static Image blackChess = Toolkit.getDefaultToolkit().getImage("imgs/black.png");
    static Image whiteChess = Toolkit.getDefaultToolkit().getImage("imgs/white.png");
    static int boardWidth = AwtShow.boardWidth;
    private Integer row; //棋盘行数
    private Integer column; //棋盘列数
    int arrV ;
    int arrH ;

    private Boolean[][] board;
    public MyCanvas(Integer row, Integer column, Boolean[][] board){
        this.row = row;
        this.column = column;
        this.board = board;
        arrV = (int) Math.round(boardWidth / 2.0 / row);
        arrH = (int) Math.round(boardWidth / 2.0 / column);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(desk, 0, 0, boardWidth, boardWidth, this);

        //绘制边框
        g.drawRect(1, 1, boardWidth-2, boardWidth-2);

        //绘制棋盘
        drawBoardBackground(g);

        for(int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if(board[i][j]!=null){
                    drawChessman(g,board[i][j],i,j);
                }
            }
        }
    }

    public void drawBoardBackground(Graphics g){
        int horizontal = 0;
        int vertical = 0;
        //g.drawLine(arrH,arrV,(boardWidth*18/column)+arrH,(boardWidth*18/column)+arrH);
        for(int a = 0; a<row; a++){
            vertical = boardWidth * a / row; //先乘再做整除，精度更高
            g.drawLine(arrH, arrV+vertical, arrH+boardWidth*(column-1)/column, arrV+vertical);

        }
        for(int b = 0; b<column; b++){
            horizontal = boardWidth * b / column;
            g.drawLine(arrH+horizontal, arrV, arrH+horizontal, arrV+boardWidth*(row-1)/row);
        }
    }

    /**
     * 根据指定位置绘制一个棋子
     * @param g 可以绘图的对象
     * @param bn true黑棋 false白棋
     * @r 棋子所在行
     * @c 棋子所在列
     */
    private void drawChessman(Graphics g, boolean bn, int r, int c){
        int width,length;
        width = boardWidth/column;
        length = boardWidth/row;
        g.drawImage(bn?blackChess:whiteChess,(boardWidth*c/column)+arrV-width/2,
                (boardWidth*r/column)+arrH-length/2,width,length,this);
    }
}
