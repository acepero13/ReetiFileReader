package de.dfki.reeti.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/13/17.
 */
public class PropertyTest {
    Property property;

    @Test
    public void test_write_PropertyObject_XMLString() {
        makeProperty();
        String res = property.write();
        String expected = "<properties>\n" +
                "<property name=\"name\">name</property>\n" +
                "<property name=\"duration\">1.0</property>\n" +
                "<property name=\"soundUsed\">true</property>\n" +
                "<property name=\"imageUsed\">true</property>\n" +
                "<property name=\"functionUsed\">true</property>\n" +
                "<property name=\"earsUsed\">true</property>\n" +
                "<property name=\"eyesUsed\">true</property>\n" +
                "<property name=\"mouthUsed\">true</property>\n" +
                "<property name=\"neckUsed\">true</property>\n" +
                "<property name=\"colorUsed\">true</property>\n"+
                "</properties>"
                ;
        assertEquals(expected, res);

    }

    private void makeProperty() {
        property = new Property();
        property.setName("name");
        property.setDuration(1.0);
        property.setSoundUsed(true);
        property.setImageUsed(true);
        property.setFunctionUsed(true);
        property.setEarsUsed(true);
        property.setEyesUsed(true);
        property.setMouthUsed(true);
        property.setNeckUsed(true);
        property.setColorUsed(true);
    }
}