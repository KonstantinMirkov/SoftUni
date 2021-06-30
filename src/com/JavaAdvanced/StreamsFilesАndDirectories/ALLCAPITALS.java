package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input.txt");

        List<String> lines = Files.readAllLines(path);

        BufferedWriter writer = new BufferedWriter(new FileWriter("Tester.txt"));

        for (String line : lines) {
            writer.write(line.toUpperCase(Locale.ROOT));
            writer.newLine();

        }
        writer.close();
    }
}
