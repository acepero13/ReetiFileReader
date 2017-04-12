package de.dfki.reeti.models.builders.formatters.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/10/17.
 */
public abstract class IntFormatter implements Formatter {
    private final Integer defaultValue;
    private Integer intValue;

    public IntFormatter(int defaultValue) {
        this.defaultValue = defaultValue;
    }

    public IntFormatter() {
        defaultValue = null;
    }

    @Override
    public void build(String value, Pose pose) throws InvalidValue {
        intValue = null;
        try {
            intValue = Integer.parseInt(value);
        } catch (NumberFormatException numberExc) {
            intValue = getDefaultValue();
        }
    }

    private Integer getDefaultValue() throws InvalidValue {
        if (defaultValue != null) {
            intValue = defaultValue;
            return intValue;
        }
        throw new InvalidValue();
    }


}
