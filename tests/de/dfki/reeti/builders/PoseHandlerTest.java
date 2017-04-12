package de.dfki.reeti.builders;

import de.dfki.reeti.models.Sequence;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

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

    @Test
    public void test_appendLine_GoodNameLine_PropertyObject() {
        makePoseHandler();
    }

    private void makePoseHandler() {
        poseHandler = new PoseHandler(new Sequence());
    }
}