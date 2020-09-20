package by.epam.dedik.day5.service.impl;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.DeleteText;

public class ArrayDeleteService extends CharacterArrayService implements DeleteText {
    @Override
    public String deleteSymbolsExceptLetters(String text) throws WrongDataException {
        if (text == null) {
            throw new WrongDataException("Wrong value of parameters text: null");
        }
        char[] chars = text.toCharArray();
        int j;
        for (int i = 0; i < chars.length; i++) {
            j = 0;
            if (Character.isDigit(chars[i])) {
                chars[i++] = ' ';
            }
            while (j < CharacterArrayService.DELIMITERS.length) {
                if (chars[i] == CharacterArrayService.DELIMITERS[j++]) {
                    chars[i] = ' ';
                    break;
                }
            }
        }
        return String.valueOf(chars);
    }

    @Override
    public String deleteVowelWordsByLength(String text, int length) throws WrongDataException {
        if (text == null || length < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s length: %d", text, length));
        }
        char[] chars = text.toCharArray();
        int nextDelimiter;
        int lastDelimiter = 0;
        int resultLastDelimiter = 0;

        int size = sizeWordsWithFirstVowel(chars);
        char[] result = new char[chars.length - size];

        for (int i = 0; i < chars.length; i++) {
            nextDelimiter = nextDelimiter(chars, lastDelimiter);
            if (!isVowel(chars, lastDelimiter == 0 ? lastDelimiter : lastDelimiter + 1)) {
                System.arraycopy(chars, lastDelimiter, result, resultLastDelimiter,
                        nextDelimiter - lastDelimiter + 1);
                resultLastDelimiter += nextDelimiter - lastDelimiter;
            }

            i = nextDelimiter;
            lastDelimiter = nextDelimiter;
        }
        return String.valueOf(result);
    }

    private int sizeWordsWithFirstVowel(char[] chars) {
        int nextDelimiter;
        int lastDelimiter = 0;
        int wordsSize = 0;

        for (int i = 0; i < chars.length; i++) {
            nextDelimiter = nextDelimiter(chars, lastDelimiter);

            if (lastDelimiter == 0 && isVowel(chars, lastDelimiter)) {
                wordsSize += nextDelimiter - lastDelimiter;
            } else if (isVowel(chars, lastDelimiter + 1)) {
                wordsSize += nextDelimiter - lastDelimiter - 1;
            }

            i = nextDelimiter;
            lastDelimiter = nextDelimiter;
        }
        return wordsSize;
    }

    private boolean isVowel(char[] chars, int index) {
        int j = 0;
        while (j < CharacterArrayService.VOWELS.length) {
            if (chars[index] == CharacterArrayService.VOWELS[j++]) {
                return true;
            }
        }
        return false;
    }
}
