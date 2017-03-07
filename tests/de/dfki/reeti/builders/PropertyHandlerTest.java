package de.dfki.reeti.builders;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 3/7/17.
 */
public class PropertyHandlerTest {
    private RettiBuilderHandler propertyHandler;



    @Test
    public void test_appendLine_GoodNameLine_NameLineAdded() {
        makePoseHandler();
        propertyHandler.append("name=eyesLeftCenter;");
        HashMap <String, String> values = ((PropertyHandler) propertyHandler).getValues();
        assertTrue(values.containsKey("name"));
    }



    private void makePoseHandler() {
        propertyHandler = new PropertyHandler();
    }

}