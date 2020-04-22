/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author Gege
 */
public class ChessRmi{
    
    
    public static void makeStepp(int activeX, int activeY, ChessBoard[][] board, ChessFigures[] figures){
     for (int z=0; z<8; z++){
           for (int w=0; w<8; w++){
                if(board[z][w].active==true){
                    board[activeX-1][activeY-1].ColorFigure =board[z][w].ColorFigure;
                    board[activeX-1][activeY-1].NameFigure =board[z][w].NameFigure;
                    board[z][w].active=false;
                    board[z][w].ColorFigure="";
                    board[z][w].NameFigure="";
                    
                    
                    figures[board[z][w].figureId].positionX=activeX;
                    figures[board[z][w].figureId].positionY=activeY;
                    
                    board[activeX-1][activeY-1].figureId =board[z][w].figureId;
                    board[z][w].figureId=0;
                    

                }
                   
                   board[z][w].attackable=false;
                   board[z][w].steppable=false;
             }    
           }    
    
    }
 
 
    public static void Steppes(int activeX, int activeY, ChessBoard[][] board){
        int x= activeX-1;
        int y= activeY-1;
        if(board[x][y].NameFigure=="Pawn"){
            if (board[x][y-1].figureId==0){
                if (y == 6){
                    if (board[x][y-2].figureId==0){
                        board[x][y-2].steppable=true;
                    }
                }
                board[x][y-1].steppable=true;
            }
            if(x>0){
                if (board[x-1][y-1].ColorFigure=="Black"){
                    board[x-1][y-1].attackable=true;
                }
            }    
            if(x<7){
                if (board[x+1][y-1].ColorFigure=="Black"){
                    board[x+1][y-1].attackable=true;
                }
            }    
        }
        
        if(board[x][y].NameFigure=="Rock"){
            int i=x;
            int j=y;
            
            if(i!=7){
                i++;
                while(i<8 && board[i][y].figureId==0){
                    board[i][y].steppable=true;
                    i++;
                }
            }
            
            i=x;
            j=y;
            if(j!=0){
                j--;
                while(j>0 && board[x][j].figureId==0){
                    board[x][j].steppable=true;
                    j--;
                }
            }

        }
        
    }
       public static void clearField(ChessBoard[][] board){
            for (int z=0; z<8; z++){
           for (int w=0; w<8; w++){
                
             
                   board[z][w].active=false;
                    board[z][w].attackable=false;
                     board[z][w].steppable=false;
             }    
           }
        
    }
    

    /**
     * @param args the command line arguments
     */
  
    public static void main(String[] args) {
        
        
        ChessBoard[][] board = new ChessBoard[8][8];
        for (int z=0; z<8; z++){
           for (int w=0; w<8; w++){
                
               board[z][w] = new ChessBoard("",0);
               if ((z+w)%2!=0){
                   board[z][w].colorField="Dark";
               }
             }    
           }
         
        
        
        
         // creating object of JFrame(Window popup) 
        JFrame window = new JFrame(); 
       
        // setting closing operation 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
        // setting size of the pop window 
        window.setBounds(30, 30, 1000, 1000); 
        ChessFigures[] figures = new ChessFigures[32];
        
        int x=0;
        int y=0;
        String name="";
        String colorF="";
        for(int i=0; i<32; i++){
            if (i<16){
                name="Pawn";
                if(i<8){
                    y=7;
                    x=i+1;
                    colorF="White";
                }else{
                    y=2;
                    x=i-7;
                    colorF="Black";
                }

            }else if (i<20){
                name="Rock";
                if(i<18){
                    y=8;
                    x=i%16*7+1;
                    colorF="White";
                }else{
                    y=1;
                    x=i%18*7+1;
                    colorF="Black";
                }

            }else if (i<24){
                name="Knight";
                if(i<22){
                    y=8;
                    x=i%20*5+2;
                    colorF="White";
                }else{
                    y=1;
                    x=i%22*5+2;
                    colorF="Black";
                }

            }else if (i<28){
                name="Bishop";
                if(i<26){
                    y=8;
                    x=i%24*3+3;
                    colorF="White";
                }else{
                    y=1;
                    x=i%26*3+3;
                    colorF="Black";
                }

            }else if (i<30){
                name="Queen";
                if(i<29){
                    y=8;
                    x=4;
                    colorF="White";
                }else{
                    y=1;
                    x=4;
                    colorF="Black";
                }

            }
            else{
                name="King";
                if(i<31){
                    y=8;
                    x=5;
                    colorF="White";
                }else{
                    y=1;
                    x=5;
                    colorF="Black";
                }

            }
            board[x-1][y-1].NameFigure= name;
            board[x-1][y-1].ColorFigure = colorF;
            board[x-1][y-1].figureId=i;
            figures[i]= new ChessFigures(colorF, x, y, true, name);
        }
         
        
        
        
        // setting canvas for draw 
        MyCanvas canvas = new MyCanvas(figures, board);
        window.getContentPane().add(canvas); 
       
        
        window.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                    int activeX = (e.getX()-8) /100;
                    int activeY = (e.getY()-31)/100;
                    if(board[activeX-1][activeY-1].ColorFigure=="White"){ 
                        board[activeX-1][activeY-1].active=true;
                        Steppes(activeX, activeY, board);
                        canvas.clearC();
                    }
                    if(board[activeX-1][activeY-1].steppable==true || board[activeX-1][activeY-1].attackable==true){
                        makeStepp(activeX, activeY, board, figures);
                         canvas.clearC();
                    }
                    if(board[activeX-1][activeY-1].active==false && board[activeX-1][activeY-1].steppable==false){
                        clearField(board);
                        canvas.clearC();
                    } 
                    
            }
        });
  
        // set visibility 
        window.setVisible(true); 
    } 
    
    
     
 }
    

