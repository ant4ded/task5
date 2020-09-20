package by.epam.dedik.day5.service.impl;

public class CharacterArrayService {
    static final char[] DELIMITERS = {' ', '{', '}', '!', '\"', '#', '$', '%', '&', '\'',
            '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@',
            '[', '\\', ']', '^', '_', '`', '|', '~'};
    static final char[] VOWELS = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u', 'Y', 'y'};


    protected int nextDelimiter(char[] chars, int lastDelimiter) {
        int j;
        int i = lastDelimiter + 1;

        while (i < chars.length) {
            j = 0;
            while (j < DELIMITERS.length) {
                if (chars[i] == DELIMITERS[j++]) {
                    return i;
                }
            }
            i++;
        }
        return chars.length;
    }
}
