package edu.rit.se.antipattern.htmleditor.controllers;

import edu.rit.se.antipattern.htmleditor.models.Buffer;
import edu.rit.se.antipattern.htmleditor.models.Editor;
import edu.rit.se.antipattern.htmleditor.models.HTMLTreeModel;
import edu.rit.se.antipattern.htmleditor.models.ParseException;
import edu.rit.se.antipattern.htmleditor.models.Parser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import org.apache.commons.io.FileUtils;

/**
 * Main controller for managing information between the HTML Editor's view and
 * models. Provides methods for manipulating buffers.
 * 
 * @author Team Anti-Pattern
 */
public class MainController {
    
    public static final int MAX_NUM_TABS = 100;
    private boolean[] isModified = new boolean[MAX_NUM_TABS];
    private ArrayList<Buffer> buffers = null;
    private Editor editor;
    
    /**
     * Sole constructor for the HTML editor's controller.
     */
    public MainController() {
        buffers = new ArrayList<Buffer>();
        editor = new Editor();
    }
    
    /**
     * Indent the line or selected lines by one tab level.
     * 
     * @param bufferIndex Index of the buffer to indent.
     */
    public void indent (int bufferIndex) {
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.indent(buffers.get(bufferIndex));
    }
    
    /**
     * Insert a tag with the given name into the specified buffer. Inserts at
     * the position of the cursor's start position if an area is selected.
     * 
     * @param bufferIndex Index of the buffer into which to insert.
     * @param name Name of the tag to insert (e.g. "div", "p", "b", etc.)
     */
    public void insertFlat (int bufferIndex, String name){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insertFlat(buffers.get(bufferIndex), name);
    }
    
    /**
     * Insert a table of the given dimensions into the specified buffer.
     * 
     * @param bufferIndex Index of the buffer into which to insert the table.
     * @param rows Number of rows in the inserted table.
     * @param cols Number of columns in the inserted table.
     */
    public void insertTable (int bufferIndex, int rows, int cols){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insertTable(buffers.get(bufferIndex), rows, cols);
    }
    
    /**
     * Insert a layered tag into the specified buffer. The outermost tag and
     * name of the sub tag must be given.
     * 
     * @param bufferIndex Index of the buffer into which to insert the tag.
     * @param name Name of the outermost tag.
     * @param subName Name of the inner tag(s)
     * @param numSubs Number of inner tags the outer tag will contain.
     */
    public void insertLayered (int bufferIndex, String name, String subName, int numSubs ){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insertLayered(buffers.get(bufferIndex), name, subName, numSubs);
    }
    
    public void insertURL(int bufferindex, String url, String tag) {
        if ( indexOutOfRange(bufferindex) ) return;
        java.util.HashMap<String,String> options = new java.util.HashMap<String, String>();
        if (tag == "img") {
            options.put("src", url);
            editor.insertWithOptions(buffers.get(bufferindex), "img", options, true);
        } else if (tag == "a") {
            options.put("href", url);
            editor.insertWithOptions(buffers.get(bufferindex), "a", options, false);
            buffers.get(bufferindex).addLink(url);
        }
    }
    
    /**
     * Undoes an operation
     * @param bufferIndex 
     */
    public void undoOperation( int bufferIndex ) {
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.undo( buffers.get(bufferIndex) );
    }
    
    /**
     * Find the index of the buffer associated with the given file path. Returns
     * -1 if such a buffer does not exist.
     * 
     * @param pathname File path that specifies a single file.
     * @return Index of the buffer associated with the given file, or -1 if such
     * a buffer does not exist.
     */
    public int getIndexOfPathname( String pathname ) {
        for ( int i = 0; i < buffers.size(); i++ )
            if ( buffers.get(i).getFilePath().equals(pathname) ) return i;
        return -1;
    }
    
