/*
 * Created by JFormDesigner on Tue May 21 16:16:29 CST 2024
 */

package graphic.swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author 33867
 */
public class Login extends JFrame {
    public static void main(String[] args) {
        new Login();
    }
    public Login() {
        this.setUndecorated(true);
        initComponents();
    }

    private void btnClose(ActionEvent e) {
        this.dispose();
        System.exit(0);
    }

    private void btnMinimize(ActionEvent e) {
        this.setExtendedState(JFrame.ICONIFIED);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        btnClose = new JButton();
        btnMinimize = new JButton();
        tfUsername = new RoundTextField("用户名", 25);
        tfPassword = new RoundTextField("密码", 25);
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        btnLogin = new JButton();
        lbHead = new Headshot(this);
        background = new JLabel();

        //======== this ========
        setResizable(false);
        setPreferredSize(new Dimension(300, 420));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());

        //======== panel1 ========
        {
            panel1.setPreferredSize(new Dimension(300, 420));
            panel1.setLayout(null);

            //---- btnClose ----
            btnClose.setText("\u00d7");
            btnClose.setBackground(new Color(0x002b2d30, true));
            btnClose.setForeground(Color.white);
            btnClose.setBorder(null);
            btnClose.setFocusPainted(false);
            btnClose.setFont(new Font("Inter", Font.PLAIN, 20));
            btnClose.setPreferredSize(new Dimension(40, 25));
            btnClose.addActionListener(e -> btnClose(e));
            panel1.add(btnClose);
            btnClose.setBounds(new Rectangle(new Point(260, 0), btnClose.getPreferredSize()));

            //---- btnMinimize ----
            btnMinimize.setText("-");
            btnMinimize.setFont(new Font("Inter", Font.PLAIN, 20));
            btnMinimize.setPreferredSize(new Dimension(40, 25));
            btnMinimize.setBackground(new Color(0x002b2d30, true));
            btnMinimize.setForeground(Color.white);
            btnMinimize.setBorder(null);
            btnMinimize.setFocusPainted(false);
            btnMinimize.addActionListener(e -> btnMinimize(e));
            panel1.add(btnMinimize);
            btnMinimize.setBounds(new Rectangle(new Point(220, 0), btnMinimize.getPreferredSize()));

            //---- tfUsername ----
            tfUsername.setPreferredSize(new Dimension(200, 30));
            tfUsername.setBorder(null);
            panel1.add(tfUsername);
            tfUsername.setBounds(new Rectangle(new Point(50, 195), tfUsername.getPreferredSize()));

            //---- tfPassword ----
            tfPassword.setPreferredSize(new Dimension(200, 30));
            tfPassword.setBorder(null);
            panel1.add(tfPassword);
            tfPassword.setBounds(new Rectangle(new Point(50, 240), tfPassword.getPreferredSize()));

            //---- checkBox1 ----
            checkBox1.setText("\u8bb0\u4f4f\u5bc6\u7801");
            checkBox1.setBackground(new Color(0x002b2d30, true));
            checkBox1.setForeground(Color.white);
            checkBox1.setPreferredSize(new Dimension(80, 22));
            checkBox1.setFocusPainted(false);
            panel1.add(checkBox1);
            checkBox1.setBounds(new Rectangle(new Point(60, 280), checkBox1.getPreferredSize()));

            //---- checkBox2 ----
            checkBox2.setText("\u81ea\u52a8\u767b\u5f55");
            checkBox2.setBackground(new Color(0x002b2d30, true));
            checkBox2.setForeground(Color.white);
            checkBox2.setPreferredSize(new Dimension(80, 22));
            checkBox2.setFocusPainted(false);
            panel1.add(checkBox2);
            checkBox2.setBounds(new Rectangle(new Point(170, 280), checkBox2.getPreferredSize()));

            //---- btnLogin ----
            btnLogin.setText("\u9a6c\u4e0a\u767b\u5f55");
            btnLogin.setPreferredSize(new Dimension(90, 30));
            btnLogin.setBorder(null);
            btnLogin.setFocusPainted(false);
            panel1.add(btnLogin);
            btnLogin.setBounds(new Rectangle(new Point(105, 325), btnLogin.getPreferredSize()));

            //---- lbHead ----
            lbHead.setPreferredSize(new Dimension(60, 60));
            panel1.add(lbHead);
            lbHead.setBounds(new Rectangle(new Point(120, 120), lbHead.getPreferredSize()));

            //---- background ----
            background.setPreferredSize(new Dimension(300, 420));
            background.setIcon(new ImageIcon(getClass().getResource("/R-C.gif")));
            panel1.add(background);
            background.setBounds(0, -17, 330, 455);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1, "card1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JButton btnClose;
    private JButton btnMinimize;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JButton btnLogin;
    private JLabel lbHead;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
