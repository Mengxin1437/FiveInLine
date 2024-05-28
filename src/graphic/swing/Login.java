/*
 * Created by JFormDesigner on Tue May 21 16:16:29 CST 2024
 */

package graphic.swing;

import Xinxi.src.GameStorage;
import lianjei.Client;
import lianjei.Qidong;
import lianjei.Server;

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

    private void btnLogin(ActionEvent e) {
        Container container = this.getContentPane();
        CardLayout cardLayout = (CardLayout)container.getLayout();
        cardLayout.next(container);
        String chosenImage = lbHead.getText();
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        GameStorage.userStorage(username,password);
    }

    private void btnBack(ActionEvent e) {
        Container container = this.getContentPane();
        CardLayout cardLayout = (CardLayout)container.getLayout();
        cardLayout.previous(container);
    }

    private void juyuwangduizhan(ActionEvent e) {
        // TODO add your code here
        new Qidong().setVisible(true);
        Server server=new Server();
        server.startServer();
        Client client=new Client();
        client.startClient();
    }

    public boolean radioButton1(ActionEvent e) {
        // TODO add your code here
        if (radioButton1.isSelected()) {
            // 执行与你的单选按钮相关的操作
            return true; // 或者根据你的逻辑返回 true 或 false
        } else {
            return false;
        }
    }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        btnClose = new JButton();
        btnMinimize = new JButton();
        tfUsername = new JTextField();
        tfPassword = new JTextField();
        lbHead = new JLabel();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        btnLogin = new JButton();
        background = new JLabel();
        panel2 = new JPanel();
        btnMinimize2 = new JButton();
        btnClose2 = new JButton();
        button1 = new JButton();
        button2 = new JButton();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        btnBack = new JButton();
        background2 = new JLabel();

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

            //---- lbHead ----
            lbHead.setPreferredSize(new Dimension(60, 60));
            panel1.add(lbHead);
            lbHead.setBounds(new Rectangle(new Point(120, 120), lbHead.getPreferredSize()));

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
            btnLogin.addActionListener(e -> btnLogin(e));
            panel1.add(btnLogin);
            btnLogin.setBounds(new Rectangle(new Point(105, 325), btnLogin.getPreferredSize()));

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

        //======== panel2 ========
        {
            panel2.setPreferredSize(new Dimension(300, 420));
            panel2.setLayout(null);

            //---- btnMinimize2 ----
            btnMinimize2.setText("-");
            btnMinimize2.setFont(new Font("Inter", Font.PLAIN, 20));
            btnMinimize2.setPreferredSize(new Dimension(40, 25));
            btnMinimize2.setBackground(new Color(0x002b2d30, true));
            btnMinimize2.setForeground(Color.black);
            btnMinimize2.setBorder(null);
            btnMinimize2.setFocusPainted(false);
            btnMinimize2.addActionListener(e -> btnMinimize(e));
            panel2.add(btnMinimize2);
            btnMinimize2.setBounds(220, 0, 40, 25);

            //---- btnClose2 ----
            btnClose2.setText("\u00d7");
            btnClose2.setBackground(new Color(0x002b2d30, true));
            btnClose2.setForeground(Color.black);
            btnClose2.setBorder(null);
            btnClose2.setFocusPainted(false);
            btnClose2.setFont(new Font("Inter", Font.PLAIN, 20));
            btnClose2.setPreferredSize(new Dimension(40, 25));
            btnClose2.addActionListener(e -> btnClose(e));
            panel2.add(btnClose2);
            btnClose2.setBounds(260, 0, 40, 25);

            //---- button1 ----
            button1.setText("\u8054\u673a\u5bf9\u6218");
            button1.setPreferredSize(new Dimension(100, 30));
            button1.setBorder(null);
            button1.setBorderPainted(false);
            panel2.add(button1);
            button1.setBounds(105, 210, 100, 30);

            //---- button2 ----
            button2.setText("\u5c40\u57df\u7f51\u5bf9\u6218");
            button2.setPreferredSize(new Dimension(100, 30));
            button2.setBorder(null);
            button2.setBorderPainted(false);
            button2.addActionListener(e -> juyuwangduizhan(e));
            panel2.add(button2);
            button2.setBounds(105, 260, 100, 30);

            //---- radioButton1 ----
            radioButton1.setText("\u4e94\u5b50\u68cb");
            radioButton1.setForeground(Color.black);
            radioButton1.setBackground(new Color(0x000d4b7c, true));
            radioButton1.setFocusPainted(false);
            radioButton1.setSelected(true);
            radioButton1.addActionListener(e -> radioButton1(e));
            panel2.add(radioButton1);
            radioButton1.setBounds(75, 140, 70, 21);

            //---- radioButton2 ----
            radioButton2.setText("\u9ed1\u767d\u68cb");
            radioButton2.setForeground(Color.black);
            radioButton2.setBackground(new Color(0x000d4b7c, true));
            radioButton2.setFocusPainted(false);
            panel2.add(radioButton2);
            radioButton2.setBounds(180, 140, 70, 21);

            //---- btnBack ----
            btnBack.setText("\u2190\u8fd4\u56de");
            btnBack.setOpaque(false);
            btnBack.setBackground(new Color(0x002b2d30, true));
            btnBack.setFocusPainted(false);
            btnBack.setBorderPainted(false);
            btnBack.addActionListener(e -> btnBack(e));
            panel2.add(btnBack);
            btnBack.setBounds(0, 390, 70, btnBack.getPreferredSize().height);

            //---- background2 ----
            background2.setPreferredSize(new Dimension(300, 420));
            background2.setIcon(new ImageIcon(getClass().getResource("/R.gif")));
            panel2.add(background2);
            background2.setBounds(0, 0, 300, 420);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel2.getComponentCount(); i++) {
                    Rectangle bounds = panel2.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel2.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel2.setMinimumSize(preferredSize);
                panel2.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel2, "card2");
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JButton btnClose;
    private JButton btnMinimize;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JLabel lbHead;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JButton btnLogin;
    private JLabel background;
    private JPanel panel2;
    private JButton btnMinimize2;
    private JButton btnClose2;
    private JButton button1;
    private JButton button2;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton btnBack;
    private JLabel background2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
