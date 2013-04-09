/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rit.se.antipattern.htmleditor.models;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;

/**
 * Tests the indent class
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
        Buffer toIndent = new Buffer("C:\\Hello.html");
        toIndent.setText("");
        EditorStrategy ins = new Indent( toIndent );
        String expected = "";
        ins.execute();
        String result = toIndent.getText();
        assertEquals(expected, result);
    }
    
    /**
     * Test of indentText method with plain text.
     */
    public void testIndentTextPlain() {
        System.out.println("indentTextPlain");
        Buffer toIndent = new Buffer("C:\\Hello.html");
        toIndent.setText("Hello World!\nI love the world!\n");
        EditorStrategy ins = new Indent( toIndent );
        String expected = "Hello World!\nI love the world!";
        ins.execute();
        String result = toIndent.getText();
        assertEquals(expected, result);
    }
    
    /**
     * Test of indentText method with basic html.
     */
    public void testIndentTextBasic() {
        System.out.println("indentTextBasic");
        Buffer toIndent = new Buffer("C:\\Hello.html");
        toIndent.setText("<b>Hello</b>\n<em>World</em>");
        EditorStrategy ins = new Indent( toIndent );
        String expected = "<b>Hello</b>\n<em>World</em>";
        ins.execute();
        String result = toIndent.getText();
        assertEquals(expected, result);
    }
    
    /**
     * Test of indentText method with advanced html.
     */
    public void testIndentTextAdvanced() {
        System.out.println("indentTextAdvanced");
        Buffer toIndent = new Buffer("C:\\Hello.html");
        String input = "<table>\n<th>\n<tr><b>Hello</b></tr>\n</th>\n</table>\n";
        toIndent.setCursorPosition(0, input.length()-1);
        toIndent.setText(input);
        EditorStrategy ins = new Indent( toIndent );
        String expected = "<table>\n\t<th>\n\t\t<tr><b>Hello</b></tr>\n\t</th>\n</table>";
        ins.execute();
        String result = toIndent.getText();
        assertEquals(expected, result);
    }
    
    /**
     * Test of indentText method with super advanced html.
     */
    public void testIndentTextSuperAdvanced() {
        System.out.println("indentTextSuperAdvanced");
        Buffer toIndent = new Buffer("C:\\Hello.html");
        String input = "\t<table>\n<th>\n<tr><b>Hello</b></tr>\n</th>\n</table>\n\n\n\n";
        toIndent.setCursorPosition(11, input.length()-13);
        toIndent.setText(input);
        EditorStrategy ins = new Indent( toIndent );
        String expected = "<table>\n\t\t<th>\n\t\t\t<tr><b>Hello</b></tr>\n\t\t</th>\n\t</table>";
        ins.execute();
        String result = toIndent.getText();
        System.out.println(result);
        assertEquals(expected, result);
    }
}
