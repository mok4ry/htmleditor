package edu.rit.se.antipattern.htmleditor.models;

/**
 * Exception thrown when an attempt to parse HTML fails (i.e. when the HTML is
 * not well-formed or valid).
 * 
 * @author Team ReichMafia
 */
public class ParseException extends Exception {
    
    /**
     * Exception representing an attempt to parse invalid HTML.
     * 
     * @param offendingHTML The HTML that was unable to be parsed
     */
    public ParseException( String offendingHTML ) {
        super(offendingHTML);
    }
    
}
