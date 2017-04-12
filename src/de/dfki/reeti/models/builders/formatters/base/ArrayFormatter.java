package de.dfki.reeti.models.builders.formatters.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;


/**
 * Created by alvaro on 4/11/17.
 */
public abstract class ArrayFormatter implements Formatter {
    public static final String SEPARATOR = ";";
    protected Pose pose;
    private String[] values;

    @Override
    public void build(String value, Pose pose) throws InvalidValue {
        this.pose = pose;
        values = value.split(SEPARATOR);
        buildObject();
    }

    public abstract void buildObject() throws InvalidValue;

    @Override
    public String[] getValue() {
        return values;
    }
}
