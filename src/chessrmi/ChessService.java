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

    public void ConnectClient(ClientService n) throws RemoteException;

    public void makeStepp(int activeX, int activeY, int xA, int yA) throws RemoteException;
    public void setLabel(String newT, int elso) throws RemoteException;
    public void setLabel(String newT) throws RemoteException;

    public String getPlayerName() throws RemoteException;

    public String createClientPlayer(String namaPl) throws RemoteException;

    public boolean PlayerNext() throws RemoteException;

    public String getColorF(int x, int y) throws RemoteException;

    public String getNameF(int x, int y) throws RemoteException;

    public int getFID(int x, int y) throws RemoteException;

    public String getColorField(int x, int y) throws RemoteException;

    public String getLabel() throws RemoteException;

    public boolean getActive(int x, int y) throws RemoteException;

    public boolean getAttackable(int x, int y) throws RemoteException;

    public boolean getSteppable(int x, int y) throws RemoteException;

}
