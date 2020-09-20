package by.epam.dedik.day5.service.impl;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.DeleteText;

public class StringDeleteService implements DeleteText {
    private static final String PUNCTUATION_BETWEEN_LETTERS = "\\w\\p{Punct}\\w";
    private static final String PUNCTUATION = "\\p{Punct}";
    private static final String WORD_STARTS_WITH_VOWEL_WITH_LENGTH = "(?<=\\b)[eyuioa]\\w{%d}(?!\\w)";
    private static final String SPACE = " ";
    private static final String EMPTY = "";

    @Override
    public String deleteSymbolsExceptLetters(String text) throws WrongDataException {
        if (text == null) {
            throw new WrongDataException("Wrong value of parameters text: null");
        }
        return text.replaceAll(PUNCTUATION_BETWEEN_LETTERS, SPACE).replaceAll(PUNCTUATION, EMPTY);
    }

    @Override
    public String deleteVowelWordsByLength(String text, int length) throws WrongDataException {
        if (text == null || length < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s length: %d", text, length));
        }
        return text.replaceAll(String.format(WORD_STARTS_WITH_VOWEL_WITH_LENGTH, length - 1), EMPTY);
    }
}
