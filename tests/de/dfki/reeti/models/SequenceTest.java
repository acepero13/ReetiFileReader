package de.dfki.reeti.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 4/13/17.
 */
public class SequenceTest {
    @Test
    public void test_write_PoseObject_XMLString() {
        Sequence sequence = new Sequence();

        Pose pose = new Pose();
        Duration duration = new Duration();
        duration.setTimeToMaintainPose(1.0);
        duration.setTimeToNeutralPose(0.3);
        duration.setTimeToReachPose(1.3);
        pose.setDuration(duration);
        pose.setName("Name");
        pose.setStartTime(1.0);
        pose.setTransiton("transition");
        pose.setMotorMovement(makeMovement());
        pose.activateBackToNeutral();
        sequence.addPose(pose);
        sequence.addProperty(makeProperty());
        String res = sequence.write();
        String expected = "<reeti>\n"
                +"<properties>\n" +
                "<property name=\"name\">name</property>\n" +
                "<property name=\"duration\">1.0</property>\n" +
                "<property name=\"soundUsed\">true</property>\n" +
                "<property name=\"imageUsed\">true</property>\n" +
                "<property name=\"functionUsed\">true</property>\n" +
                "<property name=\"earsUsed\">true</property>\n" +
                "<property name=\"eyesUsed\">true</property>\n" +
                "<property name=\"mouthUsed\">true</property>\n" +
                "<property name=\"neckUsed\">true</property>\n" +
                "<property name=\"colorUsed\">true</property>\n"+
                "</properties>\n"

                + "<sequence>\n"
                + "<pose name=\"Name\">\n"
                + "<transition>transition</transition>\n"
                + "<backToNeutral>true</backToNeutral>\n"
                + "<startTime>1.0</startTime>\n"
                + "<duration>\n"
                + "<timeToReachPose>1.3</timeToReachPose>\n"
                + "<timeToMaintainPose>1.0</timeToMaintainPose>\n"
                + "<timeToNeutralPose>0.3</timeToNeutralPose>\n"
                + "</duration>\n"
                + "<motors>\n"
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
                + "</motors>\n"
                + "</pose>\n"
                + "</sequence>\n"
                + "</reeti>";
        assertEquals(expected, res);
    }
    private Movement makeMovement() {
        Movement movement  = new Movement();
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
        return movement;
    }

    private Property makeProperty() {
        Property property = new Property();
        property.setName("name");
        property.setDuration(1.0);
        property.setSoundUsed(true);
        property.setImageUsed(true);
        property.setFunctionUsed(true);
        property.setEarsUsed(true);
        property.setEyesUsed(true);
        property.setMouthUsed(true);
        property.setNeckUsed(true);
        property.setColorUsed(true);
        return property;
    }
}