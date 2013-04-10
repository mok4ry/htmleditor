package edu.rit.se.antipattern.htmleditor.models;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

/**
 *
 * @author Team Antipattern
 */
public class HTMLTreeModel implements javax.swing.tree.TreeModel {
    
    Element root = null;
    
    public HTMLTreeModel( Element root ) {
        this.root = root;
    }
    
    @Override
    public Object getRoot() {
        return root;
    }
    
    @Override
    public Object getChild( Object parent, int index ) {
        Element e = castToElement(parent);
        return e.getChildren()[index];
    }
    
    @Override
    public int getChildCount( Object parent ) {
        Element e = castToElement(parent);
        return e.getChildren().length;
    }
    
    @Override
    public boolean isLeaf( Object node ) {
        return node instanceof TextElement;
    }
    
    @Override
    public void valueForPathChanged( TreePath path, Object newValue ) {
        // NOT USED, OUTLINE VIEW IS STATIC
    }
    
    @Override
    public int getIndexOfChild( Object parent, Object child ) {
        if ( parent == null || child == null ) return -1;
        
        Element parentElement = castToElement(parent);
        Element[] parentChildren = parentElement.getChildren();
        for ( int i = 0; i < parentChildren.length; i++ )
            if ( parentChildren[i].equals(child) ) return i;
        return -1;
    }
    
    @Override
    public void addTreeModelListener( TreeModelListener l ) {
        // NOT USED, OUTLINE VIEW IS STATIC
    }
    
    @Override
    public void removeTreeModelListener( TreeModelListener l ) {
        // NOT USED, OUTLINE VIEW IS STATIC
    }
    
    private Element castToElement( Object o ) {
        return (Element)o;
    }
    
}
