package de.dfki.reeti.models.builders.formatters;

import de.dfki.reeti.models.Pose;
import de.dfki.reeti.models.builders.formatters.base.Formatter;
import de.dfki.reeti.models.exceptions.InvalidValue;
import org.jetbrains.annotations.NotNull;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by alvaro on 4/10/17.
 */
@Ignore
public class IntFormatterTest {
    @Test
    public void test_build_EmptyWithDefaultValueDefined_DefaultValue() throws InvalidValue {
        Formatter formatter = makeFormatter(0);
        Pose pose = new Pose();
        formatter.build("", pose);

       // assertEquals(0, pose.getTimeToReachPose());
    }

    @NotNull
    protected Formatter makeFormatter(double defaultValue) {
        return new StartTimeFormatter(defaultValue);
    }

    protected Formatter makeFormatter() {
        return new StartTimeFormatter();
    }

    @Test
    public void test_build_StringValue_Value() throws InvalidValue {
        Formatter formatter =  makeFormatter();
        Pose pose = new Pose();
        formatter.build("13", pose);
       // assertEquals(13, pose.getTimeToReachPose());
    }

    @Test(expected = InvalidValue.class)
    public void test_build_StringBadValueAndNoDefaultValue_Exception() throws InvalidValue {
        Formatter formatter = makeFormatter();
        Pose pose = new Pose();
        formatter.build("Hello World", pose);
    }

}