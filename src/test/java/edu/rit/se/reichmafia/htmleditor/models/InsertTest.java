/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.reichmafia.htmleditor.models;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * Tests the insert methods
 * @author Wayne
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
     * Test of insertFlat method when text is empty.
     */
    public void testInsertFlatEmpty() {
        System.out.println("insertFlat");
        Insert instance = new Insert();
        String expResult = "<em></em>";
        String result = instance.insertFlat("", "em", 0);
        assertEquals(expResult, result);
    }
    
    /**
     * Test when the tags are inserted between existing text
     */
    public void testInsertFlatMiddle() {
        Insert instance = new Insert();
        String expResult = "Hel<b></b>lo";
        String result = instance.insertFlat("Hello", "b", 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertLayered method with 0 subTags.
     */
    public void testInsertLayeredZero() {
        System.out.println("insertLayered");
        Insert instance = new Insert();
        String expResult = "<ul>\n</ul>\n";
        String result = instance.insertLayered("", "ul", "li", 0, 0);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertLayered method on Non-Empty text with 3 subTags.
     */
    public void testInsertLayeredFive() {
        Insert instance = new Insert();
        String expResult = "Hel<ul>\n<li></li>\n<li></li>\n<li></li>\n</ul>\nlo";
        String result = instance.insertLayered("Hello", "ul", "li", 3, 3);
        assertEquals(expResult, result);
    }

    /**
     * Test of insertTable method with 0 rows and 0 columns.
     */
    public void testInsertTableZeroZero() {
        System.out.println("insertTable");
        Insert instance = new Insert();
        String expResult = "\n<table>\n</table>\n";
        String result = instance.insertTable("", 0, 0, 0);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertTable method with 1 rows and 0 columns.
     */
    public void testInsertTableOneZero() {
        Insert instance = new Insert();
        String expResult = "\n<table>\n<th>\n</th>\n</table>\n";
        String result = instance.insertTable("", 0, 1, 0);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertTable method with 1 rows and 3 columns.
     */
    public void testInsertTableOneThree() {
        Insert instance = new Insert();
        String expResult = "\n<table>\n<th>\n<td></td>\n<td></td>\n<td></td>\n"
                + "</th>\n</table>\n";
        String result = instance.insertTable("", 0, 1, 3);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertTable method with 3 rows and 3 columns.
     */
    public void testInsertTableThreeThree() {
        Insert instance = new Insert();
        String expResult = "\n<table>\n<th>\n<td></td>\n<td></td>\n<td></td>\n"
                + "</th>\n<tr>\n<td></td>\n<td></td>\n<td></td>\n</tr>\n"
                + "<tr>\n<td></td>\n<td></td>\n<td></td>\n</tr>\n</table>\n";
        String result = instance.insertTable("", 0, 3, 3);
        assertEquals(expResult, result);
    }
}
