/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

import static javax.swing.SwingConstants.TOP;

import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 * @author Gege
 */
public class GameWindow {
    private static GameWindow gameWindow;
    public static synchronized GameWindow getInstance(){
        if (gameWindow ==null){
            gameWindow = new GameWindow();
        }
        return gameWindow;
    }
    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    JTextField textF = new JTextField();
    JButton send2 = new JButton();

    public void setjLabel3(String text) {
        jLabel3.setText(text);
    }

    JFrame window = new JFrame();

    public void AddCanvas(BoardCanvas canvas) {
        window.getContentPane().add(canvas);

    }

    public void setLabel1(String name) {
        jLabel1.setText(name);
    }

    public void setLabel2(String name) {
        jLabel2.setText(name);
    }

    public GameWindow() {


        // setting closing operation 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setting size of the pop window 
        window.setBounds(30, 30, 1300, 1000);
        window.setResizable(false);
        window.add(new Board());



        /*
        //  jLabel1.setText("");
        //   window.add(jLabel1);
        jLabel3.setText(" VS ");

        jLabel3.setBounds(1000, 100, 200, 600);
        jLabel3.setOpaque(true);
        jLabel3.setBackground(Color.WHITE);
        jLabel3.setAutoscrolls(true);
        jLabel3.setBorder(new MatteBorder(null));
        jLabel3.setVerticalAlignment(TOP);

        window.add(jLabel3);
        //   jLabel2.setText("");
        Dimension size2 = textF.getPreferredSize();
        textF.setBounds(1000, 750, 200, size2.height);

        send2.setText("Send Message");
        Dimension size = send2.getPreferredSize();
        send2.setBounds(1050, 780, size.width, size.height);

        window.add(send2);
        window.add(textF);
        window.add(jLabel2);
        */
        window.setVisible(true);

    }

}
