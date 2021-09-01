package com.JavaAdvanced.StreamsFilesАndDirectories;

import java.io.*;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources";
        File folder = new File(path);

        int folderSize = 0;
        for (File file : folder.listFiles()) {
            folderSize += file.length();
        }

        System.out.println("Folder size: " + folderSize);

    }
}
