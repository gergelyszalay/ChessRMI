/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Gege
 */
public class Client {
     public Client(String namePl) {
      try {
        ClientSide clieent = new ClientSide(namePl);
        clieent.SendIp(clieent);
       
        } catch (InterruptedException | RemoteException e) {
        }     
        System.out.println("system is ready");  
        
    }
}

