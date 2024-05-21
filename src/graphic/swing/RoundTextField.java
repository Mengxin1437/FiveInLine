package graphic.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

class RoundTextField extends JTextField {
    private int arcSize;
    private String hint; //提示信息

    public RoundTextField(String hint, int arcSize) {
        super();
        this.arcSize = arcSize;
        this.hint = hint;
        setOpaque(false);// 使TextField透明,以显示圆角边框
        // 设置TextField的内边距
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.setForeground(Color.gray);
        this.setText("  "+hint);
        this.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                //得到焦点时，当前文本框的提示文字和创建该对象时的提示文字一样，说明用户正要键入内容
                RoundTextField.this.setText("");     //将提示文字清空
                RoundTextField.this.setForeground(Color.black);  //设置用户输入的字体颜色为黑色
            }

            @Override
            public void focusLost(FocusEvent e) {
                //失去焦点时，用户尚未在文本框内输入任何内容，所以依旧显示提示文字
                if (RoundTextField.this.getText().equals("")) {
                    RoundTextField.this.setForeground(Color.gray); //将提示文字设置为灰色
                    RoundTextField.this.setText("  "+hint);     //显示提示文字
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, arcSize, arcSize);
        super.paintComponent(g2d);// 绘制文本框的内容
        g2d.dispose();
    }
}
