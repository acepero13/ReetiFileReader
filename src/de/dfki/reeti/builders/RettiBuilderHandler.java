package de.dfki.reeti.builders;

import de.dfki.reeti.models.base.SequencePart;
import de.dfki.reeti.parsers.RMDLParser;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by alvaro on 3/7/17.
 */
public abstract class RettiBuilderHandler {


    private RettiBuilderHandler nextHandler = null;
    RMDLParser parser = null;
    private LinkedList<SequencePart> sequence ;
    HashMap<String, String> values = new HashMap<>();

    public RettiBuilderHandler(LinkedList<SequencePart> sequences){
        this.sequence = sequences;
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

    public void add(SequencePart sequencePart){
        sequence.add(sequencePart);
    }

    public LinkedList<SequencePart> getSequence(){
        return sequence;
    }

    public HashMap<String, String> getValues() {
        return values;
    }
}
