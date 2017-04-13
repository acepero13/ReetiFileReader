package de.dfki.reeti.models;

import de.dfki.reeti.files.filestystem.XMLWritable;

/**
 * Created by alvaro on 4/11/17.
 */
public class Duration implements XMLWritable {
    private double timeToReachPose = -1;
    private double timeToMaintainPose = -1;
    private double timeToNeutralPose = -1;

    public double getTimeToReachPose() {
        return timeToReachPose;
    }

    public void setTimeToReachPose(Double timeToReachPose) {
        this.timeToReachPose = timeToReachPose;
    }

    public double getTimeToMaintainPose() {
        return timeToMaintainPose;
    }

    public void setTimeToMaintainPose(Double timeToMaintainPose) {
        this.timeToMaintainPose = timeToMaintainPose;
    }

    public Double getTimeToNeutralPose() {
        return timeToNeutralPose;
    }

    public void setTimeToNeutralPose(Double timeToNeutralPose) {
        this.timeToNeutralPose = timeToNeutralPose;
    }

    @Override
    public String write() {
        StringBuilder xml = new StringBuilder();
        xml.append("<duration>\n")
                .append("<timeToReachPose>").append(String.valueOf(timeToReachPose)).append("</timeToReachPose>\n")
                .append("<timeToMaintainPose>" + String.valueOf(timeToMaintainPose) + "</timeToMaintainPose>\n")
                .append("<timeToNeutralPose>" + String.valueOf(timeToNeutralPose) + "</timeToNeutralPose>\n")
                .append("</duration>");
        return xml.toString();
    }
}
