package edu.rit.se.antipattern.htmleditor;

import edu.rit.se.antipattern.htmleditor.models.ParseException;
import edu.rit.se.antipattern.htmleditor.models.Parser;
import edu.rit.se.antipattern.htmleditor.views.MainScreen;

/**
 * Our main driver class that sets the view
 * @author TeamAntiPattern
*/
public class HTMLEditor 
{
    public static void main( String[] args )
    {
        MainScreen ms = new MainScreen();
        ms.setVisible(true);
    }
}
