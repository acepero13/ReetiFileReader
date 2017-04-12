package de.dfki.reeti.models.builders;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.*;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;

import java.util.HashMap;

/**
 * Created by alvaro on 4/10/17.
 */
public class PoseBuilder {
    private final HashMap<String, String> parsedValues;
    HashMap<String, Formatter> formatters = new HashMap<>();

    public PoseBuilder(HashMap<String, String> values) {
        formatters.put("name", new NameFormatter());
        formatters.put("startTime", new StartTimeFormatter());
        formatters.put("duration", new DurationFormatter());
        formatters.put("backToNeutral", new BackToNeutralFormatter());
        formatters.put("values", new MotorFormatter());
        formatters.put("transition", new TransitionFormatter());
        this.parsedValues = values;

    }

    public Pose build() throws InvalidValue {
        Pose pose = new Pose();
        formatValues(pose);
        return pose;

    }

    private void formatValues(Pose pose) throws InvalidValue {
        for (String key : parsedValues.keySet()) {
            Formatter formatter = formatters.get(key);
            String value = parsedValues.get(key);
            if (formatter != null)
                formatter.build(value, pose);
        }
    }
}
