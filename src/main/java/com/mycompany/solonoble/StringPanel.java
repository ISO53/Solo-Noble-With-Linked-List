
package com.mycompany.solonoble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import javax.swing.JPanel;

/**
 *
 * @author ISO53
 */
public class StringPanel extends JPanel {

    String string;
    Color stringColor;

    public StringPanel(String string, Color stringColor) {
        super();

        this.string = string;
        this.stringColor = stringColor;
        this.setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = g.getClipBounds().width;
        int h = g.getClipBounds().height;

        Graphics2D g2d = (Graphics2D) g;
        Stroke stroke = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke);
        g2d.setColor(stringColor);
        g2d.setFont(new Font("Century Gothic", Font.BOLD, w - 2));
        g2d.drawString(string, 0, (h - w + 2) / 2 + w - 6);
    }

}
