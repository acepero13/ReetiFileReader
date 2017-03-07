package de.dfki.reeti.parsers;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by alvaro on 3/7/17.
 * Parses this:
 * name=eyesLeftCenter;
 duration=0.6;
 soundUsed=0;
 imageUsed=0;
 functionUsed=0;
 earsUsed=0;
 eyesUsed=1;
 mouthUsed=0;
 neckUsed=0;
 colorUsed=0;
 */
public class PropertyParser implements RMDLParser, LineParser{

    private static final int EQUAL_SIGNS_ALLOWED = 1;
    private String key = null;
    private String value = null;

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
