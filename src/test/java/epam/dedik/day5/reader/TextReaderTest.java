package epam.dedik.day5.reader;

import by.epam.dedik.day5.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TextReaderTest {
    private TextReader reader;

    @BeforeClass
    private void setReader() {
        reader = new TextReader();
    }

    @Test
    public void readFromFile_filename_data() {
        String filename = "data.txt";
        Assert.assertNotNull(reader.readFromFile(filename));
    }

    @Test(expectedExceptions = RuntimeException.class, expectedExceptionsMessageRegExp = "Error opening file .+")
    public void readFromFile_incorrectFilename_runtimeException() {
        String filename = "dat.txt";
        reader.readFromFile(filename);
    }
}
