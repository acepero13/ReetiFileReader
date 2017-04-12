package de.dfki.reeti.models;

/**
 * Created by alvaro on 4/10/17.
 */
public class Pose {
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
}
