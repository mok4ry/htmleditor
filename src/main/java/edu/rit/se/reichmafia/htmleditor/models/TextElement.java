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
     * Gets the text represented by this element.
     * 
     * @return The text represented by this element.
     */
    public String getName() {
        return text;
    }
}
