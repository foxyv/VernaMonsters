/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 * A JPanel which will keep a given background image.
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

    /**
     * Constructor: set's the image to the passed image and then makes sure the panel is
     * transparent. Automatically calls repaint().
     * @param imageForPanel
     */
    public ImagePanel(Image imageForPanel) {
        super();
        this.setOpaque(false);
        this.imageForPanel = imageForPanel;
        repaint();


    }

    /**
     * Draws the image and then calls the super.paint function to refresh controls.
     */
    @Override
    public void paint(Graphics g) {
        g.drawImage(imageForPanel, 0, 0,(int)this.getBounds().getWidth(),(int)this.getBounds().getHeight(), this.getRootPane());
        super.paint(g);

    }


}
