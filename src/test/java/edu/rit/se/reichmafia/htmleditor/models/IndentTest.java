/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.reichmafia.htmleditor.models;

import static junit.framework.Assert.assertEquals;
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
        System.out.println("indentTextEmpty");
        Indent instance = new Indent();
        String expResult = "    \n\n";
        String result = instance.indentText("", 0, 0);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of indentText method with plain text.
     */
    public void testIndentTextPlain() {
        System.out.println("indentTextPlain");
        Indent instance = new Indent();
        String input = "Hello World!\nI love the world!\n";
        String expResult = "    \n\n";
        String result = instance.indentText(input, 0, input.length()-1);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of indentText method with basic html.
     */
    public void testIndentTextBasic() {
        System.out.println("indentTextBasic");
        Indent instance = new Indent();
        String expResult = "<b>Hello</b>\n<em>World</em>";
        String input = "<b>Hello</b>\n<em>World</em>";
        String result = instance.indentText(input, 0, input.length()-1);
        System.out.println(result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of indentText method with advanced html.
     */
    public void testIndentTextAdvanced() {
        System.out.println("indentTextAdvanced");
        Indent instance = new Indent();
        String expResult = "<table>\n<th>\n<tr><b>Hello</b></tr>\n</th>\n</table>\n";
        String input = "<table>\n<th>\n<tr><b>Hello</b></tr>\n</th>\n</table>\n\n\n";
        String result = instance.indentText(input, 0, input.length()-1);
        System.out.println(result);
        assertEquals(expResult, result);
    }
}
