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
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JEditorPane;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;
import javax.swing.text.BadLocationException;

public class Paste extends JMenuItem implements EditorCommand {

    private JTabbedPane text;
    private JEditorPane pane;
    private String copyText = " ";

    public Paste(JTabbedPane text) {
        this.text = text;
    }

    @Override
    public void execute() {
        pane = (JEditorPane)text.getSelectedComponent();
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        try {
            copyText = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            pane.getDocument().insertString(pane.getCaretPosition(), copyText, null);   
        } catch (BadLocationException ex) {
            Logger.getLogger(Paste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void undo() {
    }
}