package de.dfki.reeti.builders;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.Property;
import de.dfki.reeti.models.Sequence;
import de.dfki.reeti.models.builders.PoseBuilder;
import de.dfki.reeti.models.exceptions.InvalidValue;
import de.dfki.reeti.parsers.PoseParser;


/**
 * Created by alvaro on 3/7/17.
 * Pose Handel
 */
public class PoseHandler extends RettiBuilderHandler{
    private Pose pose;
    private Property property;

    public PoseHandler(Sequence sequence){
        super(sequence);
        parser = new PoseParser(sequence);
    }

    @Override
    protected void parse() {
        values = ((PoseParser)parser).getValues();
    }


}
