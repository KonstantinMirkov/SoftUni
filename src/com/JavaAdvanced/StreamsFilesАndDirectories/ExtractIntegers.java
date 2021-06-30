package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.util.*;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\input.txt";

       FileReader reader = new FileReader(path);
        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                System.out.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
