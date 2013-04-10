package edu.rit.se.antipattern.htmleditor.models;

/**
 * Interface for elements in an HTML file.
 * 
 * @author Team ReichMafia
 */
public interface Element {
    /**
     * Get the name of this Element.
     * 
     * @return Name of this Element.
     */
    public String getName();
    
    /**
     * Get this element's children.  Returns an empty array if this element is a
     * leaf.
     * 
     * @return Array of this element's children. Will be empty if node is a leaf
     */
    public Element[] getChildren();
    
}
