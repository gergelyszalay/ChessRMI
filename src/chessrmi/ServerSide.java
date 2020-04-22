/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Gege
 */
public class ServerSide{
    
    


    public ServerSide(String namePl) {
        try {
        
       
            // create on port 1099
            Registry registry = LocateRegistry.createRegistry(1010);
             
            // create a new service named myMessage
            registry.rebind("ChessServer", new ServerService(namePl));
        } catch (Exception e) {
            e.printStackTrace();
        }     
        System.out.println("system is ready");  
        
        
      
     //   sWindow.getContentPane().add(canvas); 
    }
    
}
