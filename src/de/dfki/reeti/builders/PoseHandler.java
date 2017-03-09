package de.dfki.reeti.builders;

import de.dfki.reeti.parsers.PoseParser;


/**
 * Created by alvaro on 3/7/17.
 * Pose Handel
 */
public class PoseHandler extends RettiBuilderHandler{

    public PoseHandler(){
        super();
        parser = new PoseParser();
    }

    @Override
    protected void write() {
        values = ((PoseParser)parser).getValues();
    }
}
