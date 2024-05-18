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

    /**
     * 构造方法
     * @param row 棋盘的行数
     * @param column 棋盘的列数
     * @param board 存储棋子位置信息的二维数组
     */
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

    /**
     * 显示胜利或者失败信息
     * @param g 图形上下文
     * @param bl true胜利 false失败
     */
    public void drawWinner(Graphics g, boolean bl){
        Font font = new Font("微软雅黑", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString(bl?"You Win":"You Lost", boardWidth/2-50, boardWidth/2);
    }
}
