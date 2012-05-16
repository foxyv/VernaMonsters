/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sweord
 */
public class BattleScreen extends JFrame {

    final static long serialVersionUID = 60l;
    ImagePanel backgroundPanel;
    HealthBar playerHealth, opponentHealth;
    ResourceMap BattleResources;

    


    private void Initialize() {
        try {
            //Set window parameters
            this.setLayout(null);
            this.setSize(640, 480);
            this.setVisible(true);
            this.setResizable(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("BATTLE!");

            //Load up the images and initialize the battle resources
            BattleResources = new ResourceMap();
            BattleResources.addImage("/vernamonsters/landscape2.png","Background");
            BattleResources.addImage("/vernamonsters/landscape2.png","Player Portrait");

            //Add the background panel
            backgroundPanel = new ImagePanel(BattleResources.getImage("Background"));
            this.add(backgroundPanel);
            resizeBackground();
            backgroundPanel.setLayout(null);

            //Add a healthbar to the background panel
            playerHealth = new HealthBar(1.0f);
            opponentHealth = new HealthBar(1.0f);

            backgroundPanel.add(playerHealth);
            backgroundPanel.add(opponentHealth);

            playerHealth.setBounds(10, (this.getHeight() / 2), (int) (this.getWidth() * 0.4), 15);
            opponentHealth.setBounds((int) (this.getBounds().getWidth() / 2), 10, (int) (this.getWidth() * 0.4), 15);



            this.addComponentListener(BattleComponentListener);
            System.out.println("Painting");
            repaint();




        } catch (Exception ex) {
            Logger.getLogger(BattleScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void resizeBackground(){
        backgroundPanel.setBounds(0,0,this.getWidth(),this.getHeight());
    }
    
    // <editor-fold defaultstate="collapsed" desc="Listener Implementations">
    ComponentListener BattleComponentListener = new ComponentListener() {

        public void componentResized(ComponentEvent e) {
            resizeBackground();
            playerHealth.setBounds(10, (backgroundPanel.getHeight() / 2), (int) (backgroundPanel.getWidth() * 0.4), 15);
            opponentHealth.setBounds((int) (backgroundPanel.getBounds().getWidth() / 2), 10, (int) (backgroundPanel.getWidth() * 0.4), 15);
            System.out.println("Resized!");
            repaint();
        }

        public void componentMoved(ComponentEvent e) {
            repaint();
        }

        public void componentShown(ComponentEvent e) {
            resizeBackground();
            repaint();
        }

        public void componentHidden(ComponentEvent e) {
            repaint();
        }
    };
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public BattleScreen(String title, GraphicsConfiguration gc) {
        super(title, gc);
        Initialize();

    }

    public BattleScreen(String title) throws HeadlessException {
        super(title);
        Initialize();
    }

    public BattleScreen(GraphicsConfiguration gc) {
        super(gc);
        Initialize();
    }

    public BattleScreen() throws HeadlessException {
        super();
        Initialize();
    }// </editor-fold>

}
