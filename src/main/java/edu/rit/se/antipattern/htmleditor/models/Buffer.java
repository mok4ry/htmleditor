package edu.rit.se.antipattern.htmleditor.models;

import javax.swing.DefaultListModel;

/**
 * the Buffer that holds the text and file path info for the gui
 * 
 * @author Zach and Wayne
 */
public class Buffer {
    
    private LockedBuffer lastState;
    private String filePath;
    private String fileName;
    private String text;
    private int startIndex;
    private int endIndex;
    private DefaultListModel links;
    
    /**
     * Initializes a new buffer with the given file path with no text
     * 
     * @param filePath the path the file resides at
     */
    public Buffer (String filePath) {
        this.filePath = filePath;
        this.fileName = getFileNameFromPath(filePath);
        this.text = "";
        this.startIndex = 0;
        this.endIndex = 0;
        this.lastState = null;
        links = new DefaultListModel();
    }
    
    public Buffer (Buffer toClone){
        this.filePath = new String(toClone.getFilePath());
        this.fileName = new String(toClone.getFileName());
        this.text = new String(toClone.getText());
        this.startIndex = toClone.getCursorStartPos();
        this.endIndex = toClone.getCursorEndPos();
        this.lastState = toClone.getLastState();
        this.links = toClone.getLinkList();
    }
    
    public void saveBuffer () {
        lastState = new LockedBuffer(new Buffer(this));
    }
    
    public void revertBuffer () {
        if (lastState != null) {
            Buffer temp = new Buffer(lastState.getBuffer());
            this.filePath = temp.getFilePath();
            this.fileName = temp.getFileName();
            this.text = temp.getText();
            this.startIndex = temp.getCursorStartPos();
            this.endIndex = temp.getCursorEndPos();
            this.lastState = temp.getLastState();
        }
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
        links = new DefaultListModel();
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
    
    public int getCursorStartPos(){
        return this.startIndex;
    }
    
    public int getCursorEndPos(){
        return this.endIndex;
    }
    
    public void setCursorPosition( int start, int end ) {
        this.startIndex = start;
        this.endIndex = end;
    }
    
    public LockedBuffer getLastState(){
        return this.lastState;
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
    
    /**
     * Returns the fileName of this Buffer
     * @return fileName
     */
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
    
    @Override
    public boolean equals( Object o ) {
        if ( !(o instanceof Buffer) ) return false;
        return ((Buffer)o).getFilePath().equals(filePath);
    }
    
    @Override
    public String toString() {
        return String.format( "Buffer for file: %s", filePath );
    }
    
    /**
     * Returns the list of links for LinkView
     * @return links
     */
    public DefaultListModel getLinkList() {
        return links;
    }
    
    /**
     * Adds a link to the list of links for LinkView
     * @return links
     */
    public void addLink(String link) {
        links.addElement(link);
    }
    
    /**
     * Clears the list of links for LinkView
     * @return links
     */
    public void clearLinks() {
        links.removeAllElements();
    }
    
    /**
     * Gets the selected Text
     * @return selectedText
     */
    public String getSelectedText() {
        return text.substring(startIndex, endIndex);
    }
    
    /**
     * Deletes the selected Text
     */
    public void deleteSelection() {
        text = text.substring(0, startIndex) + text.substring(endIndex);
    }
}
