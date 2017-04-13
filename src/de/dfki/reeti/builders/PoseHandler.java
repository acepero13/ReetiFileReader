package de.dfki.reeti.builders;

import de.dfki.reeti.models.Sequence;
import de.dfki.reeti.parsers.PoseParser;


/**
 * Created by alvaro on 3/7/17.
 * Pose Handel
 */
public class PoseHandler extends RettiBuilderHandler {

    public PoseHandler(Sequence sequence) {
        super(sequence);
        parser = new PoseParser(sequence);
    }

    @Override
    protected void parse() {
        values = ((PoseParser) parser).getValues();
    }


}
