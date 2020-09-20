package by.epam.dedik.day5.service.impl;

import by.epam.dedik.day5.exception.WrongDataException;
import by.epam.dedik.day5.service.ChangeText;

public class ArrayChangeService extends CharacterArrayService implements ChangeText {
    @Override
    public String changeSymbolByPosition(String text, char symbol, int position) throws WrongDataException {
        if (text == null || position < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s position: %d",
                    text, position));
        }
        char[] chars = text.toCharArray();
        int nextDelimiter;
        int lastDelimiter = 0;

        for (int i = 0; i < chars.length; i++) {
            nextDelimiter = nextDelimiter(chars, lastDelimiter);

            if (lastDelimiter == 0 && nextDelimiter - lastDelimiter > 1) {
                chars[lastDelimiter + position - 1] = symbol;
            } else if (nextDelimiter - lastDelimiter > 1) {
                chars[lastDelimiter + position] = symbol;
            }

            i = nextDelimiter;
            lastDelimiter = nextDelimiter;
        }
        return String.valueOf(chars);
    }

    @Override
    public String changeLetterAfterLetter(String text, char afterLetter, char replaceLetter) throws WrongDataException {
        if (text == null) {
            throw new WrongDataException("Wrong value of parameters text: null");
        }
        char[] chars = text.toCharArray();
        int nextDelimiter;
        int lastDelimiter = 0;

        for (int i = 0, j; i < chars.length; i++) {
            nextDelimiter = nextDelimiter(chars, lastDelimiter);

            if (nextDelimiter - lastDelimiter > 1) {
                j = lastDelimiter;
                while (j < nextDelimiter - 1) {
                    if (chars[j++] == afterLetter && chars[j] != nextDelimiter - 1) {
                        chars[j] = replaceLetter;
                    }
                }
            }

            i = nextDelimiter;
            lastDelimiter = nextDelimiter;
        }
        return String.valueOf(chars);
    }

    @Override
    public String changeWordByLength(String text, String word, int length) throws WrongDataException {
        if (text == null || length < 0) {
            throw new WrongDataException(String.format("Wrong value of parameters text: %s length: %d", text, length));
        }
        char[] chars = text.toCharArray();
        int nextDelimiter;
        int lastDelimiter = 0;
        int resultLastDelimiter = 0;
        int wordSize;

        int count = countWordsByLength(chars, length);
        int difference = count * (word.length() - length);
        char[] result = new char[chars.length + difference];

        for (int i = 0; i < chars.length; i++) {
            nextDelimiter = nextDelimiter(chars, lastDelimiter);
            wordSize = lastDelimiter == 0 ? nextDelimiter - lastDelimiter : nextDelimiter - lastDelimiter - 1;

            if (wordSize == length) {
                if (resultLastDelimiter != 0 && lastDelimiter != 0) {
                    result[resultLastDelimiter++] = chars[lastDelimiter];
                }

                System.arraycopy(word.toCharArray(), 0, result, resultLastDelimiter, word.length());
                resultLastDelimiter += word.length();
            } else {
                System.arraycopy(chars, lastDelimiter, result, resultLastDelimiter,
                        nextDelimiter - lastDelimiter + 1);
                resultLastDelimiter += nextDelimiter - lastDelimiter;
            }

            i = nextDelimiter;
            lastDelimiter = nextDelimiter;
        }
        return String.valueOf(result);
    }

    private int countWordsByLength(char[] chars, int length) {
        int nextDelimiter;
        int lastDelimiter = 0;
        int count = 0;
        int wordSize;

        for (int i = 0; i < chars.length; i++) {
            nextDelimiter = nextDelimiter(chars, lastDelimiter);
            wordSize = lastDelimiter == 0 ? nextDelimiter - lastDelimiter : nextDelimiter - lastDelimiter - 1;

            if (wordSize == length) {
                count++;
            }

            i = nextDelimiter;
            lastDelimiter = nextDelimiter;
        }
        return count;
    }
}
