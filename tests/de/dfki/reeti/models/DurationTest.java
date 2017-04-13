package de.dfki.reeti.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/13/17.
 */
public class DurationTest {
    Duration duration;

    @Test
    public void test_write_AllObjectSet_XML() {
        makeDuration();
        duration.setTimeToMaintainPose(1.0);
        duration.setTimeToNeutralPose(0.3);
        duration.setTimeToReachPose(1.3);
        String res = duration.write();
        String expected = "<duration>\n" +
                "<timeToReachPose>1.3</timeToReachPose>\n" +
                "<timeToMaintainPose>1.0</timeToMaintainPose>\n" +
                "<timeToNeutralPose>0.3</timeToNeutralPose>\n" +
                "</duration>";
        assertEquals(expected, res);
    }

    private void makeDuration() {
        duration = new Duration();
    }

}