package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Movement;
import de.dfki.reeti.models.builders.formatters.base.ArrayFormatter;
import de.dfki.reeti.models.builders.formatters.base.DoubleFormatter;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/11/17.
 */
public class MotorFormatter extends ArrayFormatter {

    public static final int NECK_ROT_MOTOR = 0;
    public static final int NECK_TILT_MOTOR = 1;
    public static final int NECK_PAN_MOTOR = 2;
    public static final int LEFT_LC_MOTOR = 3;
    public static final int RIGHT_LC_MOTOR = 4;
    public static final int TOP_LIP_MOTOR = 5;
    public static final int BOTTOM_LIP_MOTOR = 6;
    public static final int LEFT_EAR_MOTOR = 8;
    public static final int RIGHT_EAR_MOTOR = 7;
    public static final int LEFT_EYE_TILT_MOTOR = 10;
    public static final int RIGHT_EYE_TILT_MOTOR = 9;
    public static final int LEFT_EYE_PAN_MOTOR = 12;
    public static final int RIGHT_EYE_PAN_MOTOR = 11;
    public static final int LEFT_EYE_LID_MOTOR = 14;
    public static final int RIGHT_EYE_LID_MOTOR = 13;
    public static final int COLOR_SPEC = 15;
    private String[] values;

    @Override
    public void buildObject() throws InvalidValue {
        values = getValue();
        shouldParseMotorMovement();
        Movement movement = shouldBuildMovement();
        pose.setMotorMovement(movement);

    }

    protected void shouldParseMotorMovement() throws InvalidValue {
        if (values.length > 16 || values.length <= 14) {
            throw new InvalidValue();
        }
    }

    private Movement shouldBuildMovement() throws InvalidValue {
        try {
            return buildMovement();
        } catch (ArrayIndexOutOfBoundsException exception) {
            throw new InvalidValue();
        }
    }

    private Movement buildMovement() throws InvalidValue {
        Movement movement = new Movement();
        movement.setNeckRotat(DoubleFormatter.parseDouble(values[NECK_ROT_MOTOR]));
        movement.setNeckTilt(DoubleFormatter.parseDouble(values[NECK_TILT_MOTOR]));
        movement.setNeckPan(DoubleFormatter.parseDouble(values[NECK_PAN_MOTOR]));
        movement.setLeftLC(DoubleFormatter.parseDouble(values[LEFT_LC_MOTOR]));
        movement.setRightLC(DoubleFormatter.parseDouble(values[RIGHT_LC_MOTOR]));
        movement.setTopLip(DoubleFormatter.parseDouble(values[TOP_LIP_MOTOR]));
        movement.setBottomLip(DoubleFormatter.parseDouble(values[BOTTOM_LIP_MOTOR]));
        movement.setLeftEar(DoubleFormatter.parseDouble(values[LEFT_EAR_MOTOR]));
        movement.setRightEar(DoubleFormatter.parseDouble(values[RIGHT_EAR_MOTOR]));
        movement.setLeftEyeTilt(DoubleFormatter.parseDouble(values[LEFT_EYE_TILT_MOTOR]));
        movement.setRightEyeTilt(DoubleFormatter.parseDouble(values[RIGHT_EYE_TILT_MOTOR]));
        movement.setLeftEyePan(DoubleFormatter.parseDouble(values[LEFT_EYE_PAN_MOTOR]));
        movement.setRightEyePan(DoubleFormatter.parseDouble(values[RIGHT_EYE_PAN_MOTOR]));
        movement.setLeftEyeLid(DoubleFormatter.parseDouble(values[LEFT_EYE_LID_MOTOR]));
        movement.setRightEyeLid(DoubleFormatter.parseDouble(values[RIGHT_EYE_LID_MOTOR]));
        if (values.length == 16)
            movement.setColor(values[COLOR_SPEC]);
        return movement;
    }
}
