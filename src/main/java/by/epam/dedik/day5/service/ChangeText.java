package by.epam.dedik.day5.service;

import by.epam.dedik.day5.exception.WrongDataException;

public interface ChangeText {
    String changeSymbolByPosition(String text, char symbol, int position) throws WrongDataException;

    String changeLetterAfterLetter(String text, char afterLetter, char replaceLetter) throws WrongDataException;

    String changeWordByLength(String text, String word, int length) throws WrongDataException;
}
