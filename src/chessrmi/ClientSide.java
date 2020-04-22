/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.rmi.RemoteException;
import java.rmi.registry.*;


/**
 *
 * @author Gege
 */
public class ClientSide {
    String name="";
    ChessBoard[][] board = new ChessBoard[8][8];
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
                    board[z][7-w]= new ChessBoard( Colorfield, act, attack, stepp);
                 
                   }else {
                   board[z][7-w]= new ChessBoard(ColorF, NameF, id, Colorfield, act, attack, stepp);
                  
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
         
            // call server's method        
         String b = impl.createClientPlayer(namePl);
          String name = impl.getPlayerName();
          System.out.println(name);
             
            board = refreshBoard(impl);
        } catch (Exception e) {
            e.printStackTrace();
        }       
    
    GameWindow sWindow2 = new GameWindow();
    sWindow2.setLabel1(name);
    sWindow2.setLabel2(namePl);
    BoardCanvas canvas2 = new BoardCanvas(board);
    sWindow2.AddCanvas(canvas2);
  }
}

