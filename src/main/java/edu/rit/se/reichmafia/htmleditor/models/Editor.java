/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.reichmafia.htmleditor.models;

/**
 * Handles dealing with the functions such as indent and insert
 * 
 * @author Zach
 */
public class Editor {
    
    private Indent indentor;
    private Insert inserter;
    
    public Editor () {
        
    }
    
    public void indent (Buffer toIndent, int startIndex, int endIndex) {
        String oldString = toIndent.getText();
        String newText = toIndent.getText().substring(startIndex,endIndex);
        newText = indentor.indentText(newText);
        toIndent.setText(oldString.substring(0,startIndex-1) + newText + 
                oldString.substring(endIndex+1,oldString.length()));
    }
    
    public void insert (Buffer toInsert, String name, int startIndex) {
        toInsert.setText(inserter.insertFlat(toInsert.getText(), name, 
                startIndex));
    }
    
    public void insert (Buffer toInsert, String name, String subName, 
            int startIndex, int subTags) {
        toInsert.setText(inserter.insertLayered(toInsert.getText(), name, 
                subName, startIndex, subTags));
    }
    
    public void insert (Buffer toInsert, int startIndex, int rows, int cols) {
        toInsert.setText(inserter.insertTable(toInsert.getText(), startIndex, 
                rows, cols));
    }
}
