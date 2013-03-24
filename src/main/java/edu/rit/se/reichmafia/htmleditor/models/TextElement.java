package edu.rit.se.reichmafia.htmleditor.models;

/**
 * HTML Element that is just raw text within a tag.
 * 
 * @author Team ReichMafia
 */
public class TextElement implements Element {
    
    private String text = null;
    
    /**
     * Initializes a TextElement object that represents the given text.
     * 
     * @param text Text for this object to represent.
     */
    public TextElement( String text ) {
        this.text = text;
    }
    
    /**
     * Gets the text represented by this element.  Note that this is the same as
     * toString()
     * 
     * @return The text represented by this element.
     */
    public String getName() {
        return text;
    }
    
    /**
     * Get a string representation of this TextElement.  This is simply the text
     * it contains.  Note that this is the same as getName()
     * 
     * @return Text contained by this text element.
     */
    public String toString() {
        return text;
    }
    
}
