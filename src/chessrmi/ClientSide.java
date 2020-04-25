/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Gege
 */
public class ClientSide extends UnicastRemoteObject implements ClientService{

    String name4 = "";
    String b;
    int xA, yA, oldX, oldY;
    ChessBoard[][] board = new ChessBoard[8][8];
    MouseClick click;
    boolean next;
    BoardCanvas canvas2;
    ChessService impl;
    
    public static void clearField(ChessBoard[][] board) {
        for (int z = 0; z < 8; z++) {
            for (int w = 0; w < 8; w++) {

                board[z][w].active = false;
                board[z][w].attackable = false;
                board[z][w].steppable = false;
            }
        }

    }
    public void RefreshClient() throws RemoteException{
        System.out.println("hat ez muxik");
        board = refreshBoard(impl);
        canvas2.clearC();
    
    }
    public void SendIp(ClientSide clieent){  
        try {

            impl.ConnectClient(clieent);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    public static void Steppes(int activeX, int activeY, ChessBoard[][] board) {
        int x = activeX;
        int y = activeY;
        if ("Pawn".equals(board[x][y].NameFigure)) {
            if ("Black".equals(board[x][y].ColorFigure)) {
                if (board[x][y + 1].figureId == 100) {
                    if (y == 1) {
                        if (board[x][y + 2].figureId == 100) {
                            board[x][y + 2].steppable = true;
                        }
                    }

                    board[x][y + 1].steppable = true;
                }
                if (x > 0) {
                    if ("Black".equals(board[x - 1][y + 1].ColorFigure)) {
                        board[x - 1][y + 1].attackable = true;
                    }
                }
                if (x < 7) {
                    if ("Black".equals(board[x + 1][y + 1].ColorFigure)) {
                        board[x + 1][y + 1].attackable = true;
                    }
                }

            } else {
                if (board[x][y - 1].figureId == 100) {
                    if (y == 6) {
                        if (board[x][y - 2].figureId == 100) {
                            board[x][y - 2].steppable = true;
                        }
                    }
                    board[x][y - 1].steppable = true;
                }
                if (x > 0) {
                    if ("Black".equals(board[x - 1][y - 1].ColorFigure)) {
                        board[x - 1][y - 1].attackable = true;
                    }
                }
                if (x < 7) {
                    if ("Black".equals(board[x + 1][y - 1].ColorFigure)) {
                        board[x + 1][y - 1].attackable = true;
                    }
                }
            }
        }

        if ("Rock".equals(board[x][y].NameFigure)) {
            int i = x;
            int j = y;

            if (i != 7) {
                i++;
                while (i < 8 && board[i][y].figureId == 100) {
                    board[i][y].steppable = true;
                    i++;
                }
            }

            i = x;
            j = y;
            if (j != 0) {
                j--;
                while (j > 0 && board[x][j].figureId == 100) {
                    board[x][j].steppable = true;
                    j--;
                }
            }

        }

    }

    ChessBoard[][] refreshBoard(ChessService impl) throws RemoteException {
        for (int z = 0; z < 8; z++) {
            for (int w = 0; w < 8; w++) {
                String ColorF = impl.getColorF(z, w);

                String Colorfield = impl.getColorField(z, w);
                String NameF = impl.getNameF(z, w);
                int id = impl.getFID(z, w);
                boolean act = impl.getActive(z, w);
                boolean attack = impl.getAttackable(z, w);
                boolean stepp = impl.getSteppable(z, w);
                if (ColorF == null) {
                    board[z][w] = new ChessBoard(Colorfield, act, attack, stepp);

                } else {
                    board[z][w] = new ChessBoard(ColorF, NameF, id, Colorfield, act, attack, stepp);

                }

            }
        }
        return board;
    }

    public ClientSide(String namePl) throws InterruptedException, RemoteException {

        try {

            // fire to localhost port 1099
            Registry myRegistry = LocateRegistry.getRegistry("192.168.100.27", 1010);

            // search for myMessage service
             impl = (ChessService) myRegistry.lookup("ChessServer");
            click = new MouseClick(impl);
 
            // call server's method        
            b = impl.createClientPlayer(namePl);
            next = impl.PlayerNext();

            name4 = impl.getPlayerName();

            board = refreshBoard(impl);
           // SendIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        GameWindow sWindow2 = new GameWindow();
        sWindow2.setLabel1(name4);
        sWindow2.setLabel2(namePl);
        sWindow2.window.revalidate();

        canvas2 = new BoardCanvas(board, b);
        sWindow2.AddCanvas(canvas2);

        sWindow2.window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                int activeX = (e.getX() - 8) / 100;
                int activeY = (e.getY() - 31) / 100;
                xA = activeX - 1;
                yA = activeY - 1;
                if ("Black".equals(b)) {
                    xA = 7 - xA;
                    yA = 7 - yA;
                }
                try {
                    //activate figures
                    next = click.impl.PlayerNext();
                } catch (RemoteException ex) {
                    Logger.getLogger(ClientSide.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!next) {
                    if (board[xA][yA].ColorFigure.equals(b)) {
                        clearField(board);
                        oldX = xA;
                        oldY = yA;
                        board[xA][yA].active = true;
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
