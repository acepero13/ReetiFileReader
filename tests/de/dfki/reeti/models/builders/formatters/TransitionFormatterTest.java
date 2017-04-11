package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/11/17.
 */
public class TransitionFormatterTest {
    @Test
    public void test_build_StringValue_StringValue() throws InvalidValue {
        Formatter formatter = new TransitionFormatter();
        Pose pose = new Pose();
        String smooth = "smooth";
        formatter.build(smooth, pose);
        assertEquals(smooth, pose.getTransiton());
    }
}