package de.dfki.reeti.models;

import de.dfki.reeti.models.builders.formatters.base.BooleanFormatter;
import de.dfki.reeti.models.builders.formatters.base.DoubleFormatter;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 3/9/17.
 */
public class Property  {
    private String name = "";
    private double duration;
    private boolean soundUsed = false;
    private boolean imageUsed = false;
    private boolean functionUsed = false;
    private boolean earsUsed = false;
    private boolean eyesUsed = false;
    private boolean mouthUsed = false;
    private boolean neckUsed = false;
    private boolean colorUsed = false;


    public boolean isEyesUsed() {
        return eyesUsed;
    }

    public void setEyesUsed(boolean eyesUsed) {
        this.eyesUsed = eyesUsed;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isSoundUsed() {
        return soundUsed;
    }

    public void setSoundUsed(boolean soundUsed) {
        this.soundUsed = soundUsed;
    }

    public boolean isImageUsed() {
        return imageUsed;
    }

    public void setImageUsed(boolean imageUsed) {
        this.imageUsed = imageUsed;
    }

    public boolean isFunctionUsed() {
        return functionUsed;
    }

    public void setFunctionUsed(boolean functionUsed) {
        this.functionUsed = functionUsed;
    }

    public boolean isEarsUsed() {
        return earsUsed;
    }

    public void setEarsUsed(boolean earsUsed) {
        this.earsUsed = earsUsed;
    }

    public boolean isMouthUsed() {
        return mouthUsed;
    }

    public void setMouthUsed(boolean mouthUsed) {
        this.mouthUsed = mouthUsed;
    }

    public boolean isNeckUsed() {
        return neckUsed;
    }

    public void setNeckUsed(boolean neckUsed) {
        this.neckUsed = neckUsed;
    }

    public boolean isColorUsed() {
        return colorUsed;
    }

    public void setColorUsed(boolean colorUsed) {
        this.colorUsed = colorUsed;
    }

    public void add(String key, String value){
        switch (key){
            case "name":
                this.setName(value);
                break;
            case "duration":
                addDuration(value);
                break;
            case "soundUsed":
                this.setSoundUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "imageUsed":
                this.setImageUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "functionUsed":
                this.setFunctionUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "earsUsed":
                this.setEarsUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "eyesUsed":
                this.setEyesUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "mouthUsed":
                this.setMouthUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "neckUsed":
                this.setNeckUsed(BooleanFormatter.parseBoolean(value));
                break;
            case "colorUsed":
                this.setColorUsed(BooleanFormatter.parseBoolean(value));
                break;
        }
    }

    private void addDuration(String value) {
        try {
            this.setDuration(DoubleFormatter.parseDouble(value));
        } catch (InvalidValue invalidValue) {
            invalidValue.printStackTrace();
        }
    }
}
