/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vernamonsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import javax.swing.JPanel;

/**
 *
 * @author Sweord
 */
public class YourBattlePanel extends JPanel{
    final static long serialVersionUID = 16l;
    Rectangle healthBarBack;
    Rectangle healthBar;
    Image BackGround;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public YourBattlePanel() {
        Initialize();
    }

    public YourBattlePanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        Initialize();
    }

    public YourBattlePanel(LayoutManager layout) {
        super(layout);
        Initialize();
    }

    public YourBattlePanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        Initialize();
    }// </editor-fold>

    private void Initialize() {
        healthBar = new Rectangle();
        healthBarBack = new Rectangle();
        this.setOpaque(true);
        
    }

    public void setBackground(Image Background){
        BackGround = Background;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        healthBarBack.setBounds(0, 0, this.getBounds().width / 2, this.getBounds().height / 20);
        healthBar.setBounds(healthBarBack.x, healthBarBack.y, healthBarBack.width / 2, healthBarBack.height);
        g.setColor(Color.BLACK);
        g.fillRect(healthBarBack.x,healthBarBack.y,healthBarBack.width,healthBarBack.height);
        
        g.setColor(Color.GREEN);
        g.fillRect(healthBar.x,healthBar.y,healthBar.width,healthBar.height);
        
        

    }

    
}
