package by.epam.dedik.day5.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextReader {
    public String readFromFile(String file) {
        String data;
        try (FileReader fileReader = new FileReader(getClass().getClassLoader().getResource(file).getFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            data = bufferedReader.lines().collect(Collectors.joining(" "));
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Error opening file " + file, e);
        }
        return data;
    }

    public String readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.next();
        scanner.close();
        return data;
    }
}
