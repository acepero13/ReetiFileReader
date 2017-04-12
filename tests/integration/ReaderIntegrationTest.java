package integration;

import de.dfki.reeti.files.filestystem.FileSystemAble;
import de.dfki.reeti.files.filestystem.rmdl.RMDLFileSystem;
import de.dfki.reeti.files.readers.FileReader;
import de.dfki.reeti.files.readers.rmdl.RMDLReader;
import de.dfki.reeti.models.Sequence;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
/**
 * Created by alvaro on 4/12/17.
 */
public class ReaderIntegrationTest {
    private FileReader reader;
    @Test
    public void test_readResFile_GoodFile_FileParsed() {
        File file = new File("tests/res/files/goodBye.rmdl");
        FileSystemAble fileSystem = new RMDLFileSystem(file.getAbsolutePath());
        reader = new RMDLReader(file.getAbsolutePath(), fileSystem);
        reader.open();
        reader.read();
        Sequence sequence = ((RMDLReader)reader).getSequence();
        assertNotNull(sequence.getProperty());
        assertEquals(11, sequence.getPoses().size());
    }
}
