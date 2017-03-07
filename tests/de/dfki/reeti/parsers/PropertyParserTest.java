package de.dfki.reeti.parsers;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alvaro on 3/7/17.
 */
public class PropertyParserTest {
    PropertyParser parser;
    @Test
    public void test_parse_WithoutSemicolon_False() {
        makePropertyParser();
        boolean result = parser.parse("name=eyesLeftCenter");
        assertFalse(result);
    }

    @Test
    public void test_parse_WithSemicolonWithoutEqual_False() {
        makePropertyParser();
        boolean result = parser.parse("name eyesLeftCenter;");
        assertFalse(result);
    }

    @Test
    public void test_parse_EmptyLine_False() {
        makePropertyParser();
        boolean result = parser.parse("");
        assertFalse(result);
    }

    @Test
    public void test_parse_GoodLineString_ReturnKeyAndValue() {
        makePropertyParser();
        parser.parse("name=eyesLeftCenter;");
        String key = parser.getKey();
        String value = parser.getValue();
        assertEquals("name", key);
        assertEquals("eyesLeftCenter", value);
    }

    @Test
    public void test_parse_TwoLines_False() {
        makePropertyParser();
        boolean result = parser.parse("name=eyesLeftCenter;name=eyesLeftCenter;");
        assertFalse(result);
    }

    protected void makePropertyParser() {
        parser = new PropertyParser();
    }

}