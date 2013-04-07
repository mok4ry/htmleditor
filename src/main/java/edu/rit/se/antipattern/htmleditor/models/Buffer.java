package edu.rit.se.antipattern.htmleditor.models;

/**
 * the Buffer that holds the text and file path info for the gui
 * 
 * @author Zach
 */
public class Buffer {
    
    private String filePath;
    private String fileName;
    private String text;
    
    /**
     * Initializes a new buffer with the given file path with no text
     * 
     * @param filePath the path the file resides at
     */
    public Buffer (String filePath) {
        this.filePath = filePath;
        this.fileName = getFileNameFromPath(filePath);
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
        this.fileName = getFileNameFromPath(filePath);
        this.text = text;
    }
    
    private String getFileNameFromPath( String fp ) {
        int startOfFileName = 0;
        int startOfFileNameMac = fp.lastIndexOf("/") + 1;
        int startOfFileNameWin = fp.lastIndexOf("\\") + 1;
        if (startOfFileNameMac > startOfFileNameWin) {
            startOfFileName = startOfFileNameMac;
        } else {
            startOfFileName = startOfFileNameWin;
        }
        return startOfFileName == 0 ? fp : fp.substring(startOfFileName);
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
     * Inserts text at a given index
     * @param insert
     * @param index
     * @return newText
     */
    public void insertText(String insert, int index) {
        text = text.substring(0, index) + insert + text.substring(index);
    }
    
    /**
     * returns the filePath of this buffer
     * 
     * @return the file path this file resides at 
     */
    public String getFilePath () {
        return filePath;
    }
    
    public String getFileName() {
        return fileName;
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
    
    // stub for future functionality
    public int getCursorStartPos() {
        return 0;
    }
    
    // stub for future functionality
    public int getCursorEndPos() {
        return 0;
    }
    
    @Override
    public boolean equals( Object o ) {
        if ( !(o instanceof Buffer) ) return false;
        return ((Buffer)o).getFilePath().equals(filePath);
    }
    
    @Override
    public String toString() {
        return String.format( "Buffer for file: %s", filePath );
    }
}
