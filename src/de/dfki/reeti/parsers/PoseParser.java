package de.dfki.reeti.parsers;


import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.Sequence;
import de.dfki.reeti.models.builders.PoseBuilder;
import de.dfki.reeti.models.exceptions.InvalidValue;
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
    private final Sequence sequence;
    private StringBuilder xml = new StringBuilder();

    public PoseParser(Sequence sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean parse(String line) {
        if (!isXMLTag(line)) {
            return false;
        }
        if (isUrbiTag(line)) {
            return false;
        }
        parseXMLEnty(line);
        return true;
    }



    private void parseXMLEnty(String line) {
        xml.append(line);
        try {
            processXML();
        } catch (JDOMException | IOException | InvalidValue ignored) {}
    }

    private void processXML() throws JDOMException, IOException, InvalidValue {
        tryToParseXML();
        clearData();
    }

    private void addPose(HashMap<String, String> poseValues) throws InvalidValue {
        PoseBuilder poseBuilder = new PoseBuilder(poseValues);
        Pose pose = poseBuilder.build();
        sequence.addPose(pose);
    }

    private void clearData() {
        xml = new StringBuilder();
    }

    private void tryToParseXML() throws JDOMException, IOException, InvalidValue {
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build(new StringReader(xml.toString()));
        Element rootNode = doc.getRootElement();
        List list = rootNode.getChildren("Pose");
        setKeyValue(list);
    }

    private void setKeyValue(List list) throws InvalidValue {
        for (Object aList : list) {
            Element node = (Element) aList;
            List children = node.getChildren();
            HashMap<String, String> poseValues = getNodeValues(children);
            addPose(poseValues);
        }
    }

    private HashMap<String, String> getNodeValues(List children) {
        HashMap<String, String> poseValues = new HashMap<>();
        for(Object child: children){
            Element childNode = (Element) child;
            String key = childNode.getName();
            String value = childNode.getValue();
            values.put(key, value);
            poseValues.put(key, value);
        }
        return poseValues;
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
