package edu.rit.se.antipattern.htmleditor.models;

import edu.rit.se.antipattern.htmleditor.models.Parser;
import edu.rit.se.antipattern.htmleditor.models.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;

/**
 * Units tests for the Parser class.
 * 
 * @author Team ReichMafia
 */
public class ParserTest extends TestCase {
    
    public ParserTest(String testName) {
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

    public void test_isJustTextTrue() {
        String html = "this is just text";
        assertTrue( Parser.isJustText(html) );
    }
    
    public void test_isJustTextFalse() {
        String html = "<div>this text is in a div tag</div>";
        assertFalse( Parser.isJustText(html) );
    }
    
    public void test_getTagNameNoOptions() {
        String html = "<div> the tag name should be div</div>";
        try {
            assertTrue( Parser.getTagName(html).equals( "div" ) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getTagNameWithOptions() {
        String html = "<font font-family=\"Helvetica\"> the tag name should be font</font>";
        try {
            assertTrue( Parser.getTagName(html).equals( "font" ) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getTagNameOddlyFormatted() {
        String html = "< b> adfghjkl; < /b>";
        try {
            assertTrue( Parser.getTagName(html).equals( "b" ) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getTagContentStringNonWellFormed() {
        String html = "<font this is some non-wellformed HTML right here</font>";
        try {
            Parser.getTagContentString(html);
            assertTrue( false );
        } catch ( ParseException e ) {
            assertTrue( true );
        }
    }
    
    public void test_getTagContentStringNestedTags() {
        String content = "some <b>content</b> here";
        String html = "<b>" + content + "</b>";
        try {
            assertTrue( Parser.getTagContentString(html).equals(content) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getTagContentStringMoreNestedTags() {
        String content = "some <b>content</b> <div>with more <em>tags</em></div>here";
        String html = "<b>" + content + "</b>";
        try {
            assertTrue( Parser.getTagContentString(html).equals(content) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getOpeningTagRegexSimple() {
        String name = "div";
        Pattern tagPattern = Parser.getOpeningTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("<%s>", name));
        assertTrue( m.matches() );
    }
    
    public void test_getOpeningTagRegexOddlyFormatted() {
        String name = "div";
        Pattern tagPattern = Parser.getOpeningTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("< %s >", name));
        assertTrue( m.matches() );
    }
    
    public void test_getOpeningTagRegexWithOptions() {
        String name = "font";
        Pattern tagPattern = Parser.getOpeningTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("<%s font-family=\"Helvetica\">", name));
        assertTrue( m.matches() );
    }
    
    public void test_getOpeningTagRegexNotThere() {
        String name = "div";
        Pattern tagPattern = Parser.getOpeningTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("<b>362 is <em>fun</em></b>", name));
        assertFalse( m.matches() );
    }
    
    public void test_getClosingTagRegexSimple() {
        String name = "div";
        Pattern tagPattern = Parser.getClosingTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("</%s>", name));
        assertTrue( m.matches() );
    }
    
    public void test_getClosingTagRegexOddlyFormatted() {
        String name = "div";
        Pattern tagPattern = Parser.getClosingTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("< /%s >", name));
        assertTrue( m.matches() );
    }
    
    public void test_getClosingTagRegexNotThere() {
        String name = "div";
        Pattern tagPattern = Parser.getClosingTagRegex(name);
        Matcher m = tagPattern.matcher(String.format("<%s><b>no closing tag</b>.", name));
        assertFalse( m.matches() );
    }
    
    public void test_getLeadingTextExists() {
        String leadingText = "Here is some leading text";
        String html = String.format("%s<p>content text</p>", leadingText);
        assertTrue( Parser.getLeadingText(html).equals(leadingText) );
    }
    
    public void test_getLeadingTextDoesNotExist() {
        String html = "<p>this html has no leading text</p>";
        assertTrue( Parser.getLeadingText(html).equals("") );
    }
    
    public void test_getLeadingTextNoTags() {
        String html = "this html is only leading text, no tags";
        assertTrue( Parser.getLeadingText(html).equals(html) );
    }
    
    public void test_getFirstElementStringSimple() {
        String firstElement = "<b>Software</b>";
        String html = String.format("%s<b>Engineering</b>", firstElement);
        try {
            assertTrue( Parser.getFirstElementString(html).equals(firstElement) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getFirstElementStringWholeString() {
        String firstElement = "<b>Software</b>";
        try {
            assertTrue( Parser.getFirstElementString(firstElement).equals(firstElement) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
    public void test_getFirstElementStringBadlyFormed() {
        String firstElement = "<b>Software";
        String html = String.format("%s<b>Engineering</b>", firstElement);
        try {
            assertFalse( Parser.getFirstElementString(html).equals(firstElement) );
        } catch ( ParseException e ) {
            assertTrue( false );
        }
    }
    
//    public void test_parseDocumentSimple() {
//        String html = "<html><head></head><body></body></html>";
//        try {
//            assertTrue( Parser.parseDocument(html).toString().equals(html) );
//        } catch ( ParseException e ) {
//            assertTrue( false );
//        }
//    }
    
    public void test_parseDocumentBadlyFormedNoHTMLTag() {
        String html = "<head></head><body></body>";
        try {
            Parser.parseDocument(html);
            assertTrue( false );
        } catch ( ParseException e ) {
            assertTrue( true );
        }
    }
    
//    public void test_parseDocumentOddlyFormed() {
//        String html = "< html>< head ></head><body></body></html >";
//        try {
//            assertTrue( Parser.parseDocument(html).toString().equals("<html><head></head><body></body></html>") );
//        } catch ( ParseException e ) {
//            assertTrue( false );
//        }
//    }
    
//    public void test_parseDocumentWithTextWellFormed() {
//        String html = "<html><head></head><body>Here is some text</body></html>";
//        try {
//            assertTrue( Parser.parseDocument(html).toString().equals(html) );
//        } catch ( ParseException e ) {
//            assertTrue( false );
//        }
//    }
    
    public void test_parseDocumentBadlyFormedBodyNotClosed() {
        String html = "<html><head></head><body></html>";
        try {
            Parser.parseDocument(html);
            assertTrue( false );
        } catch ( ParseException e ) {
            assertTrue( true );
        }
    }
    
    public void test_parseDocumentBadlyFormedOpeningTagNotClosed() {
        String html = "<html><p This should really be in a p tag</p></html>";
        try {
            Parser.parseDocument(html);
            assertTrue( false );
        } catch ( ParseException e ) {
            assertTrue( true );
        }
    }
    
    public void test_getElementStringsDuplicateTags() {
        String divTag = "<div></div>";
        String html = String.format("%s%s", divTag, divTag );
        try {
            ArrayList<String> elems = Parser.getElementStrings(html);
            assertTrue( elems.get(0).equals(divTag) && elems.get(1).equals(divTag) );
        } catch ( ParseException e ) {
            fail(String.format("Should have been successful at parsing: %s", html));
        }
    }
    
    public void test_parseDuplicateTagsSeparateLines() {
        String html = "<th><td></td>\n<td></td></th>";
        try {
            Parser.parse(html);
            assertTrue( true );
        } catch ( ParseException e ) {
            fail(String.format("Should have been successful at parsing: %s", html));
        }
    }
}
