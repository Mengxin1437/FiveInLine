package graphic.awt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseEvent extends MouseAdapter {
    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        //使用e.getX();e.getY()获取横纵坐标并转化到棋盘的坐标
        System.out.println(e.getX()+" "+e.getY());
    }
}