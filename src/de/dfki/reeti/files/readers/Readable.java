package de.dfki.reeti.files.readers;

import de.dfki.reeti.files.exceptions.IncorrectFileExtension;

import java.io.FileNotFoundException;

/**
 * Created by alvaro on 3/6/17.
 */
interface Readable {
    boolean open(String filname) throws IncorrectFileExtension, FileNotFoundException;
    boolean open();
    void read();
    void parse(String line);
}
