package de.dfki.reeti.builders;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by alvaro on 3/7/17.
 */
public class PoseHandlerTest {
    private RettiBuilderHandler poseHandler;


    @Test
    public void test_appendLine_GoodNameLine_NameLineAdded() {
        makePoseHandler();
        poseHandler.append("<description>");
        poseHandler.append("<Pose>");
        poseHandler.append("<name>Conversation/eyesLeft</name>");
        poseHandler.append("<startTime>0</startTime>");
        poseHandler.append("</Pose>");
        poseHandler.append("</description>");
        HashMap<String, String> parsed = poseHandler.getValues();
        assertEquals(2, parsed.size());
    }

    private void makePoseHandler() {
        poseHandler = new PoseHandler();
    }
}