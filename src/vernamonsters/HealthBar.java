/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vernamonsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 * A basic healthbar in a JPanel.
 * @author Sweord
 */
public class HealthBar extends JPanel{
    final static long serialVersionUID = 32l;
    float healthPercent;
    Color backGroundColor,frameColor;
    Image HealthBarFrame;
    Rectangle HealthBarRectangle;

    public HealthBar(float healthPercent) {
        this.healthPercent = healthPercent;
        this.setOpaque(false);
        backGroundColor = Color.BLACK;
        frameColor = Color.BLUE;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        HealthBarRectangle = this.getBounds();
        float w,h;
        w = (float)HealthBarRectangle.getWidth();
        h = (float)HealthBarRectangle.getHeight();

        g.setColor(frameColor);
        g.fillRoundRect(0, 0, (int)this.getBounds().getWidth(), (int)this.getBounds().getHeight(), 20, 50);

        g.setColor(backGroundColor);
        g.fillRect((int)(w*0.05),(int)(h*0.1),(int)(w*0.9),(int)(h*0.8));

        g.setColor(Color.green);
        g.fillRect((int)(w*0.05),(int)(h*0.15),(int)(w*0.9*healthPercent),(int)(h*0.7));
        
    }




}
