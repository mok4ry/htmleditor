package edu.rit.se.reichmafia.htmleditor.models;

/**
 * HTML Element that is an HTML tag with arbitrary contents.
 * 
 * @author Team ReichMafia
 */
public class TagElement implements Element {
    
    private String name = null;
    private Element[] contents = null;
    
    /**
     * Initializes a TagElement with the given name and a string of contents,
     * which are parsed and stored as other elements.
     * 
     * @param name The name of this element (e.g. 'em', 'div', 'p', 'html')
     * @param contents The raw HTML between the opening and closing of this tag
     * @throws ParseException 
     */
    public TagElement( String name, Element[] contents ) throws ParseException {
        this.name = name;
        this.contents = contents;
    }
    
    /**
     * Gets the name of this Tag.
     * 
     * @return The name of this Tag.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns a string representation of this tag and its contents.
     * 
     * @return String representation of this tag and its contents.
     */
    @Override
    public String toString() {
        return null;
    }
}
