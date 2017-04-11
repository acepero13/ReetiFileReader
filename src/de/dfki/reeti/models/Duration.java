package de.dfki.reeti.models;

/**
 * Created by alvaro on 4/11/17.
 */
public class Duration {
    private double startTime;
    private double endTime;
    private Double step;

    public double getStartTime() {
        return startTime;
    }

    public double getEndTime() {
        return endTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public void setStep(Double step) {
        this.step = step;
    }
}
