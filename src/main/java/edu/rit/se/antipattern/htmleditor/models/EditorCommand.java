package edu.rit.se.antipattern.htmleditor.models;

/**
 *
 * @author Team Antipattern
 */
public interface EditorCommand {
    
    /**
     * Execute an operation on a buffer.
     */
    public void execute();
    
}
