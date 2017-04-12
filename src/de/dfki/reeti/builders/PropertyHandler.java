package de.dfki.reeti.builders;

import de.dfki.reeti.models.Property;
import de.dfki.reeti.models.base.SequencePart;
import de.dfki.reeti.parsers.LineParser;
import de.dfki.reeti.parsers.PropertyParser;

import java.util.LinkedList;


/**
 * Created by alvaro on 3/7/17.
 * Handles a property line
 */
public class PropertyHandler extends RettiBuilderHandler{
    Property property;
    public PropertyHandler(LinkedList<SequencePart> sequence){
        super(sequence);
        parser = new PropertyParser();
    }

    @Override
    protected void parse() {
        String key = ((LineParser)parser).getKey();
        String value = (String) ((LineParser) parser).getValue();
        getValues().put(key, value);
        property = Property.getInstance();
        property.add(key, value);
    }


}
