package graphic.awt;

import java.awt.*;

public class MyPaint extends Frame {
    public MyPaint(String title) throws HeadlessException {
        super(title);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制棋盘 棋子
        //使用g.drawLine()画线或者使用其它方法绘制贴图
    }
}
