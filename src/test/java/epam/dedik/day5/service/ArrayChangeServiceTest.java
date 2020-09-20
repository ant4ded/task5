package epam.dedik.day5.service;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.impl.ArrayChangeService;
import epam.dedik.day5.data.DataTransfer;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ArrayChangeServiceTest {
    public ArrayChangeService arrayChangeService;

    @BeforeClass
    public void setArrayChangeService() {
        arrayChangeService = new ArrayChangeService();
    }

    @Test(dataProvider = "getData", dataProviderClass = DataTransfer.class)
    public void changeSymbolByPosition_string_correctString(String data) throws WrongDataException {
        String expected = "A r5gular e5pression, s5ecified a5 a5s5ring, m5st f5rst b5 c5mpiled i5to a5 i5stance" +
                " o5 t5is c5ass. T5e r5sulting p5ttern c5n t5en b5 u5ed t5 c5eate a5M5tcher o5ject t5at c5n m5tch " +
                "a5bitrary c5aracter s5quences a5ainst t5e r5gular e5pression. A5l o5 t5e s5ate i5volved i5" +
                " p5rforming a5m5tch r5sides i5 t5e m5tcher, s5 m5ny m5tchers c5n s5are t5e s5me p5ttern.";
        String actual = arrayChangeService.changeSymbolByPosition(data, '5', 2);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getData", dataProviderClass = DataTransfer.class)
    public void changeLetterAfterLetter_string_correctString(String data) throws WrongDataException {
        String expected = "A regular expressio5, specified as a string, must first be co5piled into an instance o5 " +
                "this class. The resulting pattern can then be used to create a Matcher o5ject that can match " +
                "arbitrary character sequences against the regular expressio5. All o5 the state invo5ved in " +
                "perfo5ming a match resides in the matcher, so many matchers can share the same pattern.";
        String actual = arrayChangeService.changeLetterAfterLetter(data, 'o', '5');
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "getData", dataProviderClass = DataTransfer.class)
    public void changeWordByLength_string_correctString(String data) throws WrongDataException {
        String expected = "A regular expression, specified 5 a string, must first 5 compiled into 5 instance 5 " +
                "this class. The resulting pattern can then 5 used 5 create a Matcher object that can match " +
                "arbitrary character sequences against the regular expression. All 5 the state involved 5 " +
                "performing a match resides 5 the matcher, 5 many matchers can share the same pattern.";
        String actual = arrayChangeService.changeWordByLength(data, "5", 2);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = WrongDataException.class)
    public void changeSymbolByPosition_wrongData_exception() throws WrongDataException {
        arrayChangeService.changeSymbolByPosition(null, '5', -1);
    }

    @Test(expectedExceptions = WrongDataException.class)
    public void changeLetterAfterLetter_wrongData_exception() throws WrongDataException {
        arrayChangeService.changeLetterAfterLetter(null, 'o', '5');
    }

    @Test(expectedExceptions = WrongDataException.class)
    public void changeWordByLength_wrongData_exception() throws WrongDataException {
        arrayChangeService.changeWordByLength(null, "5", -1);
    }
}
