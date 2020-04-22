/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessrmi;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Gege
 */
public class ChessFigures extends JComponent{

    

    
    String colorF;
    public int positionX;
    public int positionY;
    boolean available;
    String name;
    BufferedImage img = null;

  
    
    public ChessFigures(String colorF, int positionX, int positionY, boolean available, String name) {
        this.colorF = colorF;
        this.positionX = positionX;
        this.positionY = positionY;
        this.available = available;
        this.name = name;
        if (name=="Pawn" && colorF=="Black"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_pdt60.png"));
            } catch (IOException e) {
            } 
        }else
        if (name=="Pawn" && colorF=="White"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_plt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="King" && colorF=="Black"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_kdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="King" && colorF=="White"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_klt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Queen" && colorF=="Black"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_qdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Queen" && colorF=="White"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_qlt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Bishop" && colorF=="Black"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_bdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Bishop" && colorF=="White"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_blt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Knight" && colorF=="Black"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_ndt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Knight" && colorF=="White"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_nlt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Rock" && colorF=="Black"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_rdt60.png"));
            } catch (IOException e) {
            } 
        }else
         if (name=="Rock" && colorF=="White"){
        try {
                this.img = ImageIO.read(new File("C:\\Users\\Gege\\Documents\\NetBeansProjects\\ChessRmi\\Pictures\\Chess_rlt60.png"));
            } catch (IOException e) {
            } 
        }
    }
}
