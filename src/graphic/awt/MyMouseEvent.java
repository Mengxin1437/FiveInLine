package graphic.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseEvent extends MouseAdapter {
    static int boardWidth = AwtShow.boardWidth;
    private Integer row; //棋盘行数
    private Integer column; //棋盘列数
    private MyCanvas myCanvas;
    private Boolean turn = true;//test
    private Boolean[][] board;//test
    public MyMouseEvent(Integer row, Integer column, MyCanvas myCanvas){
        this.row = row;
        this.column = column;
        this.myCanvas = myCanvas;

        //下面这里仅测试用
        board = new Boolean[row][column];
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);

        Point pos = getPos(e);
        /*test below*/
        board[pos.x][pos.y] = turn;
        turn = !turn;
        myCanvas.drawBoard(board);
    }

    /**
     * 从点击位置获取坐标
     * @param e 鼠标点击位置坐标
     * @return Point.x表示行 Point.y表示列
     */
    public Point getPos(MouseEvent e){
        //使用e.getX();e.getY()获取横纵坐标并转化到棋盘的坐标
        //示例:System.out.println(e.getX()+" "+e.getY());
        Point p = new Point();



        return p;
    }
}