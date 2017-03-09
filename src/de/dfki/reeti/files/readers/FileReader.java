package de.dfki.reeti.files.readers;

import de.dfki.reeti.files.exceptions.IncorrectFileExtension;
import de.dfki.reeti.files.filestystem.FileSystemAble;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by alvaro on 3/6/17.
 */
public abstract class FileReader implements Readable {
    protected String filename;
    protected FileSystemAble fileSystem;
    private BufferedReader bufferedReader;

    @Override
    public boolean open(String filname) throws IncorrectFileExtension, FileNotFoundException {
        this.filename = filname;
        return open();
    }

    @Override
    public boolean open() {
        try {
            bufferedReader = fileSystem.openFile();
        } catch (IncorrectFileExtension | FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void read() {
        try {
            readLineByLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readLineByLine() throws IOException {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            parse(line);
        }
    }

    @Override
    public abstract void parse(String line);
}
