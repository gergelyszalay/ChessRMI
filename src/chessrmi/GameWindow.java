/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import javax.swing.JFrame;

/**
 *
 * @author Gege
 */
public class GameWindow {
    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
    JFrame window = new JFrame(); 
    public void AddCanvas(BoardCanvas canvas){
         window.getContentPane().add(canvas);
        
    }
    public void setLabel1(String name){
        jLabel1.setText(name);
    }
    public void setLabel2(String name){
        jLabel2.setText(name);
    }
    public GameWindow() {
        
       
        // setting closing operation 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // setting size of the pop window 
        window.setBounds(30, 30, 1000, 1000);
        
      //  jLabel1.setText("");
        window.add(jLabel1);
        jLabel3.setText(" VS ");
        window.add(jLabel3);
     //   jLabel2.setText("");
        window.add(jLabel2);
        window.setVisible(true);
        
    }
    
}
