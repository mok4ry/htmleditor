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
public class IndentTest extends TestCase {
    
    public IndentTest(String testName) {
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
     * Test of indentText method with empty text.
     */
    public void testIndentTextEmpty() {
        System.out.println("indentText");
        Indent instance = new Indent();
        String expResult = "    \n\n";
        String result = instance.indentText("");
        System.out.println(result);
        assertEquals(expResult, result);
    }
}
