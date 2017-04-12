package de.dfki.reeti.models.builders.formatters.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/11/17.
 */
public abstract class BooleanFormatter implements Formatter{
    private boolean value;
    protected Pose pose;
    @Override
    public void build(String valueString, Pose pose) throws InvalidValue {
        this.pose = pose;
        parseValue(valueString);
        buildObject();
    }

    protected void parseValue(String valueString) {
        value = parseBoolean(valueString);
    }

    public static boolean parseBoolean(String valueString) {
        int parseInt = Integer.parseInt(valueString);
        return parseInt == 1;
    }

    @Override
    public abstract void buildObject() throws InvalidValue ;

    @Override
    public Boolean getValue() {
        return value;
    }
}
