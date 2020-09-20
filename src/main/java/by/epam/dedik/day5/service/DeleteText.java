package by.epam.dedik.day5.service;

import by.epam.dedik.day5.exception.WrongDataException;

public interface DeleteText {
    String deleteSymbolsExceptLetters(String text) throws WrongDataException;

    String deleteVowelWordsByLength(String text, int length) throws WrongDataException;
}
