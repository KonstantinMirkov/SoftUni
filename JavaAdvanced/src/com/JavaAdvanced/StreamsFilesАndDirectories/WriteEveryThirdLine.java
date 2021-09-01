package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;


public class WriteEveryThirdLine {


    public static void main(String[] args) throws IOException {
        String filename = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";
        Path path = Paths.get(filename);
        List<String> lines = Files.readAllLines(path);
        for (int i = 0; i < lines.size(); i++) {
            if ((i + 1) % 3 == 0) {
                System.out.println(lines.get(i));
            }
        }
    }
}