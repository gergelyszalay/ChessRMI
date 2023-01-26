package chessrmi;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Board extends JComponent {
    public Board() {
        Border padding = BorderFactory.createEmptyBorder(0, 0, 0, 0);
        this.setBorder(padding);
    }

    public BufferedImage getImage(String name) {
        BufferedImage img = null;
        try {
            String fileName = "Chess_" + Character.hashCode(name.charAt(0)) + ".png";
            String imageURL = ChessRmi.class.getResource(fileName).getFile();
            img = ImageIO.read(new File(imageURL));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public void paint(Graphics g) {
        super.paint(g);
        ChessStates chessStates = ChessStates.getInstance();
        String[][] boardState = chessStates.getBoardArray();
        for (int a = 0; a < 8; a++) {
            for (int b = 0; b < 8; b++) {
                g.setColor(Color.lightGray);
                if ((a + b) % 2 == 0) {
                    g.fillRect((a + 1) * 100, (b + 1) * 100, 100, 100);
                }
                g.drawRect((a + 1) * 100, (b + 1) * 100, 100, 100);
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int z = 0; z < 8; z++) {
                if (boardState[i][z] != null) {
                    g.setColor(Color.black);
                    BufferedImage img2 = getImage(boardState[i][z]);
                    g.drawImage(img2, (z + 1) * 100 + 20, (i + 1) * 100 + 20, null);
                }
            }
        }
    }
}
