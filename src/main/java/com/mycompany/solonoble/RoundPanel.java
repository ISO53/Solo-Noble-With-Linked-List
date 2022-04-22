
package com.mycompany.solonoble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author ISO53
 */
public class RoundPanel extends JPanel {

    int radius;
    int thickness;
    int width;
    private Color color;
    Color nodeColor = new Color(180, 60, 60);
    Color brighterNodeColor = new Color(nodeColor.getRed() + 70, nodeColor.getGreen(), nodeColor.getBlue());
    Color darkerNodeColor = new Color(brighterNodeColor.getRed() - 70, nodeColor.getGreen(), nodeColor.getBlue());

    public RoundPanel(int radius, int thickness, Color color) {
        super();
        this.setOpaque(false);
        this.radius = radius;
        this.thickness = thickness;
        this.color = color;
    }

    public RoundPanel() {
        super();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(color);

        int w = g.getClipBounds().width;
        int h = g.getClipBounds().height;

        g2d.fillOval(0, 0, w - w / 3, h - h / 3);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        g2d.drawOval(0, 0, w - w / 3, h - h / 3);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void makeBrighter() {
        if (this.color.equals(nodeColor)) {
            color = brighterNodeColor;
        }
    }

    public void makeDarker() {
        if (this.color.equals(brighterNodeColor)) {
            color = darkerNodeColor;
        }
    }
}
