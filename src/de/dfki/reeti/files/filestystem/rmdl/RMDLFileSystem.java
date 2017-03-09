package de.dfki.reeti.files.filestystem.rmdl;

import de.dfki.reeti.files.exceptions.IncorrectFileExtension;
import de.dfki.reeti.files.filestystem.FileSystemAble;
import org.apache.commons.io.FilenameUtils;

import java.io.*;

/**
 * Created by alvaro on 3/6/17.
 */
public class RMDLFileSystem implements FileSystemAble {
    private static final String RMDL_EXTENSION = "rmdl";
    private final String filename;
    private File file = null;
    private FileReader fileReader = null;
    private BufferedReader bufferedReader = null;

    public RMDLFileSystem(String filename){
        this.filename = filename;
    }
    @Override
    public boolean fileExists() {
        file = new File(this.filename);
        return file.exists() && !file.isDirectory();
    }

    @Override
    public String getFileExtension() {
        return FilenameUtils.getExtension(this.filename);
    }

    @Override
    public BufferedReader openFile() throws IncorrectFileExtension, FileNotFoundException {
        checkFileExtension();
        checkFileExistance();
        return getBufferedReader();
    }

    protected BufferedReader getBufferedReader() throws FileNotFoundException {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
        return bufferedReader;
    }

    @Override
    public boolean checkFileExistance() throws FileNotFoundException {
        if(!fileExists()){
            throw new FileNotFoundException();
        }
        return  true;
    }

    @Override
    public boolean checkFileExtension() throws IncorrectFileExtension {
        if(!getFileExtension().equals(RMDL_EXTENSION)){
            throw new IncorrectFileExtension();
        }
        return true;
    }

    @Override
    public void close() {
        try {
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
