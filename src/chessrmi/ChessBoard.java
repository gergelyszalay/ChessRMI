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
public class ChessBoard {

    
String ColorFigure="";
String NameFigure="";
int figureId;
boolean active=false;
boolean attackable=false;
boolean steppable=false;
public String colorField = "Light";
String playerColor="";


   public ChessBoard(String ColorFigure, int figureId) {
        this.ColorFigure = ColorFigure;
        this.figureId = figureId;
   }  
    public ChessBoard(String ColorFigure, String NameFigure, int figureId, String colorFie, boolean act, boolean attack, boolean stepp) {
        this.ColorFigure = ColorFigure;
        this.NameFigure = NameFigure;
        this.figureId = figureId;
        this.colorField= colorFie;
        this.attackable = attack;
        this.active = act;
        this.steppable = stepp;
    }
     public ChessBoard(String colorFie, boolean act, boolean attack, boolean stepp) {
        this.ColorFigure = "";
        this.NameFigure = "";
        this.figureId = 100;
        this.colorField= colorFie;
        this.attackable = attack;
        this.active = act;
        this.steppable = stepp;
    }

    




}
