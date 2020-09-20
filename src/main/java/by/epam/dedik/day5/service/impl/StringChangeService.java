package by.epam.dedik.day5.service.impl;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.ChangeText;

public class StringChangeService implements ChangeText {
    private static final String SYMBOL_BY_POSITION = "(?<=\\b\\w{%d})[\\w]";
    private static final String WORD_WITH_LENGTH = "(?<=\\b)\\w{%d}(?!\\w)";
    private static final String LETTER = "\\w";

    @Override
    public String changeSymbolByPosition(String text, char symbol, int position) throws WrongDataException {
        if (text == null || position < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s position: %d",
                    text, position));
        }
        return text.replaceAll(String.format(SYMBOL_BY_POSITION, position - 1), String.valueOf(symbol));
    }

    @Override
    public String changeLetterAfterLetter(String text, char afterLetter, char replaceLetter) throws WrongDataException {
        if (text == null) {
            throw new WrongDataException("Wrong value of parameters text: null");
        }
        return text.replaceAll(afterLetter + LETTER, String.valueOf(afterLetter) + replaceLetter);
    }

    @Override
    public String changeWordByLength(String text, String word, int length) throws WrongDataException {
        if (text == null || length < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s length: %d", text, length));
        }
        return text.replaceAll(String.format(WORD_WITH_LENGTH, length), word);
    }
}
