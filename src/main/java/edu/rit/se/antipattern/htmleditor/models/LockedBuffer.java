/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

/**
 *
 * @author Zach
 */
public class LockedBuffer {
    private Buffer buffer;
    
    public LockedBuffer (Buffer buffer) {
        this.buffer=buffer;
    }
    
    public Buffer getBuffer () {
        return buffer;
    }
}
