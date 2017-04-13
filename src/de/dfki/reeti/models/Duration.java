package de.dfki.reeti.models;

import de.dfki.reeti.files.filestystem.XMLWritable;

/**
 * Created by alvaro on 4/11/17.
 */
public class Duration implements XMLWritable {
    private double timeToReachPose;
    private double timeToMaintainPose;
    private Double timeToNeutralPose;

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
        return null;
    }
}