    /**
     * Checks to see if the specified buffer contains only well-formed HTML.
     * 
     * @param bufferIndex Index of the buffer to check for valid HTML.
     * @return true if the buffer contains only valid HTML, false otherwise.
     */
    public boolean validate (int bufferIndex) {
        if ( indexOutOfRange(bufferIndex) ) return false;
        try {
            Parser.parseDocument(buffers.get(bufferIndex).getText());
            return true;
        } catch ( ParseException e ) {
            return false;
        }
    }
    
    /**
     * Create a new buffer associated with a file named UntitledN.html, where N
     * is the number given.
     * 
     * @param num Number to append to "Untitled" in the file's name
     * @return true if the buffer was created successfully, false otherwise
     */
    public boolean createBuffer( int num ) {
        // TODO: What happens if you save a buffer with no filename?
        if ( !maxTabsOpen() ) {
            buffers.add( new Buffer(String.format("Untitled%d.html", num)) );
        } else return false;
        return true;
    }
    
    /**
     * Create a new buffer associated with the given file.
     * 
     * @param openedFile File with which to associate this buffer.
     * @return true if the buffer was created successfully, false otherwise
     */
    public boolean createBuffer( File openedFile ) {
        if ( maxTabsOpen() ) return false;
        String absPath = openedFile.getAbsolutePath();
        try {
            buffers.add( new Buffer( absPath, getFileText(absPath) ) );
        } catch ( IOException e ) {
            return false;
        }
        return true;
    }

    // checks to see if the number of buffers open as at the maximum
    private boolean maxTabsOpen() {
        return buffers.size() == MAX_NUM_TABS;
    }
    
    /**
     * Saves the specified buffer into the file associated with it.
     * 
     * @param index Index of the buffer to save
     * @return true if the buffer was saved successfully, false otherwise
     */
    public boolean saveBuffer( int index ) {
        try {
            File fileOut = new File( buffers.get(index).getFilePath() );
            FileUtils.writeStringToFile(fileOut, buffers.get(index).getText());
            return true;
        } catch ( IOException e ) {
            return false;
        }
    }
    
    /**
     * Saves the specified buffer into the given file.
     * 
     * @param index Index of the buffer to save
     * @param fileOut File to which to write the buffer
     * @return true if the buffer was saved successfully, false otherwise
     */
    public boolean saveBuffer( int index, File fileOut ) {
        try {
            FileUtils.writeStringToFile( fileOut, buffers.get(index).getText() );
            isModified[index] = false;
            return true;
        } catch ( IOException e ) {
            return false;
        }
    }
    
    /**
     * Checks to see if the specified buffer is named. A buffer is considered
     * named if its name does not match the regex /Untitled\d+.html/, i.e. the
     * word "Untitled" followed by any number and suffixed with ".html".
     * 
     * @param index Index of the buffer to check
     * @return true if the buffer is named, false otherwise
     */
    public boolean bufferIsNamed( int index ) {
        return ! buffers.get(index).getFileName().matches("Untitled\\d+.html");
    }
    
    // read the contents of a file into a String
    private String getFileText( String filepath ) throws IOException {
        return FileUtils.readFileToString(new File(filepath));
    }
    
    /**
     * Remove the specified buffer from the active buffers.
     * 
     * @param index Index of the buffer to deactivate (remove).
     * @return true if the buffer was removed successfully, false otherwise
     */
    public boolean removeBuffer( int index ) {
        if ( buffers.size() > index && index >= 0 ) {
            buffers.remove(index);
            return true;
        } else return false;
    }
    
    /**
     * Set the specified buffer's associated filepath to the given one.
     * 
     * @param index Index of the buffer whose filepath will be updated
     * @param newFilepath New filepath to associate with the buffer
     * @return true if the filepath was updated successfully, false otherwise
     */
    public boolean updateBufferFilepath( int index, String newFilepath ) {
        if ( buffers.size() > index ) {
            buffers.get(index).setFilePath(newFilepath);
            return true;
        } else return false;
    }
    
