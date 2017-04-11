package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.builders.formatters.base.BooleanFormatter;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/11/17.
 */
public class BackToNeutralFormatter extends BooleanFormatter {
    @Override
    public void buildObject() throws InvalidValue {
        if(getValue())
            pose.activateBackToNeutral();
        else
            pose.deactivateBackToNeutral();
    }
}
