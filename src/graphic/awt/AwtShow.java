package graphic.awt;

import logic.Chess;

import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AwtShow {
    public AwtShow(Chess chess, Thread userThread){
        Frame mFrame = new Frame("棋盘游戏");
        setCenterAndClose(mFrame, windowWidth, windowHeight);
        mFrame.setResizable(false); //设置窗口大小不可调
        mFrame.setLayout(null); //取消布局管理器
        MyCanvas cv = new MyCanvas(chess, boardWidth);

        mFrame.add(cv);
        MouseListener chessOnAwt = new graphic.awt.ChessOnAwt(cv, chess, userThread);

        cv.addMouseListener(chessOnAwt);
    }
    public static final int windowWidth = 960;
    public static final int windowHeight = 720;
    public static final int boardWidth = 578;

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