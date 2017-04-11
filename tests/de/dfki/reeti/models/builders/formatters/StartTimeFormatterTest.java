package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/11/17.
 */
public class StartTimeFormatterTest {
    private Formatter startTime;
    private Pose pose;
    private static final double DELTA = 1e-15;

    @Test
    public void test_build_DecimalNumberAndNoDefaultValue_Number() throws InvalidValue {
        makeFormatter();
        makePose();
        startTime.build("10.33", pose);
        assertEquals(10.33, pose.getStartTime(), DELTA);
    }

    @Test
    public void test_build_EmptyStringAndDefaultValueDefined_DefaultValue() throws InvalidValue {
        makeFormatter(0.0);
        makePose();
        startTime.build("", pose);
        assertEquals(0.0, pose.getStartTime(), DELTA);
    }

    @Test(expected = InvalidValue.class)
    public void test_build_EmptyStringWithoutDefaultValue_Exception() throws InvalidValue {
        makeFormatter();
        makePose();
        startTime.build("", pose);
    }

    protected void makePose() {
        pose = new Pose();
    }

    protected void makeFormatter() {
        startTime = new StartTimeFormatter();
    }

    protected void makeFormatter(double defaultValue) {
        startTime = new StartTimeFormatter(defaultValue);
    }

}