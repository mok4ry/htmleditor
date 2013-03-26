/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.reichmafia.htmleditor.models;

/**
 * Handles the insertion of new tags
 * 
 * @author Zach
 */
public class Insert {
    
    public String insert (String text, String name, int index) {
        String newString = text.substring(0,index) + "<" + name + "></" + name + ">" + text.substring(index+1,text.length()-1);
        return newString;
    }
}
