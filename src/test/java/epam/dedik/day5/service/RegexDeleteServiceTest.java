package epam.dedik.day5.service;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.impl.RegexDeleteService;
import epam.dedik.day5.data.DataTransfer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegexDeleteServiceTest {
    private RegexDeleteService regexDeleteService;

    @BeforeClass
    public void setRegexDeleteService() {
        regexDeleteService = new RegexDeleteService();
    }

    @Test(dataProvider = "getData", dataProviderClass = DataTransfer.class)
    public void deleteSymbolsExceptLetters_stringText_textWithoutSymbols(String text) throws WrongDataException {
        String expected = "A regular expression specified as a string must first be compiled into an " +
                "instance of this class The resulting pattern can then be used to create a Matcher object that " +
                "can match arbitrary character sequences against the regular expression All of the state involved " +
                "in performing a match resides in the matcher so many matchers can share the same pattern";
        expected = expected.trim();
        String actual = regexDeleteService.deleteSymbolsExceptLetters(text).trim();
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getData", dataProviderClass = DataTransfer.class)
    public void deleteVowelWordsByLength_stringText_textWithoutVowelWords(String text) throws WrongDataException {
        String expected = "A regular expression, specified  a string, must first be compiled into  " +
                "instance  this class. The resulting pattern can then be used to create a Matcher object that " +
                "can match arbitrary character sequences against the regular expression. All  the state involved  " +
                "performing a match resides  the matcher, so many matchers can share the same pattern.";
        expected = expected.trim();
        String actual = regexDeleteService.deleteVowelWordsByLength(text, 2).trim();
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = WrongDataException.class)
    public void deleteSymbolsExceptLetters_wrongData_exception() throws WrongDataException {
        regexDeleteService.deleteSymbolsExceptLetters(null);
    }

    @Test(expectedExceptions = WrongDataException.class)
    public void deleteVowelWordsByLength_wrongData_exception() throws WrongDataException {
        regexDeleteService.deleteVowelWordsByLength(null, -1);
    }
}
