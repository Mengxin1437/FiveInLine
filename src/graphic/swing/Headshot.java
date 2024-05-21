package graphic.swing;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.File;

public class Headshot extends JLabel {
    JFrame parent;
    public Headshot(JFrame parent){
        this.parent = parent;
        ImageIcon icon = SwingUtil.createAutoAdjustIcon(getClass().getResource("/addHead.png"), true);
        //注意设计器里面不要再设置Icon属性啦
        this.setIcon(icon);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 创建一个默认打开用户文件夹的问价选择器
                JFileChooser chooser = new JFileChooser();
                chooser.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File f) {
                        //文件夹必须是可选（打开）的
                        if(f.isDirectory())  return true;
                            //以mp4结尾，设置为可选
                        else {
                            String name = f.getName();
                            if (name.endsWith(".png") || name.endsWith(".jpg")
                                    || name.endsWith(".gif")) {
                                return true;
                            }else { //其它的文件类型都设置为不可选
                                return false;
                            }
                        }
                    }

                    @Override
                    public String getDescription() {
                        return null;
                    }
                });
                int flag = chooser.showOpenDialog(parent);
                //若选择了文件，则打印选择了什么文件
                if (flag == JFileChooser.APPROVE_OPTION){
                    String filePath = chooser.getSelectedFile().getPath();
                    ImageIcon ic = SwingUtil.createAutoAdjustIcon(filePath, false);
                    Headshot.this.setIcon(ic);
                    Headshot.this.repaint();
                }
            }
        });
    }
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d=(Graphics2D)g;
        Shape region=new Ellipse2D.Double(0, 0, this.getWidth(), this.getHeight());
        g2d.setClip(region);
        super.paint(g);
    }
}
