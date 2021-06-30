package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String pathWords = "words.txt";
        String pathText = "text.txt";
        String outputPath = "outputCountWords.txt";
        PrintWriter writer = new PrintWriter(outputPath);
        LinkedHashMap<String, Integer> countWords = new LinkedHashMap<>();

        List<String> lines = Files.readAllLines(Path.of(pathWords));

        for (String line : lines) {
            Arrays.stream(line.split("\\s+")).forEach(
                    word ->
                            countWords.put(word, 0)
            );
        }

        for (String line : Files.readAllLines(Path.of(pathText))) {
            Arrays.stream(line.split("\\s+")).forEach(
                    word ->
                    {
                        if (countWords.containsKey(word)) {
                            countWords.put(word, countWords.get(word) + 1);
                        }
                    }
            );
        }

        for (Map.Entry<String, Integer> word : countWords.entrySet()) {
            writer.println(word.getKey() + " - " + word.getValue());
        }

        writer.close();
    }
}
