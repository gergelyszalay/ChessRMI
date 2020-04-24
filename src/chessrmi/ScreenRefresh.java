/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gege
 */
public class ScreenRefresh extends Thread {

    private Thread t;
    private ChessService impl;
    private BoardCanvas canvas2;

    public ScreenRefresh(ChessService implIn, BoardCanvas canvas) {
        impl = implIn;
        System.out.println("Starting refresh");
        canvas2 = canvas;

    }

    public void run() {
        System.out.println("Running ");
        try {
            while (impl.PlayerNext()) {
                System.out.println(impl.PlayerNext());
                // Let the thread sleep for a while.
                Thread.sleep(50);
            }
            canvas2.clearC();
        } catch (InterruptedException e) {
            System.out.println("Thread  interrupted.");
        } catch (RemoteException ex) {
            Logger.getLogger(ScreenRefresh.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread  exiting.");

    }

    public void start() {

        t = new Thread(this);
        t.start();
    }
}
