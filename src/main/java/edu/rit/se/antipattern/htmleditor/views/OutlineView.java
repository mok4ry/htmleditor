package edu.rit.se.antipattern.htmleditor.views;

import edu.rit.se.antipattern.htmleditor.controllers.MainController;
import javax.swing.UIManager;

/**
 *
 * @author Team Antipattern
 */
public class OutlineView extends javax.swing.JFrame {
    private int bufferIndex;
    private MainController c = null;
    private javax.swing.JTree outline = null;
    
    public OutlineView( int bufferIndex, MainController c ) {
        ImageResources resources = new ImageResources();
        UIManager.put("Tree.collapsedIcon", new HTMLTreeIcon(false, resources));
        UIManager.put("Tree.expandedIcon", new HTMLTreeIcon(true, resources));
        this.bufferIndex = bufferIndex;
        this.c = c;
        initComponents();
    }
    
    private void initComponents() {
        this.outline = new javax.swing.JTree(c.getJTreeOfBuffer(bufferIndex));
        javax.swing.JScrollPane jsp = new javax.swing.JScrollPane(outline);
        jsp.setPreferredSize(new java.awt.Dimension(250, 500));
        add(jsp);
        
        pack();
    }
}
