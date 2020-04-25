/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Gege
 */
public interface ClientService extends Remote{
   public void RefreshClient() throws RemoteException; 
}
