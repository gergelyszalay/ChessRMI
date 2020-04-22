/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

/**
 *
 * @author Gege
 */


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerService extends UnicastRemoteObject implements ChessService, java.io.Serializable{
   public ChessPlayers serverPl;
   public  ChessPlayers clientPl;
   ChessBoard[][] board;

    
   @Override
   public String createClientPlayer(String namePl) throws RemoteException{
        if(serverPl.playerColor=="Black"){
            clientPl = new ChessPlayers(namePl, "White");
            return "White";
        }else{
            clientPl = new ChessPlayers(namePl, "Black");
           return "Black"; 
           
            
        }  
    }
   @Override
   public String getPlayerName() throws RemoteException{
      
    return serverPl.name;
}
   
   public String getColorF(int x, int y) throws RemoteException{
     return board[x][y].ColorFigure;
   }
   public String getNameF(int x, int y) throws RemoteException{
     return board[x][y].NameFigure;
   }
   public int getFID(int x, int y) throws RemoteException{
     return board[x][y].figureId;
   }
   public String getColorField(int x, int y) throws RemoteException{
     return board[x][y].colorField;
   }
   public boolean getActive(int x, int y) throws RemoteException{
     return board[x][y].active;
   }
   public boolean getAttackable(int x, int y) throws RemoteException{
     return board[x][y].attackable;
   }
   public boolean getSteppable(int x, int y) throws RemoteException{
     return board[x][y].steppable;
   }
   ChessBoard[][]createBoard(String plColor){
     ChessBoard[][] board = new ChessBoard[8][8];
        for (int z=0; z<8; z++){
           for (int w=0; w<8; w++){
                
               board[z][w] = new ChessBoard("",0);
                if(plColor == "White"){
                    if ((z+w)%2!=0){
                        board[z][w].colorField="Dark";
                    }
                }else{
                    if ((z+w)%2==0){
                        board[z][w].colorField="Dark";
                    }
                }  
           }
        }   
   // ChessFigures[] figures = new ChessFigures[33];
        
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
            if(plColor == "Black"){
                //x=9;
                y=9-y;
            }
            board[x-1][y-1].NameFigure= name;
            board[x-1][y-1].ColorFigure = colorF;
            board[x-1][y-1].figureId=i;
           // figures[i+1]= new ChessFigures(colorF, x, y, true, name);
        }
    return board;    
    }




   
    
    
    
    public ServerService(String namePl) throws RemoteException{
        serverPl = new ChessPlayers(namePl);
    
     GameWindow sWindow = new GameWindow();
        board =(ChessBoard[][]) createBoard(serverPl.playerColor);
        BoardCanvas canvas = new BoardCanvas(board);
        sWindow.AddCanvas(canvas);
        System.out.println(serverPl.playerColor);
      
}
}
