package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.builders.formatters.base.DoubleFormatter;

/**
 * Created by alvaro on 4/11/17.
 */
public class StartTimeFormatter extends DoubleFormatter {
    public StartTimeFormatter(double defaultValue){
        super(defaultValue);
    }

    public StartTimeFormatter(){
        super();
    }

    @Override
    public void buildObject() {
        Double value = getValue();
        pose.setStartTime(value);
    }


}
