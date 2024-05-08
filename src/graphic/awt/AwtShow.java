package graphic.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtShow {
    public static void main(String[] args) {
        Frame mFrame = new MyPaint("棋盘游戏");
        mFrame.setLocation(400,100);
        mFrame.setSize(500,500);
        mFrame.setBackground(Color.darkGray);
        mFrame.setVisible(true);
        MouseAdapter mouseAdapter = new MyMouseEvent(mFrame);
        mFrame.addMouseListener(mouseAdapter);
        mFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}

