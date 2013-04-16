/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

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
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("");
        EditorCommand ins = new Insert( toInsert, "em", 0 );
        ins.execute();
        String expResult = "<em></em>";
        String result = toInsert.getText();
        assertEquals(expResult, result);
    }
    
    /**
     * Test when the tags are inserted between existing text
     */
    public void testInsertFlatMiddle() {
        System.out.println("insertFlatMiddle");
        String expResult = "Hel<b></b>lo";
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("Hello");
        toInsert.setCursorPosition(3, 3);
        EditorCommand ins = new Insert( toInsert, "b", 0 );
        ins.execute();
        String result = toInsert.getText();
        assertEquals(expResult, result);
    }

    /**
     * Test of insertLayered method with 0 subTags.
     */
    public void testInsertLayeredZero() {
        System.out.println("insertLayeredZero");
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("");
        EditorCommand ins = new Insert( toInsert, "ul", "li", 0, 0 );
        ins.execute();
        String result = toInsert.getText();
        String expResult = "<ul>\n</ul>";
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertLayered method on Non-Empty text with 3 subTags.
     */
    public void testInsertLayeredThree() {
        System.out.println("insertLayeredThree");
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("Hello");
        toInsert.setCursorPosition(3, 3);
        EditorCommand ins = new Insert( toInsert, "ul", "li", 3, 0 );
        ins.execute();
        String result = toInsert.getText();
        String expResult = "Hel<ul>\n\t<li></li>\n\t<li></li>\n\t<li></li>\n</ul>lo";
        assertEquals(expResult, result);
    }

    /**
     * Test of insertTable method with 0 rows and 0 columns.
     */
    public void testInsertTableZeroZero() {
        System.out.println("insertTableZero");
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("");
        EditorCommand ins = new Insert( toInsert, 0, 0, 0 );
        ins.execute();
        String result = toInsert.getText();
        String expResult = "<table>\n</table>";
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertTable method with 1 rows and 0 columns.
     */
    public void testInsertTableOneZero() {
        System.out.println("insertTableOneZero");
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("");
        EditorCommand ins = new Insert( toInsert, 1, 0, 0 );
        ins.execute();
        String result = toInsert.getText();
        String expResult = "<table>\n\t<th>\n\t</th>\n</table>";
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertTable method with 1 rows and 3 columns.
     */
    public void testInsertTableOneThree() {
        System.out.println("insertTableOneThree");
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("");
        EditorCommand ins = new Insert( toInsert, 1, 3, 0 );
        ins.execute();
        String result = toInsert.getText();
        String expResult = "<table>\n\t<th>\n\t\t<td></td>\n\t\t<td></td>\n\t\t<td></td>\n"
                + "\t</th>\n</table>";
        assertEquals(expResult, result);
    }
    
    /**
     * Test of insertTable method with 3 rows and 3 columns.
     */
    public void testInsertTableThreeThree() {
        System.out.println("insertTableThreeThree");
        Buffer toInsert = new Buffer("C:\\Hello.html");
        toInsert.setText("");
        EditorCommand ins = new Insert( toInsert, 3, 3, 0 );
        ins.execute();
        String result = toInsert.getText();
        String expResult = "<table>\n\t<th>\n\t\t<td></td>\n\t\t<td></td>\n\t\t<td></td>\n"
                + "\t</th>\n\t<tr>\n\t\t<td></td>\n\t\t<td></td>\n\t\t<td></td>\n\t</tr>\n"
                + "\t<tr>\n\t\t<td></td>\n\t\t<td></td>\n\t\t<td></td>\n\t</tr>\n</table>";
        assertEquals(expResult, result);
    }
}
