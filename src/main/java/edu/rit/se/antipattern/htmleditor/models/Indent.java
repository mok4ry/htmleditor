package edu.rit.se.antipattern.htmleditor.models;
import java.util.regex.*;

/**
 * This class handles indenting for the editor class
 * 
 * @author Zach, Wayne
 */
public class Indent {
    
    private char tab;
    
    /**
     * Creates an indent object
     */
    public Indent () {
        tab = '\t';
    }
    
    /**
     * Indents the given text over the given range
     * @param text
     * @param startChar
     * @param endChar
     * @return newText
     */
    public String indentText (String text, int startChar, int endChar) {
        String[] newText = text.split("\n", -1);
        //Calculate the line numbers to indent
        int startLine = 0;
        int endLine = 0;
        //Get Start Line
        int i = startChar;
        if (i == text.length())
            i--;
        while (i > 0) {
            if (text.charAt(i) == '\n')
                startLine++;
            i--;
        }
        //Get End Line
        i = endChar;
        if (i == text.length())
            i--;
        while (i > startChar) {
            if (text.charAt(i) == '\n')
                endLine++;
            i--;
        }
        endLine += startLine;
        
        //Get the number of tabs from the previous line
        int numTabs = 0;
        if (startLine > 0) {
            numTabs = countTabs(newText[startLine - 1]);
            numTabs += tabDifference(newText[startLine - 1]);
        }
        
        //Add the tabs to the apropriate line
        while (startLine <= endLine) {
            newText[startLine] = newText[startLine].trim();
            if (tabDifference(newText[startLine]) < 0)
                numTabs += tabDifference(newText[startLine]);
            
            if (numTabs < 0)
                numTabs = 0;
            
            for (i = 0 ; i < numTabs ; i++){
                newText[startLine] = tab + newText[startLine];
            }
            
            if (tabDifference(newText[startLine]) > 0)
                numTabs += tabDifference(newText[startLine]);
            
            startLine++;
        }
        
        //Recompile the text appropriately
        text = "";
        for (i = 0 ; i < newText.length ; i++) {
            text = text + newText[i] + "\n";
        }
        
        return text.trim();
    }
    
    /**
     * Counts the number of tabs in a given line
     * @param line
     * @return tabs
     */
    private int countTabs (String line) {
        int tabs = 0;
        int i = 0;
        if (line.length() > 0) {
            while ((line.charAt(i) == tab || line.charAt(i) == ' ') && i < line.length()) {
                if (line.charAt(i) == tab)
                    tabs++;
                i++;
            }
        }
        return tabs;
    }
    
    /**
     * Calculates the difference in tabs that this line creates
     * @param line
     * @return tabDifference
     */
    private int tabDifference (String line) {
        int tabDifference = 0;
        
        Pattern open = Pattern.compile("<\\w*>");
        Matcher openTags = open.matcher(line);
        while (openTags.find())
            tabDifference++;
        
        Pattern close = Pattern.compile("</\\w*>");
        Matcher closeTags = close.matcher(line);
        while (closeTags.find())
            tabDifference--;
        
        return tabDifference;
    }
    
    public int calulateTabs (String text, int cursor) {
        int numTabs = 0;
        
        
        return numTabs;
    }
}
