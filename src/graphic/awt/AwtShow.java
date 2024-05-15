package graphic.awt;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtShow {
    public static final int windowWidth = 960;
    public static final int windowHeight = 720;
    public static final int boardWidth = 578;
    public static void main(String[] args) {
        Frame mFrame = new Frame("棋盘游戏");
        setCenterAndClose(mFrame, windowWidth, windowHeight);
        mFrame.setResizable(false); //设置窗口大小不可调
        mFrame.setLayout(null); //取消布局管理器
        Canvas cv = new MyCanvas();
        cv.setBounds(72, 72, boardWidth, boardWidth);
        cv.setPreferredSize(new Dimension(boardWidth, boardWidth));
        cv.setLocation(72, 72);
        mFrame.add(cv);
        MouseAdapter mouseAdapter = new MyMouseEvent();
        cv.addMouseListener(mouseAdapter);
    }

    public static void setCenterAndClose(Frame frame, int width, int height){
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        int scWidth = screenSize.width;
        int scHeight= screenSize.height;
        frame.setSize(width, height);
        frame.setLocation((scWidth-width)/2, (scHeight-height)/2);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}

