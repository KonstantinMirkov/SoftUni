package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class LineNumbers {
    public static int countRow = 1;

    public static void main(String[] args) throws IOException {
        String path = "input.txt";
        String outputPath = "outputLine.txt";
        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(path))
                .forEach(line -> writer.println(countRow++ + ". " + line));
        writer.close();
    }
}
