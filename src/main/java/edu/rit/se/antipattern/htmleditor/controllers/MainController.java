package edu.rit.se.antipattern.htmleditor.controllers;

import edu.rit.se.antipattern.htmleditor.models.Buffer;
import edu.rit.se.antipattern.htmleditor.models.Editor;
import edu.rit.se.antipattern.htmleditor.models.ParseException;
import edu.rit.se.antipattern.htmleditor.models.Parser;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;

/**
 * Main controller for managing information between the HTML Editor's view and
 * models. Provides methods for manipulating buffers.
 * 
 * @author Team Antipattern
 */
public class MainController {
    
    public static final int MAX_NUM_TABS = 100;
    private boolean[] isModified = new boolean[MAX_NUM_TABS];
    private ArrayList<Buffer> buffers = null;
    private int currentBufferIndex, previousBufferIndex;
    private Editor editor;
    
    /**
     * Sole constructor for the HTML editor's controller.
     */
    public MainController() {
        buffers = new ArrayList<Buffer>();
        currentBufferIndex = -1;
        previousBufferIndex = -1;
        editor = new Editor();
    }
    
    public void indent (int bufferIndex, int startIndex, int endIndex) {
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.indent(buffers.get(bufferIndex));
    }
    
    public void insert (int bufferIndex, String name){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insert(buffers.get(bufferIndex), name);
    }
    
    public void insert (int bufferIndex, int rows, int cols){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insert(buffers.get(bufferIndex), rows, cols);
    }
    
    public void insert (int bufferIndex, String name, String subName, int numSubs ){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insert(buffers.get(bufferIndex), name, subName, numSubs);
    }
    
    public int getIndexOfPathname( String pathname ) {
        for ( int i = 0; i < buffers.size(); i++ )
            if ( buffers.get(i).getFilePath().equals(pathname) ) return i;
        return -1;
    }
    
    public boolean validate (int bufferIndex) {
        if ( indexOutOfRange(bufferIndex) ) return false;
        try {
            Parser.parseDocument(buffers.get(bufferIndex).getText());
            return true;
        } catch ( ParseException e ) {
            return false;
        }
    }
    
    public boolean createBuffer( int num ) {
        // TODO: What happens if you save a buffer with no filename?
        if ( !maxTabsOpen() ) {
            buffers.add( new Buffer(String.format("Untitled%d.html", num)) );
        } else return false;
        return true;
    }
    
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

    private boolean maxTabsOpen() {
        return buffers.size() == MAX_NUM_TABS;
    }
    
    public boolean saveBuffer( int index, File fileOut ) {
        try {
            FileUtils.writeStringToFile( fileOut, buffers.get(index).getText() );
            isModified[index] = false;
            return true;
        } catch ( IOException e ) {
            return false;
        }
    }
    
    public boolean bufferIsNamed( int index ) {
        return ! buffers.get(index).getFileName().matches("Untitled\\d+.html");
    }
    
    private String getFileText( String filepath ) throws IOException {
        return FileUtils.readFileToString(new File(filepath));
    }
    
    public boolean removeBuffer( int index ) {
        if ( buffers.size() > index && index >= 0 ) {
            buffers.remove(index);
            return true;
        } else return false;
    }
    
    public boolean updateBufferFilepath( int index, String newFilepath ) {
        if ( buffers.size() > index ) {
            buffers.get(index).setFilePath(newFilepath);
            return true;
        } else return false;
    }
    
    public void bufferModified( int index ) {
        if ( !isModified[index] ) isModified[index] = true;
    }
    
    public boolean bufferIsModified( int index ) {
        return isModified[index];
    }
    
    public int getNextBufferIndex() {
        return buffers.size();
    }
    
    public int autoIndent(int index, int cursor) {
        return editor.autoIndent(buffers.get(index), cursor);
    }
    
    public String getBufferText( int index ) {
        return buffers.get(index).getText();
    }
    
    public String getBufferFilepath( int index ) {
        return buffers.get(index).getFilePath();
    }
    
    public String getBufferFilename( int index ) {
        return buffers.get(index).getFileName();
    }
    
    public int getCurrentBufferIndex() {
        return currentBufferIndex;
    }
    
    public void setCurrentBufferIndex( int index ) {
        previousBufferIndex = currentBufferIndex;
        currentBufferIndex = index;
    }
    
    public int getPreviousBufferIndex() {
        return previousBufferIndex;
    }
    
    public void setBufferText( int index, String text ) {
        if ( indexOutOfRange(index) ) return;
        buffers.get(index).setText(text);
    }
    
    public void setBufferCursorPosition( int index, int start, int end ) {
        buffers.get(index).setCursorPosition(start, end);
    }
    
    private boolean indexOutOfRange( int index ) {
        return index < 0 || index >= buffers.size();
    }
    
    public boolean isEmpty() {
        return buffers.isEmpty();
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
