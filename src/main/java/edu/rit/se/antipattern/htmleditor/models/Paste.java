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

    private Buffer text;
    private String copyText = " ";

    public Paste(Buffer text) {
        this.text = text;
    }

    @Override
    public void execute() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        try {
            copyText = (String) contents.getTransferData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        text.insertText(copyText, text.getCursorStartPos());   
    }
}