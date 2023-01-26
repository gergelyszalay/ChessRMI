package chessrmi;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Board {
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Rectangle2D[][] a1 = new Rectangle2D[8][8];
        for (int a=0; a<8; a++){
            for (int b=0; b<8; b++){
                int x =a;
                int y = b;
                /*if("Black".equals(playerColor)){
                    x=7-a;
                    y=7-b;
                    //      System.out.println(x + " " + y);
                }*/
                a1[a][b] = new Rectangle2D.Float((a+1)*100, (b+1)*100, 100, 100);
               // field[x][y]=0;
                g2.setColor( Color.black );
                g2.draw(a1[a][b]);
                /*
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
                }*/
            }


        }
    }


    public Board(){

    }
}
