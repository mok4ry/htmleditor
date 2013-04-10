package edu.rit.se.antipattern.htmleditor.views;

import javax.imageio.ImageIO;

/**
 *
 * @author Team Antipattern
 */
public class HTMLTreeIcon implements javax.swing.Icon {
    private static final int SIZE = 11;
    private boolean expanded;
    private java.awt.Image collapsedIcon = null, expandedIcon = null;
    
    public HTMLTreeIcon( boolean expanded, ImageResources i ) {
        this.expanded = expanded;
        this.collapsedIcon = i.getCollapsedIcon();
        this.expandedIcon = i.getExpandedIcon();
    }
    
    @Override
    public void paintIcon(java.awt.Component c, java.awt.Graphics g,
            int x, int y) {
        if (this.expanded)
            g.drawImage(expandedIcon, x, y, c);
        else 
            g.drawImage(collapsedIcon, x, y, c);
    }
    
    @Override
    public int getIconWidth() {
        return SIZE;
    }
    
    @Override
    public int getIconHeight() {
        return SIZE;
    }
}
