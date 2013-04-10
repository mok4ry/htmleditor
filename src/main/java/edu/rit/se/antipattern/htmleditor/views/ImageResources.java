package edu.rit.se.antipattern.htmleditor.views;

import javax.imageio.ImageIO;

/**
 *
 * @author Team Antipattern
 */
public class ImageResources {
    
    private java.awt.Image collapsedIcon = null;
    private java.awt.Image expandedIcon = null;
    
    public ImageResources() {
        try {
            collapsedIcon = ImageIO.read(getClass().getResourceAsStream("/collapsed.png"));
            expandedIcon = ImageIO.read(getClass().getResourceAsStream("/expanded.png"));
        } catch ( java.io.IOException e ) {
            System.err.printf("Could not load resource: %s", e.getMessage());
        }
    }
    
    public java.awt.Image getCollapsedIcon() {
        return collapsedIcon;
    }
        
    public java.awt.Image getExpandedIcon() {
        return expandedIcon;
    }
    
}
