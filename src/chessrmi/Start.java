package chessrmi;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;

public class Start {
    public static void main(String[] args) {
        GameWindow sWindow = GameWindow.getInstance();
        Insets windowInsets = sWindow.window.getInsets();

        ChessStates chessStates = ChessStates.getInstance();
        sWindow.window.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                int posX = (e.getX() - windowInsets.left)/100;
                int posY = (e.getY() - windowInsets.top)/100;
                System.out.println(posX + " "+ posY);

            }
        });

    }
}