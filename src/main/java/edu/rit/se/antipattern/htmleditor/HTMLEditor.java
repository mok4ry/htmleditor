package edu.rit.se.antipattern.htmleditor;

import edu.rit.se.antipattern.htmleditor.controllers.MainController;
import edu.rit.se.antipattern.htmleditor.models.ParseException;
import edu.rit.se.antipattern.htmleditor.models.Parser;
import edu.rit.se.antipattern.htmleditor.views.MainScreen;
import java.io.File;

/**
 * Our main driver class that sets the view
 * @author TeamAntiPattern
*/
public class HTMLEditor 
{
    public static void main( String[] args )
    {
        MainController c = new MainController();
        if (args.length == 0) {
            MainScreen ms = new MainScreen(c);
            ms.setVisible(true);
        } else if (args.length == 1) {
            File f = new File(args[0]);
            c.createBuffer(f);
            MainScreen ms = new MainScreen(c);
            ms.setVisible(true);
        } else {
            System.out.println("Usage: HTMLEditor <file> || HTMLEditor");
        }
    }
}
