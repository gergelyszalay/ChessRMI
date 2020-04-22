/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.rmi.*;

/**
 *
 * @author Gege
 */
public interface ChessService extends Remote {
    public String getPlayerName() throws RemoteException;
    String createClientPlayer(String namaPl) throws RemoteException;
    public String getColorF(int x, int y) throws RemoteException;
    public String getNameF(int x, int y) throws RemoteException;
   public int getFID(int x, int y) throws RemoteException;
   public String getColorField(int x, int y) throws RemoteException;
   public boolean getActive(int x, int y) throws RemoteException;
   public boolean getAttackable(int x, int y) throws RemoteException;
   public boolean getSteppable(int x, int y) throws RemoteException;
    
   
}
