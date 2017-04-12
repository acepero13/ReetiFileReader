package de.dfki.reeti.parsers;

/**
 * Created by alvaro on 3/7/17.
 */
public interface RMDLParser {
    boolean parse(String line);
    boolean isFinishedParsingObject();
}
