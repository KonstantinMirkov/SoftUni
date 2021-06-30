package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");

        PrintStream printStream = new PrintStream("Sum-Lines.txt");

        List<String> lines = Files.readAllLines(path);
        lines.forEach(SumLines::printSumOFLines);

    }

    static void printSumOFLines(String line) {
        int sum = 0;
        for (char symbol : line.toCharArray()) {
            sum += symbol;
        }
        System.out.println(sum);
    }
}
