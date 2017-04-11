package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Duration;
import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by alvaro on 4/11/17.
 */
public class DurationFormatterTest {
    private Formatter durationFormatter;
    private Pose pose;
    private static final double DELTA = 1e-15;

    @Test
    public void test_build_StringWithThreeDifferentValues_DurationObject() throws InvalidValue {
        makeDuration();
        makePose();
        durationFormatter.build("0.3;0.5;1", pose);
        Duration duration = pose.getDuration();
        assertEquals(0.3, duration.getStartTime(), DELTA);
        assertEquals(0.5, duration.getEndTime(), DELTA);
    }

    @Test(expected = InvalidValue.class)
    public void test_build_MissingValue_InvalidValueException() throws InvalidValue {
        makeDuration();
        makePose();
        durationFormatter.build("0.3;0.5", pose);
        Duration duration = pose.getDuration();
    }

    @Test(expected = InvalidValue.class)
    public void test_build_MoreValuesThanExpected_Exception() throws InvalidValue {
        makeDuration();
        makePose();
        durationFormatter.build("0.3;0.5;1;1", pose);
        Duration duration = pose.getDuration();
    }

    @Test(expected = InvalidValue.class)
    public void test_build_BadDurationValue_Exception() throws InvalidValue {
        makeDuration();
        makePose();
        durationFormatter.build("0.3;HOLAMUNDO;1uenas", pose);
        Duration duration = pose.getDuration();
    }

    protected void makePose() {
        pose = new Pose();
    }

    protected void makeDuration() {
        durationFormatter = new DurationFormatter();
    }
}