package edu.rit.se.reichmafia.htmleditor.models;

/**
 * the Buffer that holds the text and file path info for the gui
 * 
 * @author Zach
 */
public class Buffer {
    
    private String filePath;
    private String text;
    
    /**
     * Initializes a new buffer with the given file path with no text
     * 
     * @param filePath the path the file resides at
     */
    public Buffer (String filePath) {
        this.filePath = filePath;
        this.text = "";
    }
    
    /**
     * Initializes a new buffer with the given file path and text
     * 
     * @param filePath the path the file resides at
     * @param text the text the buffer is seeded with
     */
    public Buffer (String filePath, String text) {
        this.filePath = filePath;
        this.text = text;
    }
    
    /**
     * returns the text of this buffer
     * 
     * @return the text this buffer contains
     */
    public String getText () {
        return text;
    }
    
    /**
     * returns the filePath of this buffer
     * 
     * @return the file path this file resides at 
     */
    public String getFilePath () {
        return filePath;
    }
    
    /**
     * sets the text in this buffer
     * 
     * @param text the text the buffer will now contain 
     */
    public void setText (String text) {
        this.text = text;
    }
     /**
      * sets the filePath of this buffer
      * 
      * @param filePath the file path the buffer will now be set to 
      */
    public void setFilePath (String filePath) {
        this.filePath = filePath;
    }
}
