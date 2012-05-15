/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    Image BackGround;
    JPanel mainPanel;
    File backGroundSource;
    Rectangle TopLeft, TopRight, BottomLeft, BottomRight;
    ImagePanel backgroundPanel;
    HealthBar playerHealth, opponentHealth;
    Image PlayerPortrait, OpponentPortrait;

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

    private void Initialize() {
        try {
            //Set window parameters
            this.setLayout(null);
            this.setSize(640, 480);
            this.setVisible(true);
            this.setResizable(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("BATTLE!");
            
            //Load up the background image
            this.setBackGround("/vernamonsters/landscape2.png");
            this.setPlayerPortrait("/vernamonsters/landscape2.png");

            //Add the background panel
            backgroundPanel = new ImagePanel(BackGround);
            this.add(backgroundPanel);
            backgroundPanel.setBounds(this.getBounds());
            backgroundPanel.setLayout(null);

            //Add a healthbar to the background panel
            playerHealth = new HealthBar(1.0f);
            opponentHealth = new HealthBar(1.0f);

            backgroundPanel.add(playerHealth);
            backgroundPanel.add(opponentHealth);
            
            playerHealth.setBounds(10,(this.getHeight()/2),(int)(this.getWidth()*0.4),15);
            opponentHealth.setBounds((int)(this.getBounds().getWidth()/2),10,(int)(this.getWidth()*0.4),15);

            

            this.addComponentListener(BattleComponentListener);
            System.out.println("Painting");
            repaint();




        } catch (Exception ex) {
            Logger.getLogger(BattleScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setBackGround(Image BackGround) {
        this.BackGround = BackGround;
    }



    /**
     *
     * @param resource
     */
    public void setBackGround(String resource) {
        try {
            this.BackGround = ImageIO.read(this.getClass().getResource(resource));
        } catch (IOException ex) {
            Logger.getLogger(BattleScreen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void setPlayerPortrait(String resource) {
        try {
            this.PlayerPortrait = ImageIO.read(this.getClass().getResource(resource));
        } catch (IOException ex) {
            Logger.getLogger(BattleScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);



    }

    // <editor-fold defaultstate="collapsed" desc="Listener Implementations">
    WindowListener BattleWindowListener = new WindowListener() {

        public void windowOpened(WindowEvent e) {
            System.out.println("BattleWindow Opened");
            repaint();
        }

        public void windowClosing(WindowEvent e) {
            System.out.println("BattleWindow Closing");
            repaint();
        }

        public void windowClosed(WindowEvent e) {
            System.out.println("BattleWindow Closed");
            repaint();
        }

        public void windowIconified(WindowEvent e) {
            System.out.println("BattleWindow Iconified");
            repaint();
        }

        public void windowDeiconified(WindowEvent e) {
            System.out.println("BattleWindow DeIconified");
            repaint();
        }

        public void windowActivated(WindowEvent e) {
            System.out.println("BattleWindow Activated");
            repaint();
        }

        public void windowDeactivated(WindowEvent e) {
            System.out.println("BattleWindow Deactivated");
            repaint();
        }
    };
    ComponentListener BattleComponentListener = new ComponentListener() {

        public void componentResized(ComponentEvent e) {
            backgroundPanel.setBounds(getBounds());

            playerHealth.setBounds(10,(backgroundPanel.getHeight()/2),(int)(backgroundPanel.getWidth()*0.4),15);
            opponentHealth.setBounds((int)(backgroundPanel.getBounds().getWidth()/2),10,(int)(backgroundPanel.getWidth()*0.4),15);
            System.out.println("Resized!");
            repaint();
        }

        public void componentMoved(ComponentEvent e) {
            repaint();
        }

        public void componentShown(ComponentEvent e) {
            repaint();
        }


        public void componentHidden(ComponentEvent e) {
            repaint();
        }
    };

}// </editor-fold>

