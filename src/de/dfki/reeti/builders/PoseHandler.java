package de.dfki.reeti.builders;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.Property;
import de.dfki.reeti.models.base.SequencePart;
import de.dfki.reeti.models.builders.PoseBuilder;
import de.dfki.reeti.models.exceptions.InvalidValue;
import de.dfki.reeti.parsers.PoseParser;

import java.util.LinkedList;


/**
 * Created by alvaro on 3/7/17.
 * Pose Handel
 */
public class PoseHandler extends RettiBuilderHandler{
    private Pose pose;
    private Property property;

    public PoseHandler(LinkedList<SequencePart> sequence){
        super(sequence);
        parser = new PoseParser();
    }

    @Override
    protected void parse() {
        shouldMakePose();
    }

    private void shouldMakePose() {

        try {
            makeSequence();
        } catch (InvalidValue invalidValue) {
            invalidValue.printStackTrace();
        }
    }

    private void makeSequence() throws InvalidValue {
        if(!parser.isFinishedParsingObject()){
            return;
        }
        finalizePropertyObject();
        createPoseBuilder();
        addSequence();
    }

    private void addSequence() {
        SequencePart part = new SequencePart(property, pose);
        addNewSequencePart(part);
    }

    private void createPoseBuilder() throws InvalidValue {
        PoseBuilder poseBuilder = new PoseBuilder(values);
        pose = poseBuilder.build();
    }

    private void addNewSequencePart(SequencePart part) {
        this.add(part);
    }

    private void finalizePropertyObject() {
        values = ((PoseParser)parser).getValues();
        property = Property.getInstance();
        Property.createProperty();
    }


}
