package de.dfki.reeti.files.readers.rmdl;

import de.dfki.reeti.builders.PoseHandler;
import de.dfki.reeti.builders.PropertyHandler;
import de.dfki.reeti.builders.RettiBuilderHandler;
import de.dfki.reeti.files.filestystem.FileSystemAble;
import de.dfki.reeti.files.readers.FileReader;
import de.dfki.reeti.models.Sequence;

import java.util.HashMap;

/**
 * Created by alvaro on 3/6/17.
 */
public class RMDLReader extends FileReader {

    private RettiBuilderHandler firstHandlerPropertyHandler;
    private RettiBuilderHandler poseHandler;
    private Sequence sequence;

    public RMDLReader(){
        initHandlers();
    }

    private void initHandlers() {
        sequence = new Sequence();
        firstHandlerPropertyHandler = new PropertyHandler(sequence);
        poseHandler = new PoseHandler(sequence);
        firstHandlerPropertyHandler.setNextHandler(poseHandler);
    }

    public RMDLReader(String fileName) {
        this.filename = fileName;
        initHandlers();

    }

    public RMDLReader(String fileName, FileSystemAble fs) {
        fileSystem = fs;
        filename = fileName;
        initHandlers();
    }

    public RMDLReader(FileSystemAble fs) {
        fileSystem = fs;
        initHandlers();
    }


    @Override
    public void parse(String line) {
        firstHandlerPropertyHandler.append(line);
    }

    public HashMap<String, String> getPropertyValues(){
        return firstHandlerPropertyHandler.getValues();
    }

    public HashMap<String, String> getPoseValues(){
        return poseHandler.getValues();
    }

    public Sequence getSequence(){
        return sequence;
    }
}
