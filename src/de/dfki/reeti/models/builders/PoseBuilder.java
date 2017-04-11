package de.dfki.reeti.models.builders;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.NameFormatter;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.builders.formatters.StartTimeFormatter;

import java.util.HashMap;

/**
 * Created by alvaro on 4/10/17.
 */
public class PoseBuilder {
    HashMap<String, Formatter> formatters = new HashMap<>();
    public PoseBuilder(HashMap<String, String> values) {
        formatters.put("name", new NameFormatter());
        formatters.put("startTime", new StartTimeFormatter());

    }

    public Pose build() {
        return null;
    }
}
