package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Movement;
import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by alvaro on 4/11/17.
 */
public class MotorFormatterTest {

    private Formatter motorFormatter;
    private Pose pose;
    private static final double DELTA = 1e-15;
    @Test
    public void test_build_AllMotorsMoved_Motors() throws InvalidValue {
        makeFormatter();
        pose = makePose();
        motorFormatter.build("28.5;85;72.5;76;82.5;80.5;23;61;59;67;73.5;85;68;17.5;66.5;light green", pose);
        Movement movement = pose.getMotorsMovement();
        assertEquals(28.5, movement.getNeckRotat(), DELTA);
        assertEquals(85, movement.getNeckTilt(), DELTA);
        assertEquals(72.5, movement.getNeckPan(), DELTA);
        assertEquals(76, movement.getLeftLC(), DELTA);
        assertEquals(82.5, movement.getRightLC(), DELTA);
        assertEquals(80.5, movement.getTopLip(), DELTA);
        assertEquals(23, movement.getBottomLip(), DELTA);
        assertEquals(59, movement.getLeftEar(), DELTA);
        assertEquals(61, movement.getRightEar(), DELTA);
        assertEquals(73.5, movement.getLeftEyeTilt(), DELTA);
        assertEquals(67, movement.getRightEyeTilt(), DELTA);
        assertEquals(68, movement.getLeftEyePan(), DELTA);
        assertEquals(85, movement.getRightEyePan(), DELTA);
        assertEquals(66.5, movement.getLeftEyeLid(), DELTA);
        assertEquals(17.5, movement.getRightEyeLid(), DELTA);
        assertEquals("light green", movement.getColor());
    }

    @Test(expected = InvalidValue.class)
    public void test_build_LessMottorsSpecified_InvalidValueException() throws InvalidValue {
        makeFormatter();
        pose = makePose();
        motorFormatter.build("28.5;85;72.5;76;82.5;80.5;68;17.5;66.5;light green", pose);
    }

    @NotNull
    protected Pose makePose() {
        return new Pose();
    }

    protected void makeFormatter() {
        motorFormatter = new MotorFormatter();
    }
}