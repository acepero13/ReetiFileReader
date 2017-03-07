package de.dfki.reeti.builders;

import de.dfki.reeti.parsers.RMDLParser;

import java.util.HashMap;

/**
 * Created by alvaro on 3/7/17.
 */
public abstract class RettiBuilderHandler {
    protected RettiBuilderHandler nextHandler;
    protected RMDLParser parser;
    protected HashMap<String, String> values ;

    RettiBuilderHandler() {
        values = new HashMap<>();
    }

    public void setNextHandler(RettiBuilderHandler handler){
        nextHandler = handler;
    }

    public void append(String line){
        if(parser.parse(line)){
            write();
        }else if (nextHandler != null){
            nextHandler.append(line);
        }
    }

    protected abstract void write();

    public HashMap<String, String> getValues() {
        return values;
    }
}
