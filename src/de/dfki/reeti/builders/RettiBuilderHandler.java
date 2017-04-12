package de.dfki.reeti.builders;

import de.dfki.reeti.models.Sequence;
import de.dfki.reeti.parsers.RMDLParser;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by alvaro on 3/7/17.
 */
public abstract class RettiBuilderHandler {


    private RettiBuilderHandler nextHandler = null;
    RMDLParser parser = null;
    protected Sequence sequence ;
    HashMap<String, String> values = new HashMap<>();

    public RettiBuilderHandler(Sequence sequence){
        this.sequence = sequence;
        values = new HashMap<>();
    }

    public void setNextHandler(RettiBuilderHandler handler){
        nextHandler = handler;
    }

    public void append(String line){
        if(parser.parse(line)){
            parse();
        }else if (nextHandler != null){
            nextHandler.append(line);
        }
    }

    protected abstract void parse();

    public HashMap<String, String> getValues() {
        return values;
    }
}
