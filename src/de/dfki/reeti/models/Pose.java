package de.dfki.reeti.models;

import de.dfki.reeti.files.filestystem.XMLWritable;

/**
 * Created by alvaro on 4/10/17.
 */
public class Pose implements XMLWritable {
    private String name;
    private Double startTime;
    private Duration duration;
    private boolean backToNeutral;
    private Movement motorsMovement;
    private String transiton;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public boolean isBackToNeutralOn() {
        return backToNeutral;
    }

    public void activateBackToNeutral() {
        backToNeutral = true;
    }

    public void deactivateBackToNeutral() {
        backToNeutral = false;
    }

    public Movement getMotorsMovement() {
        return motorsMovement;
    }

    public void setMotorMovement(Movement motorMovement) {
        this.motorsMovement = motorMovement;
    }

    public String getTransiton() {
        return transiton;
    }

    public void setTransiton(String transiton) {
        this.transiton = transiton;
    }

    @Override
    public String write() {
        StringBuilder xml = new StringBuilder();
        xml.append("<pose name=\"" + name + "\">\n")
                .append("<transition>" + transiton + "</transition>\n")
                .append("<backToNeutral>" + backToNeutral + "</backToNeutral>\n")
                .append("<startTime>" + startTime + "</startTime>\n") ;
       xml.append(duration.write() + "\n");
       xml.append(motorsMovement.write() + "\n");
       xml.append("</pose>");
       return xml.toString();

    }
}
