package de.dfki.reeti.builders;

import de.dfki.reeti.parsers.LineParser;
import de.dfki.reeti.parsers.PropertyParser;


/**
 * Created by alvaro on 3/7/17.
 * Handles a property line
 */
public class PropertyHandler extends RettiBuilderHandler{

    //LinkedList <Property> properties = new LinkedList<>();

    public PropertyHandler(){
        super();
        parser = new PropertyParser();
    }

    @Override
    protected void write() {
        String key = ((LineParser)parser).getKey();
        String value = (String) ((LineParser) parser).getValue();
        getValues().put(key, value);
    }

}
