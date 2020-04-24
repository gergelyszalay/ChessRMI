/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import static chessrmi.ChessRmi.Steppes;
import static chessrmi.ChessRmi.clearField;
import static chessrmi.ChessRmi.makeStepp;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Gege
 */
public class ClientSide {
    String name4="";
    String b;
    int xA, yA, oldX, oldY;
    ChessBoard[][] board = new ChessBoard[8][8];
    MouseClick click;
    boolean next;
    public static void clearField(ChessBoard[][] board) {
        for (int z = 0; z < 8; z++) {
            for (int w = 0; w < 8; w++) {

                board[z][w].active = false;
                board[z][w].attackable = false;
                board[z][w].steppable = false;
            }
        }

    }
   public void makeStepp2(int activeX, int activeY, int xA, int yA, ChessService impl) throws RemoteException {
   //    System.out.println("mi a ???");
            impl.makeStepp(activeX, activeY, xA, yA);
        
       
   }
   
    public static void Steppes(int activeX, int activeY, ChessBoard[][] board){
        int x= activeX;
        int y= activeY;  
        if("Pawn".equals(board[x][y].NameFigure)){
            if ("Black".equals(board[x][y].ColorFigure)){
             if (board[x][y+1].figureId==100){
                if (y == 1){
                    if (board[x][y+2].figureId==100){
                        board[x][y+2].steppable=true;
                    }
                }
                
                board[x][y+1].steppable=true;
            }
            if(x>0){
                if ("Black".equals(board[x-1][y+1].ColorFigure)){
                    board[x-1][y+1].attackable=true;
                }
            }    
            if(x<7){
                if ("Black".equals(board[x+1][y+1].ColorFigure)){
                    board[x+1][y+1].attackable=true;
                }
            }
            
            
            }else{
            if (board[x][y-1].figureId==100){
                if (y == 6){
                    if (board[x][y-2].figureId==100){
                        board[x][y-2].steppable=true;
                    }
                }
                board[x][y-1].steppable=true;
            }
            if(x>0){
                if ("Black".equals(board[x-1][y-1].ColorFigure)){
                    board[x-1][y-1].attackable=true;
                }
            }    
            if(x<7){
                if ("Black".equals(board[x+1][y-1].ColorFigure)){
                    board[x+1][y-1].attackable=true;
                }
            }
            }
        }
        
        if("Rock".equals(board[x][y].NameFigure)){
            int i=x;
            int j=y;
            
            if(i!=7){
                i++;
                while(i<8 && board[i][y].figureId==100){
                    board[i][y].steppable=true;
                    i++;
                }
            }
            
            i=x;
            j=y;
            if(j!=0){
                j--;
                while(j>0 && board[x][j].figureId==100){
                    board[x][j].steppable=true;
                    j--;
                }
            }

        }
        
    }
    ChessBoard[][] refreshBoard(ChessService impl) throws RemoteException{
        for (int z=0; z<8; z++){
               for (int w=0; w<8; w++){
                   String ColorF = impl.getColorF(z, w);
                   
                   String Colorfield = impl.getColorField(z, w);
                   String NameF = impl.getNameF(z, w);
                   int id = impl.getFID(z, w);
                   boolean act = impl.getActive(z, w);
                   boolean attack = impl.getAttackable(z, w);
                   boolean stepp = impl.getSteppable(z, w);
                   if(ColorF==null){
                    board[z][w]= new ChessBoard( Colorfield, act, attack, stepp);
                 
                   }else {
                   board[z][w]= new ChessBoard(ColorF, NameF, id, Colorfield, act, attack, stepp);
                  
                   }
                   
               }
        }       
    return board;
    }
    public ClientSide(String namePl) {
        
        try {

            // fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry("192.168.100.27", 1010);

            // search for myMessage service
          ChessService impl = (ChessService) myRegistry.lookup("ChessServer");
          click = new MouseClick(impl);
      //      System.out.println(click.impl.getColorF(1, 1));
            // call server's method        
            b=impl.createClientPlayer(namePl);
            next = impl.PlayerNext();
       //     System.out.println(b);
            name4 = impl.getPlayerName();
       //     System.out.println(name4);

            board = refreshBoard(impl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameWindow sWindow2 = new GameWindow();
        sWindow2.setLabel1(name4);
        sWindow2.setLabel2(namePl);
        System.out.println(b);
        BoardCanvas canvas2 = new BoardCanvas(board,b);
        sWindow2.AddCanvas(canvas2);

        sWindow2.window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                int activeX = (e.getX() - 8) / 100;
                int activeY = (e.getY() - 31) / 100;
                xA = activeX - 1;
                    yA = activeY - 1;
                    if("Black".equals(b)){
                        xA = 7-xA;
                        yA = 7-yA;
                    }
                //activate figures
                if(!next){
                if (board[xA][yA].ColorFigure.equals(b)) {
                    clearField(board);
                    oldX = xA;
                    oldY = yA;
                    board[xA][yA].active = true;
                    System.out.println(board[xA][yA].active);
                    Steppes(xA, yA, board);
                    canvas2.clearC();
                   
                }
                //make a stepp
                if (board[xA][yA].steppable == true || board[xA][yA].attackable == true) {
                    try {
                        clearField(board);
                
                        click.impl.makeStepp(xA, yA, oldX, oldY);                    
                        board = refreshBoard(click.impl);
                        canvas2.clearC();
                    } catch (RemoteException ex) {
                        Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  
          
                }
                    //click on an empty field
                    if (board[xA][yA].active == false && board[xA][yA].steppable == false) {
                        clearField(board);
                        canvas2.clearC();
                    }

                
                }
            }
        });
    }
}
