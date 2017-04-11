package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/11/17.
 */
public class BackToNeutralFormatterTest {
    private Formatter formatter;
    private Pose pose;

    @Test
    public void test_build_OneAsString_True() throws InvalidValue {
        makeFormatter();
        makePose();
        formatter.build("1", pose);
        assertTrue(pose.isBackToNeutralOn());
    }

    @Test
    public void test_build_ZeroAsString_False() throws InvalidValue {
        makeFormatter();
        makePose();
        formatter.build("0", pose);
        assertFalse(pose.isBackToNeutralOn());
    }

    protected void makePose() {
        pose = new Pose();
    }

    protected void makeFormatter() {
        formatter = new BackToNeutralFormatter();
    }
}