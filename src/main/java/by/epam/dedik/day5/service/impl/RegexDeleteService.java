package by.epam.dedik.day5.service.impl;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.DeleteText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDeleteService implements DeleteText {
    private static final String WORD_WITH_FIRST_VOWEL = "(?<=\\b)[aeiouy]\\w{%d}(?!\\w)";
    private static final String PUNCTUATION_BETWEEN_LETTERS = "\\w\\p{Punct}\\w";
    private static final String PUNCTUATION = "\\p{Punct}";
    private static final String NUMBERS = "\\d";
    private static final String SPACE = " ";
    private static final String EMPTY = "";


    @Override
    public String deleteSymbolsExceptLetters(String text) throws WrongDataException {
        if (text == null) {
            throw new WrongDataException("Wrong value of parameters text: null");
        }
        Pattern patternBetween = Pattern.compile(PUNCTUATION_BETWEEN_LETTERS);
        Matcher matcherBetween = patternBetween.matcher(text);
        Pattern patternPunctuation = Pattern.compile(PUNCTUATION);
        Matcher matcherPunctuation = patternPunctuation.matcher(matcherBetween.replaceAll(SPACE));
        Pattern patternNumbers = Pattern.compile(NUMBERS);
        Matcher matcherNumbers = patternNumbers.matcher(matcherPunctuation.replaceAll(EMPTY));
        return matcherNumbers.replaceAll(EMPTY);
    }

    @Override
    public String deleteVowelWordsByLength(String text, int length) throws WrongDataException {
        if (text == null || length < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s length: %d", text, length));
        }
        return Pattern.compile(String.format(WORD_WITH_FIRST_VOWEL, length - 1)).matcher(text).replaceAll(EMPTY);
    }
}
