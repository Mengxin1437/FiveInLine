package graphic.awt;

import logic.Chess;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseEvent extends MouseAdapter {
    static int boardWidth = AwtShow.boardWidth;
    private final MyCanvas myCanvas;
    private final Chess chess;
    private boolean reaction = true; //是否响应操作
    public MyMouseEvent(MyCanvas myCanvas, Chess chess){
        this.myCanvas = myCanvas;
        this.chess = chess;
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        if(!reaction) return;
        Point pos = getPos(e);
        System.out.println(pos);

        int x = pos.x;
        int y = pos.y;
        if(chess.isMovePositionOk(x, y)){
            chess.moveDown(x, y);
            myCanvas.repaint();
            Boolean result = chess.isWin(x, y);
            if(result != null){
                System.out.println((result?"黑方":"白方") + "胜利");
                myCanvas.winner = result;
                myCanvas.repaint();
                reaction = false;
            }
        }else{
//            positionNotAllowedInfo();//当输入的位置不合法时的提示信息
        }


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
        int row = chess.board.length;
        int column = chess.board[0].length;
        int arrV = (int) Math.round(boardWidth / 2.0 / row);
        int arrH = (int) Math.round(boardWidth / 2.0 / column);

        int b = (int)Math.round(((x - arrH) * column) / (double)boardWidth);
        int a = (int)Math.round(((y - arrV) * row) / (double)boardWidth);

        return new Point(a,b);
    }
}