/*
 * Created by JFormDesigner on Wed May 29 14:09:04 CST 2024
 */

package lianjei;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author JiaHaoTian
 */
public class Duijutanchang extends JFrame {
    public Duijutanchang() {
        initComponents();
    }

    private void jiaru(ActionEvent e) {
        // TODO add your code here
        Client client=new Client();
        client.startClient();
        GameThread gameThread=new GameThread();
        /*if (gameThread.isAlive()){

        }*/
    }

    private void chuangjian(ActionEvent e) {
        // TODO add your code here
        new Qidong().setVisible(true);
        Server server=new Server();
        server.startServer();
        GameThread gameThread=new GameThread();
        if (gameThread.isAlive()){
        Client client=new Client();
        client.startClient();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - 贾皓天
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- button1 ----
        button1.setText("\u52a0\u5165\u5bf9\u5c40");
        button1.addActionListener(e -> jiaru(e));

        //---- button2 ----
        button2.setText("\u521b\u5efa\u5bf9\u5c40");
        button2.addActionListener(e -> chuangjian(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(118, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(115, 115, 115))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(57, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - 贾皓天
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
