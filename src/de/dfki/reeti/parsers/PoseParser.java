package de.dfki.reeti.parsers;


import de.dfki.reeti.models.builders.PoseBuilder;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

/**
 * Created by alvaro on 3/7/17.
 * Parses this:
 * <description>
 * <Pose>
 * <name>Conversation/eyesLeft</name>
 * <startTime>0</startTime>
 * <duration>0.5;0;1</duration>
 * <backToNeutral>0</backToNeutral>
 * <values>-1;-1;-1;-1;-1;-1;-1;-1;-1;42.5;42.5;91;76.5;-1;-1;-1</values>
 * <transition>smooth</transition>
 * </Pose>
 * <p>
 * </description>
 */
public class PoseParser implements RMDLParser {
    private final HashMap<String, String> values = new HashMap<>();
    private StringBuilder xml = new StringBuilder();
    private boolean isFinishedParsing = false;

    @Override
    public boolean parse(String line) {
        if (!isXMLTag(line)) {
            isFinishedParsing = false;
            return false;
        }
        if (isUrbiTag(line)) {
            isFinishedParsing = false;
            return false;
        }
        parseXMLEnty(line);
        return true;
    }

    @Override
    public boolean isFinishedParsingObject() {
        return isFinishedParsing;
    }


    private void parseXMLEnty(String line) {
        xml.append(line);
        try {
            tryToParseXML();
            clearData();
        } catch (JDOMException | IOException ignored) {
            isFinishedParsing = false;
        }
    }

    private void clearData() {
        isFinishedParsing = true;
        xml = new StringBuilder();
    }

    private void tryToParseXML() throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build(new StringReader(xml.toString()));
        Element rootNode = doc.getRootElement();
        List list = rootNode.getChild("Pose").getChildren();
        setKeyValue(list);
    }

    private void setKeyValue(List list) {
        for (Object aList : list) {
            Element node = (Element) aList;
            String key = node.getName();
            String value = node.getValue();
            values.put(key, value);
        }
    }

    private boolean isUrbiTag(String line) {
        return line.contains("<urbi>");
    }

    private boolean isXMLTag(String line) {
        return (line.startsWith("<") && line.endsWith(">"));
    }

    public HashMap<String, String> getValues() {
        return values;
    }
}
