package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources");

        PrintStream printStream = new PrintStream("ListFiles.txt");
        Deque<File> files = new ArrayDeque<>();
        files.offer(file);
        while (!files.isEmpty()) {
            File currentFile = files.poll();
            printStream.println(currentFile.getName());
            for (File f : currentFile.listFiles()) {
                if (f.isDirectory()) {
                    files.offer(f);
                } else {
                    printStream.println(f.getName());
                }
            }
        }
    }
}
