/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

/**
 * Handles the insertion of new tags
 * 
 * @author Zach, Wayne
 */
public class Insert implements EditorCommand {
    
    private Buffer b = null;
    private String tagName = null;
    private String subName = null;
    private java.util.HashMap<String,String> options = null;
    private int numSubTags, tabDepth, rows, cols;
    private int typeOfInsert;
    
    private static final int FLAT_INSERT = 0;
    private static final int LAYERED_INSERT = 1;
    private static final int TABLE_INSERT = 2;
    private static final int WITH_OPTIONS = 3;
    
    public Insert( Buffer toInsertInto, String tagName, int tabDepth ) {
        this.b = toInsertInto;
        this.tagName = tagName;
        this.tabDepth = tabDepth;
        this.typeOfInsert = FLAT_INSERT;
    }
    
    public Insert( Buffer toInsertInto, String tagName,
            java.util.HashMap<String,String> options ) {
        this.b = toInsertInto;
        this.tagName = tagName;
        this.options = options;
        this.typeOfInsert = WITH_OPTIONS;
    }
    
    public Insert( Buffer toInsertInto, String tagName, String subName,
            int numSubTags, int tabDepth ) {
        this.b = toInsertInto;
        this.tagName = tagName;
        this.subName = subName;
        this.tabDepth = tabDepth;
        this.numSubTags = numSubTags;
        this.typeOfInsert = LAYERED_INSERT;
    }
    
    public Insert( Buffer toInsertInto, int rows, int cols, int tabDepth ) {
        this.b = toInsertInto;
        this.tabDepth = tabDepth;
        this.rows = rows;
        this.cols = cols;
        this.typeOfInsert = TABLE_INSERT;
    }
    
    public void execute() {
        switch (typeOfInsert) {
            case FLAT_INSERT:
                b.setText( insertFlat(b.getText(), tagName,
                        b.getCursorStartPos(), tabDepth) );
                break;
            case LAYERED_INSERT:
                b.setText( insertLayered(b.getText(), tagName, subName,
                        b.getCursorStartPos(), numSubTags, tabDepth ) );
                break;
            case TABLE_INSERT:
                b.setText( insertTable(b.getText(), b.getCursorStartPos(),
                        rows, cols, tabDepth) );
                break;
            case WITH_OPTIONS:
                b.setText( insertWithOptions(b.getText(), tagName, options,
                        b.getCursorStartPos()) );
            default:
                break;
        }
    }

    private String insertFlat (String text, String name, int index, int tabDepth) {
        String newString = "";
        for ( int i = 0 ; i < tabDepth ; i++) {
            newString = newString + "\t";
        }
        newString =  text.substring(0,index) + newString + "<" + name + "></" + name
                + ">" + text.substring(index);
        return newString;
    }
    
    private String insertLayered (String text, String name, String subName, 
            int index, int subTags, int tabDepth) {
        String newString = text.substring(0,index) + "<" + name + ">\n";
        int i = 0;
        for (i = 0; i < subTags; i++) {
            newString = newString + insertFlat("", subName, 0, tabDepth + 1) + "\n";
        }
        for ( i = 0 ; i < tabDepth ; i++) {
            newString = newString + "\t";
        }
        newString = newString + "</" + name + ">" + text.substring(index);
        return newString;
    }

    private String insertTable (String text, int index, int rows, int cols, 
            int tabDepth) {
        int i = 0;
        
        String newString = text.substring(0,index) + "<table>\n";
        
        if (rows > 0) {
            for ( i = 0 ; i < tabDepth+1 ; i++) {
                newString = newString + "\t";
            }
            newString = newString + insertLayered("", "th", "td", 0, cols, 
                    tabDepth+1) + "\n";
        }
        
        int j = 0;
        for (i = 0; i < rows-1; i++) {
            for ( j = 0 ; j < tabDepth+1 ; j++) {
                newString = newString + "\t";
            }
            newString = newString + insertLayered("", "tr", "td", 0, cols, 
                    tabDepth+1) + "\n";
        }
        
        for ( i = 0 ; i < tabDepth ; i++) {
            newString = newString + "\t";
        }
        newString = newString + "</table>" + text.substring(index);
        return newString;
    }
    
    private String insertWithOptions( String text, String tagName,
            java.util.HashMap<String,String> options, int cursorPos ) {
        String tagString = String.format("<%s%s></%s>", tagName,
                getOptionsString(options), tagName );
        return text.substring(0, cursorPos) + tagString + text.substring(cursorPos);
    }
    
    private String getOptionsString( java.util.HashMap<String,String> options ) {
        String result = "";
        for( String s : options.keySet() ) {
            result += String.format(" %s=\"%s\"", s, options.get(s));
        }
        return result;
    }
}