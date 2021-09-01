package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.util.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Set<Character> separators = Set.of(' ', '\r', '\n');
        int nextByte = inputStream.read();
        PrintStream printStream = new PrintStream("copy-bites-out2.txt");

        while (nextByte != -1) {
            if (nextByte == ' ') {
                printStream.print((char) nextByte);
            } else if (nextByte == 10) {
                printStream.println();
            } else {
                printStream.print(nextByte);
            }
            nextByte = inputStream.read();
        }
    }
}
