package de.dfki.reeti.models;

import de.dfki.reeti.files.filestystem.XMLWritable;

import java.util.LinkedList;

/**
 * Created by alvaro on 4/12/17.
 */
public class Sequence implements XMLWritable {
    private Property property;
    private LinkedList<Pose> poses = new LinkedList<>();

    public Sequence() {
        property = new Property();
    }

    public Property getProperty() {
        return property;
    }

    public LinkedList<Pose> getPoses() {
        return poses;
    }

    public void addPose(Pose pose) {
        poses.add(pose);
    }

    public void addProperty(String key, String value) {
        property.add(key, value);
    }

    @Override
    public String write() {
        return null;
    }
}
