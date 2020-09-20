package epam.dedik.day5.data;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Guice;

@Guice
public class DataTransfer {

    @DataProvider(name = "getData")
    public Object[][] getData() {
        return new Object[][]{{
                "A regular expression, specified as a string, must first be compiled into an instance" +
                        " of this class. The resulting pattern can then be used to create a Matcher object " +
                        "that can match arbitrary character sequences against the regular expression. All of the" +
                        " state involved in performing a match resides in the matcher, so many matchers can share " +
                        "the same pattern."
        }};
    }
}