    /**
     * Notify the controller that the specified buffer has been modified.
     * 
     * @param index Index of the buffer that has been modified
     */
    public void bufferModified( int index ) {
        if ( !isModified[index] ) isModified[index] = true;
    }
    
    /**
     * Check if the specified buffer has been modified since its last save.
     * 
     * @param index Index of the buffer to check for modification
     * @return true if the buffer has been modified, false otherwise
     */
    public boolean bufferIsModified( int index ) {
        return isModified[index];
    }
    
    /**
     * Auto-indent the buffer as necessary after upon pressing the return key.
     * 
     * @param index Index of the buffer to be auto-indented
     * @return The new cursor position in the buffer
     */
    public int autoIndent(int index) {
        return editor.autoIndent(buffers.get(index));
    }
    
    /**
     * Get the text in the specified buffer.
     * 
     * @param index Index of the buffer whose text to get.
     * @return Text of the specified buffer
     */
    public String getBufferText( int index ) {
        return buffers.get(index).getText();
    }
    
    /**
     * Get the filepath associated with the specified buffer.
     * 
     * @param index Index of the buffer whose filepath to get.
     * @return Filepath associated with the specified buffer.
     */
    public String getBufferFilepath( int index ) {
        return buffers.get(index).getFilePath();
    }
    
    /**
     * Get the filename associated with the specified buffer.
     * 
     * @param index Index of the buffer whose filename to get.
     * @return Filename associated with the specified buffer.
     */
    public String getBufferFilename( int index ) {
        return buffers.get(index).getFileName();
    }

    /**
     * Set the specified buffer's text to the given text.
     * 
     * @param index Index of the buffer whose text to change.
     * @param text Text to which to change the specified buffer's text.
     */
    public void setBufferText( int index, String text ) {
        if ( indexOutOfRange(index) ) return;
        buffers.get(index).setText(text);
    }
    
    /**
     * Set the specified buffer's cursor's start and end positions.
     * 
     * @param index Index of the buffer whose position to change.
     * @param start New cursor start index
     * @param end New cursor end index
     */
    public void setBufferCursorPosition( int index, int start, int end ) {
        buffers.get(index).setCursorPosition(start, end);
    }
    
    // check if the given index is out of bounds with respect to current buffers
    private boolean indexOutOfRange( int index ) {
        return index < 0 || index >= buffers.size();
    }
    
    /**
     * Check if there are no active buffers.
     * 
     * @return true if there are no active buffers, false otherwise
     */
    public boolean isEmpty() {
        return buffers.isEmpty();
    }
    
    /**
     * Gets a JTree object representing the tree of HTML elements in the
     * specified buffer. Returns null if the buffer contains badly-formed HTML
     * 
     * @param bufferIndex Index of the buffer of which to get a JTree
     * @return A JTree object representing the HTML elements in the specified
     * buffer, or null if buffer contains badly-formed HTML
     */
    public javax.swing.tree.TreeModel getJTreeOfBuffer( int bufferIndex ) {
        try {
            String bufferText = buffers.get(bufferIndex).getText();
            return new HTMLTreeModel(Parser.parseDocument(bufferText));
        } catch ( ParseException p ) {
            return null;
        }
    }
    
    public void saveBufferState( int bufferIndex ) {
        buffers.get(bufferIndex).saveBuffer();
    }
    
    /**
     * Returns the list of links for LinkView
     * @return links
     */
    public DefaultListModel getLinkList(int bufferindex) {
        return buffers.get(bufferindex).getLinkList();
    }
    
    /**
     * Updates the links that are contained within a buffer
     * @param bufferindex 
     */
    public void updateBufferLinks(int bufferindex) {
        //TODO: Plug in Parser Code Here
    }
    
    @Deprecated
    /**
     * Gets the buffer at a given index. Deprecated because any buffer
     * manipulation can and should be done via the other methods this controller
     * provides.
     */
    public Buffer get(int index) {
        return buffers.get(index);
    }
}
