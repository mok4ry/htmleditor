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
 * models.
 * 
 * @author TeamAntiPattern
 */
public class MainController {
    
    public static final int MAX_NUM_TABS = 10;
    private boolean[] isModified = {
        false, false, false, false, false, false, false, false, false, false
    };
    private ArrayList<Buffer> buffers = null;
    private int currentBufferIndex, previousBufferIndex;
    private Editor editor;
    
    public MainController() {
        buffers = new ArrayList<Buffer>();
        currentBufferIndex = -1;
        previousBufferIndex = -1;
        editor = new Editor();
    }
    
    public void indent (int bufferIndex, int startIndex, int endIndex) {
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.indent(buffers.get(bufferIndex), startIndex, endIndex);
    }
    
    public void insert (int bufferIndex, String name, int index){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insert(buffers.get(bufferIndex), name, index);
    }
    
    public void insert (int bufferIndex, int index, int rows, int cols){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insert(buffers.get(bufferIndex), index, rows, cols);
    }
    
    public void insert (int bufferIndex, String name, String subName, int startIndex, int endIndex){
        if ( indexOutOfRange(bufferIndex) ) return;
        editor.insert(buffers.get(bufferIndex), name, subName, startIndex, endIndex);
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
    
    public boolean createBuffer() {
        // TODO: What happens if you save a buffer with no filename?
        if ( !maxTabsOpen() ) {
            buffers.add( new Buffer(null) );
            updateCurrentBufferAfterCreate();
        } else return false;
        return true;
    }
    
    public boolean createBuffer( File openedFile ) {
        if ( maxTabsOpen() ) return false;
        String absPath = openedFile.getAbsolutePath();
        try {
            buffers.add( new Buffer( absPath, getFileText(absPath) ) );
            updateCurrentBufferAfterCreate();
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
    
    private String getFileText( String filepath ) throws IOException {
        return FileUtils.readFileToString(new File(filepath));
    }
    
    public boolean removeBuffer( int index ) {
        if ( buffers.size() > index && index >= 0 ) {
            buffers.remove(index);
            updateCurrentBufferAfterRemove(index);
            return true;
        } else return false;
    }
    
    private void updateCurrentBufferAfterCreate() {
        previousBufferIndex = currentBufferIndex;
        currentBufferIndex = buffers.size() - 1;
    }
    
    private void updateCurrentBufferAfterRemove( int index ) {
        if ( buffers.isEmpty() )
            currentBufferIndex = -1;
        else {
            previousBufferIndex = currentBufferIndex;
            currentBufferIndex = (buffers.size() > index) ? index : index - 1;
        }
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
    
    private boolean indexOutOfRange( int index ) {
        return index < 0 || index >= buffers.size();
    }
    
    public boolean isEmpty() {
        return buffers.isEmpty();
    }
    
    public Buffer get(int index) {
        return buffers.get(index);
    }
}
