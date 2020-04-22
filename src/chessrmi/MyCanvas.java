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
public class MyCanvas extends JComponent { 
    
    ChessFigures[] figures;
    ChessBoard[][] board;
    public int activeF;
    public int[][] field = new int[9][9];
    public void clearC(){
        repaint();
    }
    
    public void paint(Graphics g) 
    { 
       Graphics2D g2 = (Graphics2D) g;
       Rectangle2D[][] a1 = new Rectangle2D[8][8];
       for (int x=0; x<8; x++){
           for (int y=0; y<8; y++){
                a1[x][y] = new Rectangle2D.Float((x+1)*100, (y+1)*100, 100, 100);
                field[x][y]=0;
                g2.setColor( Color.black );
                g2.draw(a1[x][y]);
                if (board[x][y].active==true){
                    g2.setColor( Color.blue);
                    g2.fill(a1[x][y]);
                
                }else if (board[x][y].steppable==true){
                    g2.setColor( Color.YELLOW);
                    g2.fill(a1[x][y]);
                
                }else if (board[x][y].attackable==true){
                    g2.setColor( Color.pink);
                    g2.fill(a1[x][y]);
                
                }else
                    
                
                if (board[x][y].colorField=="Dark"){
                    g2.setColor( Color.lightGray );
                    g2.fill(a1[x][y]);
                }
            }
        
        for(int i=0; i<figures.length; i++){
            g2.drawImage(figures[i].img, figures[i].positionX*100+20, figures[i].positionY*100+20, null);
            field[figures[i].positionX][figures[i].positionY]=i;
        }
        }
    } 
    public MyCanvas(ChessFigures[] figures, ChessBoard[][] boardIn) {
        this.figures = (ChessFigures[]) figures;
        
        this.board= (ChessBoard[][]) boardIn;
    }
} 
  
