package de.dfki.reeti.files.readers.rmdl;

import de.dfki.reeti.files.exceptions.IncorrectFileExtension;
import de.dfki.reeti.files.readers.FileReader;
import de.dfki.reeti.files.filestystem.FileSystemAble;
import de.dfki.reeti.files.filestystem.rmdl.RMDLFileSystem;
import de.dfki.reeti.models.Sequence;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.LinkedList;

import static org.junit.Assert.*;
/**
 * Created by alvaro on 3/6/17.
 */
public class RMDLReaderTest {
    private FileReader reader;

    @Test
    public void test_Open_WithExistingFilePathAndCorrectExtension_True() throws IncorrectFileExtension, FileNotFoundException {
        FileSystemAble fakeFS = new FakeFileSystem("/tmp/test.rmdl");
        makeReader("", fakeFS);
        boolean res = reader.open();
        assertTrue(res);
    }
    @Test
    public void test_Open_WithExistingFileAndWrongExtension_False() throws IncorrectFileExtension, FileNotFoundException {
        FakeFileSystem fakeFS = new FakeFileSystem("/tmp/test.rmdl");
        fakeFS.fileExtension = "txt";
        makeReader("", fakeFS);
        boolean res = reader.open();
        assertFalse(res);
    }

    @Test
    public void test_Open_WithNonExistingFileAndCorrectExtension_False() throws IncorrectFileExtension, FileNotFoundException {
        FakeFileSystem fakeFS = new FakeFileSystem("/tmp/test.rmdl");
        fakeFS.exists=false;
        makeReader("", fakeFS);
        boolean res = reader.open();
        assertFalse(res);
    }

    @Test
    public void test_read_WithDifferentLines_ReturnHashmaps() {
        FileSystemAble fakeFS = new FakeFileSystem("/tmp/test.rmdl");
        makeReader("", fakeFS);
        reader.open();
        reader.read();
        HashMap<String,String> properties = ((RMDLReader)reader).getPropertyValues();
        HashMap<String,String> poses = ((RMDLReader)reader).getPoseValues();
        assertEquals(10, properties.size());
        assertEquals(6, poses.size());
    }

    @Test
    public void test_read_DuplicatedLines_HasTwoSequences() throws FileNotFoundException {
        FileSystemAble fakeFS = new FakeFileSystem("/tmp/test.rmdl");
        makeReader("", fakeFS);
        FakeBufferReader bf = (FakeBufferReader) ((FakeFileSystem)fakeFS).getBufferedReader();
        bf.lines.add("");
        bf.lines.add("name=eyesRightCenter;");
        bf.lines.add("duration=0.13;");
        bf.lines.add("soundUsed=1;");
        bf.lines.add("imageUsed=1;");
        bf.lines.add("functionUsed=1;");
        bf.lines.add("earsUsed=1;");
        bf.lines.add("eyesUsed=1;");
        bf.lines.add("mouthUsed=1;");
        bf.lines.add("neckUsed=1;");
        bf.lines.add("colorUsed=1;");
        bf.lines.add("<description>");
        bf.lines.add("<Pose>");
        bf.lines.add("<name>Conversation/eyesRight</name>");
        bf.lines.add("<startTime>0.13</startTime>");
        bf.lines.add("<duration>0.13;1;1</duration>");
        bf.lines.add("<backToNeutral>1</backToNeutral>");
        bf.lines.add("<values>-1;-1;-1;-1;-1;-1;-1;-1;-1;42.5;42.5;91;76.5;-1;-1;-1</values>");
        bf.lines.add("<transition>smooth</transition>");
        bf.lines.add("</Pose>");

        bf.lines.add("</description>");
        bf.lines.add("");
        reader.open();
        reader.read();
        Sequence sequenceParts = ((RMDLReader)reader).getSequence();
        assertEquals(2, sequenceParts.getPoses().size());


    }



    private void makeReader(String fileName, FileSystemAble fs) {
        if(fileName.equals("")){
            reader = new RMDLReader(fs);
        }else {
            reader = new RMDLReader(fileName, fs);
        }
    }

    private class FakeFileSystem extends RMDLFileSystem {
        private boolean exists = true;
        private String fileExtension = "rmdl";
        public FakeBufferReader bufferReader;

        public FakeFileSystem(String filename) {
            super(filename);
            InputStreamReader input = new InputStreamReader(System.in);
            bufferReader =  new FakeBufferReader(input);
        }

        @Override
        public boolean fileExists() {
            return exists;
        }

        @Override
        public String getFileExtension() {
            return fileExtension;
        }

        public BufferedReader getBufferedReader() throws FileNotFoundException{
            return bufferReader;
        }



    }

    private class FakeBufferReader extends BufferedReader{

        public LinkedList<String> lines = new LinkedList();
        private int counter = 0;
        public FakeBufferReader(Reader in) {
            super(in);
            lines.add("name=eyesLeftCenter;");
            lines.add("duration=0.6;");
            lines.add("soundUsed=0;");
            lines.add("imageUsed=0;");
            lines.add("functionUsed=0;");
            lines.add("earsUsed=0;");
            lines.add("eyesUsed=1;");
            lines.add("mouthUsed=0;");
            lines.add("neckUsed=0;");
            lines.add("colorUsed=0;");
            lines.add("<description>");
            lines.add("<Pose>");
            lines.add("<name>Conversation/eyesLeft</name>");
            lines.add("<startTime>0</startTime>");
            lines.add("<duration>0.5;0;1</duration>");
            lines.add("<backToNeutral>0</backToNeutral>");
            lines.add("<values>-1;-1;-1;-1;-1;-1;-1;-1;-1;42.5;42.5;91;76.5;-1;-1;-1</values>");
            lines.add("<transition>smooth</transition>");
            lines.add("</Pose>");
            lines.add("");
            lines.add("</description>");
        }

        public String readLine(){
            if(counter >= lines.size()){
                counter = 0;
                return  null;
            }
            String value = lines.get(counter);
            counter++;
            return value;
        }
    }
}

