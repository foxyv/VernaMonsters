/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author Sweord
 */
public class ImagePanel extends JPanel {

    final static long serialVersionUID = 13l;
    Image imageForPanel;

    public Image getImageForPanel() {
        return imageForPanel;
    }

    public void setImageForPanel(Image imageForPanel) {
        this.imageForPanel = imageForPanel;
        repaint();
    }

    public ImagePanel(Image imageForPanel) {
        super();
        this.imageForPanel = imageForPanel;
        repaint();


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(imageForPanel, 0, 0,(int)this.getBounds().getWidth(),(int)this.getBounds().getHeight(), this);
    }


}
