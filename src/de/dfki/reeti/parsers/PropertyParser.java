package de.dfki.reeti.parsers;

import de.dfki.reeti.models.Sequence;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by alvaro on 3/7/17.
 * Parses property part:

 */
public class PropertyParser implements RMDLParser, LineParser{

    private static final int EQUAL_SIGNS_ALLOWED = 1;
    private final Sequence sequence;
    private String key = null;
    private String value = null;

    public PropertyParser(Sequence sequence){
        this.sequence = sequence;
    }

    @Override
    public boolean parse(String line) {
        if(line.equals("")){
            return false;
        }
        if(!lastCharacterString(line).equals(";")){
            return false;
        }
        if(!hasEqual(line)){
            return false;
        }
        parseKeyValue(line);
        sequence.addProperty(key, value);
        return true;
    }


    private void parseKeyValue(String line) {
        String trimmedLine = line.trim();
        int equalPosition = setParsedKey(trimmedLine);
        setParsedValue(trimmedLine, equalPosition);
    }

    private void setParsedValue(String trimmedLine, int equalPosition) {
        value = trimmedLine.substring(equalPosition+1, trimmedLine.length() -1);
    }

    private int setParsedKey(String trimmedLine) {
        int equalPosition = trimmedLine.indexOf('=');
        key = trimmedLine.substring(0, equalPosition);
        return equalPosition;
    }

    private boolean hasEqual(String line) {
        return EQUAL_SIGNS_ALLOWED == StringUtils.countMatches(line, "=");
    }

    private String lastCharacterString(String line) {
        return line.substring(line.length() - 1);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
