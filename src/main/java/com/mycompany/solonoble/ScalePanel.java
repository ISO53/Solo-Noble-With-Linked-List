
package com.mycompany.solonoble;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author ISO53
 */
public class ScalePanel extends JPanel {

    int scaleValue; // 1 - 9+
    BufferedImage scaleImage;

    public ScalePanel() {
        super();

        scaleImage = null;
        try {
            scaleImage = ImageIO.read(this.getClass().getClassLoader().getResource("scale.png"));
        } catch (IOException ex) {
            Logger.getLogger(ScalePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(scaleImage, 0, 0, this);
    }
}
