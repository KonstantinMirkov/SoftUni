package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String pathOne = "inputOne.txt";
        String pathTwo = "inputTwo.txt";
        String outputPath = "outputMerge.txt";

        PrintWriter writer = new PrintWriter(outputPath);
        Files.readAllLines(Path.of(pathOne))
                .forEach(writer::println);
        Files.readAllLines(Path.of(pathTwo))
                .forEach(writer::println);

        writer.close();

    }
}
