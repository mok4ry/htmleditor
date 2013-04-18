package edu.rit.se.antipattern.htmleditor.models;

/**
 * Interface for elements in an HTML file.
 * 
 * @author Team Antipattern
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
    
    /**
     * Get all the links in this element and all elements contained by it.
     * 
     * @return All the links from this node in the Element tree and down.
     */
    public java.util.ArrayList<String> getLinks();
    
}
