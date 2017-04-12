package de.dfki.reeti.builders;

import de.dfki.reeti.models.Property;
import de.dfki.reeti.models.Sequence;
import de.dfki.reeti.parsers.LineParser;
import de.dfki.reeti.parsers.PropertyParser;



/**
 * Created by alvaro on 3/7/17.
 * Handles a property line
 */
public class PropertyHandler extends RettiBuilderHandler{
    Property property;
    public PropertyHandler(Sequence sequence){
        super(sequence);
        parser = new PropertyParser(sequence);
    }

    @Override
    protected void parse() {
        String key = ((LineParser)parser).getKey();
        String value = (String) ((LineParser) parser).getValue();
        getValues().put(key, value);
        property = sequence.getProperty();
        property.add(key, value);
    }


}
