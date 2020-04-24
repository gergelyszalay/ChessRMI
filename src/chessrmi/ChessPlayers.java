/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.util.Random;

/**
 *
 * @author Gege
 */
public class ChessPlayers {
    String name;
    String playerColor;
    boolean next=false;
    Random rand = new Random();
    public ChessPlayers(String name) {
        this.name = name;
       boolean colors = rand.nextBoolean();
       if(colors){
           this.playerColor = "White";
           this.next=true;
       }else{
           this.playerColor = "Black";
       }
    }
     public ChessPlayers(String name, String col) {
        this.name = name;
       this.playerColor=col;

    }
}
