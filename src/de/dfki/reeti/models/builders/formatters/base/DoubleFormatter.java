package de.dfki.reeti.models.builders.formatters.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/11/17.
 */
public abstract class DoubleFormatter implements Formatter {
    private final Double defaultValue;
    protected Pose pose;
    private Double value = null;

    public DoubleFormatter(double defaultValue) {
        this.defaultValue = defaultValue;
    }

    public DoubleFormatter() {
        defaultValue = null;
    }

    public static Double parseDouble(String stringValue) throws InvalidValue {
        try {
            return Double.parseDouble(stringValue);
        } catch (NumberFormatException exeption) {
            throw new InvalidValue();
        }
    }

    @Override
    public void build(String stringValue, Pose pose) throws InvalidValue {
        this.pose = pose;
        try {
            value = parseDouble(stringValue);
        } catch (InvalidValue exception) {
            applyDefaultValue();
        }
        buildObject();
    }

    private void applyDefaultValue() throws InvalidValue {
        if (defaultValue != null) {
            value = defaultValue;
        } else {
            throw new InvalidValue();
        }
    }

    public abstract void buildObject();

    @Override
    public Double getValue() {
        return value;
    }


}
