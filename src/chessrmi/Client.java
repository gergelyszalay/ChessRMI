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
       
           /* // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1099);
             
            // create a new service named myMessage
            registry.rebind("ClientSer", new ClientSide(namePl));*/
        } catch (InterruptedException | RemoteException e) {
        }     
        System.out.println("system is ready");  
        
        
      
     //   sWindow.getContentPane().add(canvas); 
    }
}

