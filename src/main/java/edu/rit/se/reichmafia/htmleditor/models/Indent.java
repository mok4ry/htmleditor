package edu.rit.se.reichmafia.htmleditor.models;

/**
 * This class handles indenting for the editor class
 * 
 * @author Zach
 */
public class Indent {
    
    private String tab;
    
    public Indent () {
        tab = "    ";
    }
    
    public String indentText (String text) {
        String newText = text;
        int indexOf = 0;
        
        while (indexOf != -1) {
            String[] startTags = newText.substring(0,indexOf).split("<\\w*>");
            String[] endTags = newText.substring(0,indexOf).split("</\\w*>");
            int depth = startTags.length - endTags.length;
            for (int j = 0; j <= depth; j++) {
                newText = newText.substring(0,indexOf) + tab + newText.substring(indexOf+1+tab.length()*j,newText.length()-1);
            }
            indexOf = newText.indexOf('\n', indexOf+1);
        }
        
        return newText;
    }
    
    public void setTab (int spaces) {
        String tabs = "";
        for (int i = 0; i < spaces; i++) {
            tabs += " ";
        }
        tab = tabs;
    }
}
