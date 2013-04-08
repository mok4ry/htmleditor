package edu.rit.se.antipattern.htmleditor.models;

/**
 * the Buffer that holds the text and file path info for the gui
 * 
 * @author Zach
 */
public class Buffer {
    
    private LockedBuffer lastState;
    private String filePath;
    private String fileName;
    private String text;
    private int startIndex;
    private int endIndex;
    
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
    }
    
    public Buffer (Buffer toClone){
        this.filePath = toClone.getFilePath();
        this.fileName = toClone.getFileName();
        this.text = toClone.getText();
        this.startIndex = toClone.getCursorStartPos();
        this.endIndex = toClone.getCursorEndPos();
        this.lastState = toClone.getLastState();
    }
    
    public void SaveBuffer () {
        lastState = new LockedBuffer(new Buffer(this));
    }
    
    public void RevertBuffer () {
        Buffer temp = new Buffer(lastState.getBuffer());
        this.filePath = temp.getFilePath();
        this.fileName = temp.getFileName();
        this.text = temp.getText();
        this.startIndex = temp.getCursorStartPos();
        this.endIndex = temp.getCursorEndPos();
        this.lastState = temp.getLastState();
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
    
    public int getCursorStartPos(){
        return this.startIndex;
    }
    
    /**
     * 
     * @return the end index of the selected text
     */
    public int getCursorEndPos(){
        return this.endIndex;
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
}
