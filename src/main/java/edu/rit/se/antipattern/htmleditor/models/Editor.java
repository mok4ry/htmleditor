package edu.rit.se.antipattern.htmleditor.models;

import java.util.HashMap;

/**
 * Handles dealing with the functions such as indent and insert
 * 
 * @author Zach, Wayne
 */
public class Editor {
    
    /**
     * Indents a given buffer with the given start and end indexes
     * @param toIndent
     * @param startIndex
     * @param endIndex 
     */
    public void indent ( Buffer toIndent ) {
        toIndent.saveBuffer();
        EditorCommand i = new Indent( toIndent );
        i.execute();
    }
    
    /**
     * Auto indents a new line when given a cursor position
     * @param toIndent
     * @param cursor 
     */
    public int autoIndent (Buffer toIndent) {
        int i = 0, cursorPos = toIndent.getCursorStartPos();
        String text = toIndent.getText();
        int numTabs = Indent.calulateTabs(text, cursorPos - 1);
        for (i = 0 ; i < numTabs; i++) {
            toIndent.insertText("\t", cursorPos);
        }
        
        return cursorPos + numTabs;
    }
    
    /**
     * Insert a given tag at the given index in the given buffer. Flat insert.
     * @param toInsert
     * @param name
     * @param startIndex 
     */
    public void insertFlat (Buffer toInsert, String name ) {
        toInsert.saveBuffer();
        EditorCommand ins = new Insert( toInsert, name, 0 );
        ins.execute();
    }
    
    /**
     * Inserts a given layered tag with a sub tag name at the given index for
     * n sub tags.
     * @param toInsert
     * @param name
     * @param subName
     * @param startIndex
     * @param subTags 
     */
    public void insertLayered (Buffer toInsert, String name, String subName, int subTags) {
        toInsert.saveBuffer();
        int tabs = Indent.calulateTabs(toInsert.getText(), toInsert.getCursorStartPos());
        EditorCommand ins = new Insert( toInsert, name, subName, subTags, tabs );
        ins.execute();
    }
    
    /**
     * Inserts a table of given rows and columns at the given index
     * @param toInsert
     * @param startIndex
     * @param rows
     * @param cols 
     */
    public void insertTable (Buffer toInsert, int rows, int cols) {
        toInsert.saveBuffer();
        int tabs = Indent.calulateTabs(toInsert.getText(), toInsert.getCursorStartPos());
        EditorCommand ins = new Insert( toInsert, rows, cols, tabs );
        ins.execute();
    }
    
    public void insertWithOptions(Buffer toInsert, String tagName, HashMap opts) {
        toInsert.saveBuffer();
        EditorCommand ins = new Insert( toInsert, tagName, opts );
        ins.execute();
    }
    
    /**
     * 
     * 
     * @param toUndo 
     */
    public void undo( Buffer toUndo ) {
        EditorCommand undo = new Undo( toUndo );
        undo.execute();
    }
}
