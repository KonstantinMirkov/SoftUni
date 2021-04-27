package com.JavaFundamentals.TextProcessingExercises;

import java.util.*;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        String[] pathParts = path.split("\\\\");
        String fullFileName = pathParts[pathParts.length - 1];
        String filename = fullFileName.split("\\.")[0];
                String extension =fullFileName.split("\\.")[1];
        Print(filename, extension);
    }

    private static void Print(String filename, String extension) {
        System.out.println("File name: " + filename);
        System.out.println("File extension: " + extension);
    }
}
