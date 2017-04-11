package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.StringFormatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/10/17.
 */
public class StringFormatterTest {
    StringFormatter formatter;
    @Test
    public void test_MethodUnderTest_Scenario_Behavior() throws InvalidValue {
        formatter =  new NameFormatter();
        Pose pose = new Pose();
        formatter.build("String", pose);
        assertEquals("String", pose.getName());
    }
}