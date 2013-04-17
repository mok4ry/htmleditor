/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

/**
 * Copies text from a Buffer
 * @author obasekiidemudia and Wayne
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;


public class Copy extends JMenuItem implements EditorCommand {

    private Buffer text;

    public Copy(Buffer text) {
        this.text = text;
    }

    public void execute() {
        StringSelection selection = new StringSelection(text.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
    }
}
