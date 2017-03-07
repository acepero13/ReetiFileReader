package de.dfki.reeti.parsers;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 3/7/17.
 */
public class PoseParserTest {
    private PoseParser parser;

    @Test
    public void test_parse_PropertyLine_False() {
        makeParser();
        boolean res = parser.parse("name=eyesLeftCenter;");
        assertFalse(res);
    }

    @Test
    public void test_parse_DescriptionLine_True() {
        makeParser();
        boolean res = parser.parse("<description>");
        assertTrue(res);
    }

    @Test
    public void test_parse_SmallXML_MapWithKeys() {
        makeParser();
        parser.parse("<description>");
        parser.parse("<Pose>");
        parser.parse("<name>Conversation/eyesLeft</name>");
        parser.parse("<startTime>0</startTime>");
        parser.parse("</Pose>");
        parser.parse("</description>");
        HashMap<String, String> parsed = parser.getValues();
        assertEquals(2, parsed.size());
    }

    @Test
    public void test_parse_UrbiLine_False() {
        makeParser();
        boolean res = parser.parse("<urbi>");
        assertFalse(res);
    }

    protected void makeParser() {
        parser = new PoseParser();
    }
}