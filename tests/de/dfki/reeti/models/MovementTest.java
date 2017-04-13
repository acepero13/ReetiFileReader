package de.dfki.reeti.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/13/17.
 */
public class MovementTest {

    Movement movement;

    @Test
    public void test_write_MovementObject_XMLString() {
        makeMovement();
        String res = movement.write();
        String expected = "<motors>\n"
                + "<motor name=\"neckRotat\">1.0</motor>\n"
                + "<motor name=\"neckTilt\">1.0</motor>\n"
                + "<motor name=\"neckPan\">1.0</motor>\n"
                + "<motor name=\"leftLC\">1.0</motor>\n"
                + "<motor name=\"rightLC\">1.0</motor>\n"
                + "<motor name=\"topLip\">1.0</motor>\n"
                + "<motor name=\"bottomLip\">1.0</motor>\n"
                + "<motor name=\"leftEar\">1.0</motor>\n"
                + "<motor name=\"rightEar\">1.0</motor>\n"
                + "<motor name=\"leftEyeTilt\">1.0</motor>\n"
                + "<motor name=\"rightEyeTilt\">1.0</motor>\n"
                + "<motor name=\"leftEyePan\">1.0</motor>\n"
                + "<motor name=\"rightEyePan\">1.0</motor>\n"
                + "<motor name=\"leftEyeLid\">1.0</motor>\n"
                + "<motor name=\"rightEyeLid\">1.0</motor>\n"
                + "<motor name=\"color\">Color</motor>\n"
                +"</motors>"
                ;
        assertEquals(expected, res);
    }

    private void makeMovement() {
        movement  = new Movement();
        movement.setNeckTilt(1.0);
        movement.setColor("Color");
        movement.setRightEyeLid(1.0);
        movement.setLeftEyeLid(1.0);
        movement.setRightEyePan(1.0);
        movement.setLeftEyePan(1.0);
        movement.setRightEyeTilt(1.0);
        movement.setLeftEyeTilt(1.0);
        movement.setRightEar(1.0);
        movement.setLeftEar(1.0);
        movement.setBottomLip(1.0);
        movement.setTopLip(1.0);
        movement.setRightLC(1.0);
        movement.setLeftLC(1.0);
        movement.setNeckPan(1.0);
        movement.setNeckRotat(1.0);
    }
}