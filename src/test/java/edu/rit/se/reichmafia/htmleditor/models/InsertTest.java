/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.reichmafia.htmleditor.models;

import junit.framework.TestCase;

/**
 *
 * @author Wayne E Starr
 */
public class InsertTest extends TestCase {
    
    public InsertTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of insertFlat method, of class Insert.
     */
    public void testInsertFlat() {
        System.out.println("insertFlat");
        String text = "";
        String name = "em";
        int index = 0;
        Insert instance = new Insert();
        String expResult = "<em></em>";
        String result = instance.insertFlat(text, name, index);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertLayered method, of class Insert.
     */
    public void testInsertLayered() {
        System.out.println("insertLayered");
        String text = "";
        String name = "ul";
        String subName = "li";
        int index = 0;
        int subTags = 0;
        Insert instance = new Insert();
        String expResult = "<ul>\n<li></li>\n</ul>\n";
        String result = instance.insertLayered(text, name, subName, index, subTags);
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertTable method, of class Insert.
     */
    public void testInsertTable() {
        System.out.println("insertTable");
        String text = "";
        int index = 0;
        int rows = 0;
        int cols = 0;
        Insert instance = new Insert();
        String expResult = "\n<table>\n</table>\n";
        String result = instance.insertTable(text, index, rows, cols);
        assertEquals(expResult, result);
    }
}
