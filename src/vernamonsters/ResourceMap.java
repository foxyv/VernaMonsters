/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vernamonsters;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * A way to load and hold resources like Images.
 * @author Sweord
 */
public class ResourceMap {

    HashMap<String, Image> imageResources;

    public ResourceMap() {
        imageResources = new HashMap<String, Image>();

    }

    /**
     *
     * @param resourceID : Location of the image in the package.
     * @param Name : Name to refer to this image in the future.
     */
    public void addImage(String resourceID, String Name) {
        Image temp;
        try {
            temp = ImageIO.read(this.getClass().getResource(resourceID));
            imageResources.put(Name, temp);
        } catch (IOException ex) {
            Logger.getLogger(BattleScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Image getImage(String Name){
        if(imageResources.containsKey(Name))return imageResources.get(Name);
        else return null;
        
    }
}
