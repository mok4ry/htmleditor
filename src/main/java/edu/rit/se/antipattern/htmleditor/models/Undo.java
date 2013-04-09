/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

/**
 *
 * @author David
 */
public class Undo {
    
    private Buffer b = null;
    
    public Undo (Buffer toUndo) {
        b = toUndo;
    }
    
    public void execute () {
        b.RevertBuffer();
    }
}
