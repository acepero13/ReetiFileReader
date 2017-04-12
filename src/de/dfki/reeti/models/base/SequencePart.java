package de.dfki.reeti.models.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.Property;
import javafx.geometry.Pos;

/**
 * Created by alvaro on 4/12/17.
 */
public class SequencePart {
    private Property property;

    public Property getProperty() {
        return property;
    }

    public Pose getPose() {
        return pose;
    }

    private Pose pose;

    public SequencePart(Property property, Pose pose){
        this.property = property;
        this.pose = pose;
    }
}
