package graphic.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseEvent extends MouseAdapter {
    static int boardWidth = AwtShow.boardWidth;
    private MyCanvas myCanvas;
    private Boolean turn = true;//test
    private Boolean[][] board;
    public MyMouseEvent(MyCanvas myCanvas,Boolean[][] board){
        this.myCanvas = myCanvas;
        this.board = board;

    }
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        Point pos = getPos(e);
        System.out.println(pos);

        board[pos.x][pos.y] = turn;
        turn = !turn;

        myCanvas.repaint();
    }

    /**
     * 从点击位置获取坐标
     * @param e 鼠标点击位置坐标
     * @return Point.x表示行 Point.y表示列
     */
    private Point getPos(MouseEvent e){
        //使用e.getX();e.getY()获取横纵坐标并转化到棋盘的坐标
        //示例:System.out.println(e.getX()+" "+e.getY());
        int x = e.getX();
        int y = e.getY();
        int row = board.length;
        int column = board[0].length;
        int arrV = (int) Math.round(boardWidth / 2.0 / row);
        int arrH = (int) Math.round(boardWidth / 2.0 / column);

        int b = (int)Math.round(((x - arrH) * column) / (double)boardWidth);
        int a = (int)Math.round(((y - arrV) * row) / (double)boardWidth);

        return new Point(a,b);
    }
}