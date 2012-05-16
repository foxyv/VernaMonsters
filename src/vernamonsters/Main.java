/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package vernamonsters;

/**
 * The Main class which is called when the game is loaded.
 * @author Sweord
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MainGameThread theGame = new MainGameThread();
        theGame.start();
    }

}
