package de.dfki.reeti.models.builders;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/10/17.
 */
public class PoseBuilderTest {
    private PoseBuilder builder;
    private static final double DELTA = 1e-15;
    @Test
    public void test_build_PoseXML_PoseObject() throws InvalidValue {
        HashMap<String, String> values = new HashMap<>();
        values.put("name", "EarsDown");
        values.put("startTime", "0");
        values.put("duration", "0.3;0.5;1");
        values.put("backToNeutral", "0");
        values.put("values", "-1;-1;-1;-1;-1;-1;-1;0;0;-1;-1;-1;-1;-1;-1;-1");
        values.put("transition", "smooth");

        makeBuilder(values);
        Pose pose = builder.build();
        assertEquals("EarsDown", pose.getName());
        assertEquals(0.0, pose.getStartTime(), DELTA);


    }

    protected void makeBuilder(HashMap<String, String> values) {
        builder = new PoseBuilder(values);
    }
}