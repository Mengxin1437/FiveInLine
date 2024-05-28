/*
 * Created by JFormDesigner on Tue May 28 18:21:48 CST 2024
 */

package lianjei;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author JiaHaoTian
 */
public class Qidong extends JFrame {
    public Qidong() {
        initComponents();
    }

    public static void main(String[] args) {
        new Qidong().setVisible(true);
    }

    private void quxiaopipei(ActionEvent e) {
        // TODO add your code here
        ServerThread serverThread = new ServerThread();
        if (serverThread!=null&&serverThread.isAlive()){
            serverThread.interrupt();
        }
        dispose();


    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - 贾皓天
        button1 = new JButton();
        textField1 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u53d6\u6d88\u5339\u914d");
        button1.addActionListener(e -> quxiaopipei(e));

        //---- textField1 ----
        textField1.setText("\u5339\u914d\u4e2d.......\u8bf7\u8010\u5fc3\u7b49\u5f85");
        textField1.setFont(new Font("Microsoft YaHei UI", Font.BOLD | Font.ITALIC, 24));
        textField1.setForeground(new Color(0x999900));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(191, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(190, 190, 190))
                .addComponent(textField1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(44, 44, 44)
                    .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(55, 55, 55))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - 贾皓天
    private JButton button1;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
