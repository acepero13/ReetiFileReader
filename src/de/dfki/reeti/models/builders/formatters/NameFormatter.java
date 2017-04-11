package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.builders.formatters.base.StringFormatter;

/**
 * Created by alvaro on 4/11/17.
 */
public class NameFormatter extends StringFormatter {
    @Override
    public void buildObject() {
        String value = getValue();
        pose.setName(value);
    }
}
