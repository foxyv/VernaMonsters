/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
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
            this.setSize(640, 480);
            this.setVisible(true);
            this.setResizable(false);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setTitle("BATTLE!");

            //Load up the background image
            this.setBackGround("/vernamonsters/landscape2.png");

            //Initialize the background panel
            backgroundPanel = new ImagePanel(BackGround);
            backgroundPanel.setBounds(this.getBounds());

            YourBattlePanel rawr = new YourBattlePanel();
            rawr.setBounds(this.getBounds());
            rawr.setOpaque(true);
            
            //this.add(rawr);
            this.add(backgroundPanel);
            backgroundPanel.setVisible(true);

            //add listeners
            this.addWindowListener(BattleWindowListener);
            this.addComponentListener(BattleComponentListener);




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



    @Override
    public void paint(Graphics g) {

        super.paintComponents(g);
        
        

    }
    WindowListener BattleWindowListener = new WindowListener() {

        public void windowOpened(WindowEvent e) {
            System.out.println("BattleWindow Opened");
        }

        public void windowClosing(WindowEvent e) {
            System.out.println("BattleWindow Closing");
        }

        public void windowClosed(WindowEvent e) {
            System.out.println("BattleWindow Closed");
        }

        public void windowIconified(WindowEvent e) {
            System.out.println("BattleWindow Iconified");
        }

        public void windowDeiconified(WindowEvent e) {
            System.out.println("BattleWindow DeIconified");
        }

        public void windowActivated(WindowEvent e) {
            System.out.println("BattleWindow Activated");
        }

        public void windowDeactivated(WindowEvent e) {
            System.out.println("BattleWindow Deactivated");
        }
    };
    ComponentListener BattleComponentListener = new ComponentListener() {

        public void componentResized(ComponentEvent e) {
        }

        public void componentMoved(ComponentEvent e) {
        }

        public void componentShown(ComponentEvent e) {
        }

        public void componentHidden(ComponentEvent e) {
        }
    };
}
