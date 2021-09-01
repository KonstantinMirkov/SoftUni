package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");
        PrintStream printStream = new PrintStream("Sum-Lines.txt");
        List<String> lines = Files.readAllLines(path);



        int sumOfLines = 0;
        for (String line : lines) {
            sumOfLines += getSumOFLines(line);

        }
        System.out.println(sumOfLines);
    }

    private static int getSumOFLines(String line) {
        int sum = 0;
        for (char symbol : line.toCharArray()) {
            sum += symbol;
        }
        return sum;
    }
}
