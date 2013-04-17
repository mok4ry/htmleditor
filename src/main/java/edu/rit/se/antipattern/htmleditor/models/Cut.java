/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

/**
 *
 * @author obasekiidemudia
 */

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;


public class Cut extends JMenuItem implements EditorCommand {

    private JTabbedPane text;
    private JEditorPane panel;

    public Cut(JTabbedPane text) {
        this.text = text;
    }

    
    public void execute() {
        panel = (JEditorPane)text.getSelectedComponent();
        StringSelection selection = new StringSelection(panel.getSelectedText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        panel.replaceSelection(" ");
    }

        public void undo() {
    }
}