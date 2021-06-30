package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SortLines {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("input.txt");
        BufferedReader reader = new BufferedReader
                (new InputStreamReader(inputStream));

        String line = reader.readLine();

       List<String> lines = new ArrayList<>();
        while (line!= null){
            lines.add(line);
            line = reader.readLine();
        }

        Collections.sort(lines);
        Files.write(Path.of("soft-Lines"),lines);
    }
}
