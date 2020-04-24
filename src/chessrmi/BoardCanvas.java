/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Gege
 */
public class BoardCanvas extends JComponent {
    //ChessFigures[] figures;
    BufferedImage img = null;
    ChessBoard[][] board;
    String playerColor;
    public int activeF;
    public int[][] field = new int[9][9];
    public void clearC(){

        repaint();
    }
    public void test(int x, int y){
        System.out.println(board[x][y].active);
     //   repaint();
    }
    public BufferedImage getImage(String name, String colorF){
     //  System.out.println(name);
    if ("Pawn".equals(name) && "Black".equals(colorF)){
        
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_pdt60.png"));
            } catch (IOException e) {
            } 
        }else
        if ("Pawn".equals(name) && "White".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_plt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("King".equals(name) && "Black".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_kdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("King".equals(name) && "White".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_klt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Queen".equals(name) && "Black".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_qdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Queen".equals(name) && "White".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_qlt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Bishop".equals(name) && "Black".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_bdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Bishop".equals(name) && "White".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_blt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Knight".equals(name) && "Black".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_ndt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Knight".equals(name) && "White".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_nlt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Rock".equals(name) && "Black".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_rdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if ("Rock".equals(name) && "White".equals(colorF)){
        try {
                img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_rlt60.png"));
            } catch (IOException e) {
            } 
        }
    
    return img;
    }
    
    public void paint(Graphics g) 
    { 
       Graphics2D g2 = (Graphics2D) g;
       Rectangle2D[][] a1 = new Rectangle2D[8][8];
       for (int a=0; a<8; a++){
           for (int b=0; b<8; b++){
               int x =a;
               int y = b;
               if("Black".equals(playerColor)){
               x=7-a;
               y=7-b;
             //      System.out.println(x + " " + y);
               }
                a1[a][b] = new Rectangle2D.Float((a+1)*100, (b+1)*100, 100, 100);
                field[x][y]=0;
                g2.setColor( Color.black );
                g2.draw(a1[a][b]);
            //    System.out.println(board[x][y].attackable);
             //   System.out.println(board[x][y].active);
                if (board[x][y].active==true){
                    g2.setColor( Color.blue);
                    g2.fill(a1[a][b]);
                    System.out.println("2");
                
                }else if (board[x][y].steppable==true){
                    g2.setColor( Color.YELLOW);
                    g2.fill(a1[a][b]);
                //    System.out.println("3");
                
                }else if (board[x][y].attackable==true){
                    g2.setColor( Color.pink);
                    g2.fill(a1[a][b]);
               //     System.out.println("4");
                
                }else if ("Dark".equals(board[x][y].colorField)){
                    g2.setColor( Color.lightGray );
                    g2.fill(a1[a][b]);
                  //  System.out.println("5");
                }
             //   System.out.println("6");
                if(!"".equals(board[x][y].NameFigure)){
                    
                    BufferedImage img2= getImage(board[x][y].NameFigure, board[x][y].ColorFigure);
                 //   System.out.println(board[x][y].NameFigure + " " + ((a+1)*100)+20 + " " + ((a+1)*100)+20);
                    if(img2!=null){
                      
                    //    System.out.println(x+ " " + y); 
                         g2.drawImage(img2, (a+1)*100+20, (b+1)*100+20, null);
                       
                    }
                }
            }
        
      /*  for(int i=0; i<figures.length; i++){
            g2.drawImage(figures[i].img, figures[i].positionX*100+20, figures[i].positionY*100+20, null);
            field[figures[i].positionX][figures[i].positionY]=i;
        }*/
        }
    } 
    public BoardCanvas(ChessBoard[][] boardIn, String playerColor) {
       // this.figures = (ChessFigures[]) figures;
        this.board= (ChessBoard[][]) boardIn;
        this.playerColor =  playerColor;
        System.out.println(playerColor);
    }
}
