package de.dfki.reeti.builders;

import de.dfki.reeti.models.Property;
import de.dfki.reeti.models.base.SequencePart;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 3/7/17.
 */
public class PropertyHandlerTest {
    private FakePorpertyHandler propertyHandler;



    @Test
    public void test_appendLine_GoodNameLine_NameLineAdded() {
        makePropertyHandler();
        propertyHandler.append("name=eyesLeftCenter;");
        HashMap <String, String> values = ((PropertyHandler) propertyHandler).getValues();
        assertTrue(values.containsKey("name"));
    }

    @Test
    public void test_appendLine_GoodLineName_PropertyObject() {
        makePropertyHandler();
        propertyHandler.append("soundUsed=1;");
        propertyHandler.append("name=eyesLeftCenter;");
        assertEquals("eyesLeftCenter", propertyHandler.getProperty().getName());
        assertTrue(propertyHandler.getProperty().isSoundUsed());
    }



    private void makePropertyHandler() {
        propertyHandler = new FakePorpertyHandler();
    }

    private class FakePorpertyHandler extends PropertyHandler{
        public FakePorpertyHandler(){
            super(new LinkedList<>());
        }

        public Property getProperty(){
            return property;
        }
    }

}