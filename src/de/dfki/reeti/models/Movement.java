package de.dfki.reeti.models;

import de.dfki.reeti.files.filestystem.XMLWritable;

/**
 * Created by alvaro on 4/10/17.
 */
public class Movement implements XMLWritable {
    private double neckRotat = -1;
    private double neckTilt = -1;
    private double neckPan = -1;
    private double leftLC = -1;
    private double rightLC = -1;
    private double topLip = -1;
    private double bottomLip = -1;
    private double leftEar = -1;
    private double rightEar = -1;
    private double leftEyeTilt = -1;
    private double rightEyeTilt = -1;
    private double leftEyePan = -1;
    private double rightEyePan = -1;
    private double leftEyeLid = -1;
    private double rightEyeLid = -1;
    private String color = "";

    public double getNeckRotat() {
        return neckRotat;
    }

    public void setNeckRotat(double neckRotat) {
        this.neckRotat = neckRotat;
    }

    public double getNeckTilt() {
        return neckTilt;
    }

    public void setNeckTilt(double neckTilt) {
        this.neckTilt = neckTilt;
    }

    public double getNeckPan() {
        return neckPan;
    }

    public void setNeckPan(double neckPan) {
        this.neckPan = neckPan;
    }

    public double getLeftLC() {
        return leftLC;
    }

    public void setLeftLC(double leftLC) {
        this.leftLC = leftLC;
    }

    public double getRightLC() {
        return rightLC;
    }

    public void setRightLC(double rightLC) {
        this.rightLC = rightLC;
    }

    public double getTopLip() {
        return topLip;
    }

    public void setTopLip(double topLip) {
        this.topLip = topLip;
    }

    public double getBottomLip() {
        return bottomLip;
    }

    public void setBottomLip(double bottomLip) {
        this.bottomLip = bottomLip;
    }

    public double getLeftEar() {
        return leftEar;
    }

    public void setLeftEar(double leftEar) {
        this.leftEar = leftEar;
    }

    public double getRightEar() {
        return rightEar;
    }

    public void setRightEar(double rightEar) {
        this.rightEar = rightEar;
    }

    public double getLeftEyeTilt() {
        return leftEyeTilt;
    }

    public void setLeftEyeTilt(double leftEyeTilt) {
        this.leftEyeTilt = leftEyeTilt;
    }

    public double getRightEyeTilt() {
        return rightEyeTilt;
    }

    public void setRightEyeTilt(double rightEyeTilt) {
        this.rightEyeTilt = rightEyeTilt;
    }

    public double getLeftEyePan() {
        return leftEyePan;
    }

    public void setLeftEyePan(double leftEyePan) {
        this.leftEyePan = leftEyePan;
    }

    public double getRightEyePan() {
        return rightEyePan;
    }

    public void setRightEyePan(double rightEyePan) {
        this.rightEyePan = rightEyePan;
    }

    public double getLeftEyeLid() {
        return leftEyeLid;
    }

    public void setLeftEyeLid(double leftEyeLid) {
        this.leftEyeLid = leftEyeLid;
    }

    public double getRightEyeLid() {
        return rightEyeLid;
    }

    public void setRightEyeLid(double rightEyeLid) {
        this.rightEyeLid = rightEyeLid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String write() {
        StringBuilder xml = new StringBuilder();
        xml.append("<motors>\n")
                .append("<motor name=\"neckRotat\">" + neckRotat + "</motor>\n")
                .append("<motor name=\"neckTilt\">" + neckTilt + "</motor>\n")
                .append("<motor name=\"neckPan\">" + neckPan + "</motor>\n")
                .append("<motor name=\"leftLC\">" + leftLC + "</motor>\n")
                .append("<motor name=\"rightLC\">" + rightLC + "</motor>\n")
                .append("<motor name=\"topLip\">" + topLip + "</motor>\n")
                .append("<motor name=\"bottomLip\">" + bottomLip+ "</motor>\n")
                .append("<motor name=\"leftEar\">" + leftEar + "</motor>\n")
                .append("<motor name=\"rightEar\">" + rightEar + "</motor>\n")
                .append("<motor name=\"leftEyeTilt\">" + leftEyeTilt+ "</motor>\n")
                .append("<motor name=\"rightEyeTilt\">" + rightEyeTilt + "</motor>\n")
                .append("<motor name=\"leftEyePan\">" + leftEyePan + "</motor>\n")
                .append("<motor name=\"rightEyePan\">" + rightEyePan + "</motor>\n")
                .append("<motor name=\"leftEyeLid\">" + leftEyeLid + "</motor>\n")
                .append("<motor name=\"rightEyeLid\">" + rightEyeLid + "</motor>\n")
                .append("<motor name=\"color\">" + color + "</motor>\n")
                .append("</motors>");
        return xml.toString();
    }
}
