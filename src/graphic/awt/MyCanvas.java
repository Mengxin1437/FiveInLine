package graphic.awt;

import java.awt.*;

public class MyCanvas extends Canvas {
    static Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.png");
    static Image blackChess = Toolkit.getDefaultToolkit().getImage("imgs/black.png");
    static Image whiteChess = Toolkit.getDefaultToolkit().getImage("imgs/white.png");
    static int boardWidth = AwtShow.boardWidth;
    int arrV; //垂直偏移
    int arrH; //水平偏移
    public Boolean winner;
    private Boolean[][] board; //对棋盘的引用 board.length表示棋盘行数 board[0].length表示棋盘的列数

    /**
     * 构造方法
     * @param board 存储棋子位置信息的二维数组
     */
    public MyCanvas(Boolean[][] board){
        this.board = board;
        arrV = (int) Math.round(boardWidth / 2.0 / board.length);
        arrH = (int) Math.round(boardWidth / 2.0 / board[0].length);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(desk, 0, 0, boardWidth, boardWidth, this);

        //绘制边框
        g.drawRect(1, 1, boardWidth-2, boardWidth-2);

        //绘制棋盘
        drawBoardBackground(g);

        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j]!=null){
                    drawChessman(g,board[i][j],i,j);
                }
            }
        }
        if(winner!=null)
            drawWinner(g);
    }

    public void drawBoardBackground(Graphics g){
        int horizontal = 0;
        int vertical = 0;
        int row = board.length;
        int column = board[0].length;
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
     * @param r 棋子所在行
     * @param c 棋子所在列
     */
    private void drawChessman(Graphics g, boolean bn, int r, int c){
        int row = board.length;
        int column = board[0].length;
        int width = boardWidth/Math.max(column, row);
        g.drawImage(bn?blackChess:whiteChess,(boardWidth*c/column)+arrH-width/2,
                (boardWidth*r/row)+arrV-width/2, width, width,this);
    }

    /**
     * 显示胜利或者失败信息
     * @param g 图形上下文
     */
    public void drawWinner(Graphics g){
        Font font = new Font("微软雅黑", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString(winner?"黑方胜利":"白方胜利", boardWidth/2-50, boardWidth/2);
    }
}
