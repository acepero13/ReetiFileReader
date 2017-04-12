package de.dfki.reeti.files.filestystem;

import de.dfki.reeti.files.exceptions.IncorrectFileExtension;

import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * Created by alvaro on 3/6/17.
 * Interface
 */
public interface FileSystemAble {
    boolean fileExists();

    String getFileExtension();

    BufferedReader openFile() throws IncorrectFileExtension, FileNotFoundException;

    boolean checkFileExistance() throws FileNotFoundException;

    boolean checkFileExtension() throws IncorrectFileExtension;

    void close();


}
