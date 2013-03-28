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
public class Insert {
    
    /**
     * Inserts a flat tag
     * @param text
     * @param name
     * @param index
     * @return newText
     */
    public String insertFlat (String text, String name, int index) {
        String newString = text.substring(0,index) + "<" + name + "></" + name
                + ">" + text.substring(index);
        return newString;
    }
    
    /**
     * Inserts a layered tag
     * @param text
     * @param name
     * @param subName
     * @param index
     * @param subTags
     * @return newText
     */
    public String insertLayered (String text, String name, String subName, 
            int index, int subTags) {
        String newString = text.substring(0,index) + "<" + name + ">\n";
        int i = 0;
        for (i = 0; i < subTags; i++) {
            newString = newString + insertFlat("", subName, 0) + "\n";
        }
        newString = newString + "</" + name + ">\n" + text.substring(index);
        return newString;
    }
    
    /**
     * Inserts a new table
     * @param text
     * @param index
     * @param rows
     * @param cols
     * @return newText
     */
    public String insertTable (String text, int index, int rows, int cols) {
        String newString = text.substring(0,index) + "\n<table>\n";
        if (rows > 0) {
            newString = newString + insertLayered("", "th", "td", 0, cols);
        }
        
        int i = 0;
        for (i = 0; i < rows-1; i++) {
            newString = newString + insertLayered("", "tr", "td", 0, cols);
        }
        
        newString = newString + "</table>\n" + text.substring(index);
        return newString;
    }
}