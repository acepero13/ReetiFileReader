package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Duration;
import de.dfki.reeti.models.builders.formatters.base.ArrayFormatter;
import de.dfki.reeti.models.builders.formatters.base.DoubleFormatter;
import de.dfki.reeti.models.exceptions.InvalidValue;

/**
 * Created by alvaro on 4/11/17.
 */
public class DurationFormatter extends ArrayFormatter {

    private static final int START_TIME_INDEX = 0;
    private static final int END_TIME_INDEX = 1;
    private static final int STEP_INDEX = 2;
    public static final int TOTAL_INDEX = 3;
    private String[] durationValues;

    @Override
    public void buildObject() throws InvalidValue {
        durationValues = getValue();
        shouldBeValidDuration();
        Duration duration = getDuration();
        pose.setDuration(duration);
    }

    private void shouldBeValidDuration() throws InvalidValue {
        if(durationValues.length != TOTAL_INDEX){
            throw new InvalidValue();
        }
    }

    private Duration getDuration() throws InvalidValue {
        Duration duration = new Duration();
        duration.setStartTime(getParsedValue(START_TIME_INDEX));
        duration.setEndTime(getParsedValue(END_TIME_INDEX));
        duration.setStep(getParsedValue(STEP_INDEX));
        return duration;
    }

    private Double getParsedValue(int pos) throws InvalidValue {
       return DoubleFormatter.parseDouble(durationValues[pos]);
    }
}
