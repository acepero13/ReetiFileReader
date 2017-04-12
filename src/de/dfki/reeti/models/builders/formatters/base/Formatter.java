package de.dfki.reeti.models.builders.formatters.base;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/10/17.
 */
public interface Formatter {
    void build(String value, Pose pose) throws InvalidValue;

    void buildObject() throws InvalidValue;

    Object getValue();
}
