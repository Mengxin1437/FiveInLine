package graphic.awt;

import logic.Chess;

import java.awt.*;

public class MyCanvas extends Canvas {
    private static final Image desk = Toolkit.getDefaultToolkit().getImage("imgs/desk.png");
    private static final Image blackChess = Toolkit.getDefaultToolkit().getImage("imgs/black.png");
    private static final Image whiteChess = Toolkit.getDefaultToolkit().getImage("imgs/white.png");
    private final int boardWidth;
    private final int arrV; //垂直偏移
    private final int arrH; //水平偏移
    private final Chess chess; //对游戏逻辑对象的引用

    public int getBoardWidth() {
        return boardWidth;
    }

    /**
     * 构造方法
     */
    public MyCanvas(Chess chess, int boardWidth){
        this.chess = chess;
        this.boardWidth = boardWidth;
        Boolean[][] board = this.chess.getBoard();
        arrV = (int) Math.round(boardWidth / 2.0 / board.length);
        arrH = (int) Math.round(boardWidth / 2.0 / board[0].length);
        this.setBounds(72, 72, boardWidth, boardWidth);
        this.setPreferredSize(new Dimension(boardWidth, boardWidth));
        this.setLocation(72, 72);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(desk, 0, 0, boardWidth, boardWidth, this);

        //绘制边框
        g.drawRect(1, 1, boardWidth-2, boardWidth-2);

        //绘制棋盘
        drawBoardBackground(g);

        Boolean[][] board = this.chess.getBoard();
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if(board[i][j]!=null){
                    drawChessman(g,board[i][j],i,j);
                }
            }
        }
        drawTriangleFlag(g);
        if(chess.getWinner()!=null)
            drawWinner(g);
    }

    private void drawBoardBackground(Graphics g){
        int horizontal;
        int vertical;
        Boolean[][] board = this.chess.getBoard();
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

        //绘制角上4个星位
        int r = row>=9&&row<13 ? 2 : 3;
        int c = column>=9&&column<13 ? 2 : 3;
        drawBlackPoint(g, r, c);
        drawBlackPoint(g, r, column-c-1);
        drawBlackPoint(g, row-r-1, c);
        drawBlackPoint(g, row-r-1, column-c-1);

        if(row%2==1 && column%2==1){
            //绘制天元
            drawBlackPoint(g, row/2, column/2);

            //绘制星位之间的中点
            if(row>=15 && column>=15){
                drawBlackPoint(g, r, column/2);
                drawBlackPoint(g, row/2, c);
                drawBlackPoint(g, row/2, column-c-1);
                drawBlackPoint(g, row-r-1, column/2);
            }
        }
    }

    /**
     * 绘制当前落子标识
     */
    private void drawTriangleFlag(Graphics g){
        if (chess == null || chess.previousPoint==null) return;
        int r = chess.previousPoint.x;
        int c = chess.previousPoint.y;
        int row = chess.getBoard().length;
        int column = chess.getBoard()[0].length;
        int startX = (boardWidth*c/column)+arrH;
        int startY = (boardWidth*r/row)+arrV;
        int width = boardWidth/Math.max(column, row);
        int[] xs = {startX, startX+width/2, startX};
        int[] ys = {startY, startY, startY+width/2};
        Color color = g.getColor();
        g.setColor(chess.getTurn() ? Color.BLACK : Color.WHITE);
        g.fillPolygon(xs, ys, 3);
        g.setColor(color);
    }

    /**
     * 根据指定位置绘制一个棋子
     * @param g 可以绘图的对象
     * @param bn true黑棋 false白棋
     * @param r 棋子所在行
     * @param c 棋子所在列
     */
    private void drawChessman(Graphics g, boolean bn, int r, int c){
        Boolean[][] board = this.chess.getBoard();
        int row = board.length;
        int column = board[0].length;
        int width = boardWidth/Math.max(column, row);
        g.drawImage(bn?blackChess:whiteChess,(boardWidth*c/column)+arrH-width/2,
                (boardWidth*r/row)+arrV-width/2, width, width,this);
    }

    private static final int radius = 8; //黑色圆点的半径
    /**
     * 绘制黑圆点
     */
    private void drawBlackPoint(Graphics g, int r, int c){
        Boolean[][] board = this.chess.getBoard();
        int row = board.length;
        int column = board[0].length;
        g.fillRect((boardWidth*c/column)+arrH-radius/2,
                (boardWidth*r/row)+arrV-radius/2, radius, radius);
    }

    /**
     * 显示胜利或者失败信息
     * @param g 图形上下文
     */
    private void drawWinner(Graphics g){
        Font font = new Font("微软雅黑", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString(chess.getWinner()?"黑方胜利":"白方胜利", boardWidth/2-50, boardWidth/2);
    }
}
