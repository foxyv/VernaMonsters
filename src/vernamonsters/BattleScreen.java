/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *  A JFrame object which displays and allows management of the current battle.
 * @author Sweord
 */
public class BattleScreen extends JFrame {

    final static long serialVersionUID = 60l;

    //Declarations of class wide objects
    String Title;
    BattleScreenComponentListener BattleComponentListener;
    ResourceMap BattleResources;
    ImagePanel backgroundPanel;
    HealthBar playerHealth, opponentHealth;

    private void Initialize() {
        try {
            //Set window parameters
            this.setLayout(null);
            this.setSize(640, 480);
            this.setVisible(true);
            this.setResizable(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle(Title);

            //Load up the images for Battle Resources into a new ResourceMap
            BattleResources = new ResourceMap();
            BattleResources.addImage("/vernamonsters/landscape2.png", "Background");
            BattleResources.addImage("/vernamonsters/landscape2.png", "Player Portrait");

            //Add the background panel
            backgroundPanel = new ImagePanel(BattleResources.getImage("Background"));
            this.add(backgroundPanel);
            resizeBackground();
            backgroundPanel.setLayout(null);

            //Add a healthbar to the background panel
            playerHealth = new HealthBar(0.2f);
            opponentHealth = new HealthBar(1.0f);
            backgroundPanel.add(playerHealth);
            backgroundPanel.add(opponentHealth);

            playerHealth.setBounds(10, (this.getHeight() / 2), (int) (this.getWidth() * 0.4), 15);
            opponentHealth.setBounds((int) (this.getBounds().getWidth() / 2), 10, (int) (this.getWidth() * 0.4), 15);


            BattleComponentListener = new BattleScreenComponentListener(this);
            this.addComponentListener(BattleComponentListener);
            System.out.println("Painting");
            repaint();




        } catch (Exception ex) {
            Logger.getLogger(BattleScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//END OF Initialize


    /**
     * Reset the size of the background panel to the bounds of the battle screen.
     */
    private void resizeBackground() {
        backgroundPanel.setBounds(0, 0, this.getWidth(), this.getHeight());
    }//END OF resizeBackground

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Load the battlescreen with the given title and GraphicsConfiguration.
     * Calls super function for parent class "JFrame" and then calls the Initialize function.
     * @param title The title which will appear in the titlebar.
     * @param gc The graphics configuration which the Frame will use.
     */
    public BattleScreen(String title, GraphicsConfiguration gc) {
        super(title, gc);
        Title = title;
        Initialize();

    }

    /**
     * Load the battlescreen with the given title.
     * Calls super function for parent class "JFrame" and then calls the Initialize function.
     * @param title The title which will appear in the titlebar.
     * @throws HeadlessException
     */
    public BattleScreen(String title) throws HeadlessException {
        super(title);
        Title = title;
        Initialize();
    }

    /**
     * Load the battlescreen with the given Graphics Configuration.
     * Calls super function for parent class "JFrame" and then calls the Initialize function.
     * @param gc The graphics configuration used by the frame.
     */
    public BattleScreen(GraphicsConfiguration gc) {
        super(gc);
        Initialize();
    }

    /**
     * Load the battlescreen.
     * Calls super function for parent class "JFrame" and then calls the Initialize function.
     * @throws HeadlessException
     */
    public BattleScreen() throws HeadlessException {
        super();
        Initialize();
    }// </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="ComponentListener Implementation">
    
    class BattleScreenComponentListener implements ComponentListener {

        BattleScreen outer;

        public BattleScreenComponentListener(BattleScreen outer) {
            super();
            this.outer = outer;
        }

        public void componentResized(ComponentEvent e) {
            outer.resizeBackground();
            outer.playerHealth.setBounds(10, outer.backgroundPanel.getHeight() / 2, (int) (outer.backgroundPanel.getWidth() * 0.4), 15);
            outer.opponentHealth.setBounds((int) (outer.backgroundPanel.getBounds().getWidth() / 2), 10, (int) (outer.backgroundPanel.getWidth() * 0.4), 15);
            System.out.println("Resized!");
            repaint();
        }

        public void componentMoved(ComponentEvent e) {
            repaint();
        }

        public void componentShown(ComponentEvent e) {
            outer.resizeBackground();
            repaint();
        }

        public void componentHidden(ComponentEvent e) {
            repaint();
        }
    }
    // </editor-fold>

}//END OF CLASS DECLARATION BattleScreen
