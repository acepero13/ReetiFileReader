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

    public void addProperty(Property property){
        this.property = property;
    }

    @Override
    public String write() {
        StringBuilder xml = new StringBuilder();
        xml.append("<reeti>\n")
                .append(property.write()+"\n")
                .append("<sequence>\n");
        for (Pose pose:poses ) {
            xml.append(pose.write());
        }
        xml.append("\n</sequence>\n");
        xml.append("</reeti>");
        return xml.toString();
    }
}
