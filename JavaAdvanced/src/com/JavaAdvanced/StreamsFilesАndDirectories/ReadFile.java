package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.util.*;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Set<Character> separators = Set.of(',', '.', '!', '?');
        int nextByte = inputStream.read();
        PrintStream printStream = new PrintStream("out.txt");

        while (nextByte != -1) {
            char symbol = (char) nextByte;
            if (!separators.contains(symbol)) {
                System.out.print(symbol);
            }
            nextByte = inputStream.read();
        }
    }
}
