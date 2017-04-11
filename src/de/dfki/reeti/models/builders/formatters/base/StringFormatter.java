package de.dfki.reeti.models.builders.formatters.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/10/17.
 */
public abstract class StringFormatter implements Formatter {
    protected String stringValue;
    protected Pose pose;
    @Override
    public void build(String value, Pose pose) throws InvalidValue {
        stringValue = value;
        this.pose = pose;
        buildObject();
    }

    public abstract void buildObject();

    @Override
    public String getValue(){
        return stringValue;
    }


}
