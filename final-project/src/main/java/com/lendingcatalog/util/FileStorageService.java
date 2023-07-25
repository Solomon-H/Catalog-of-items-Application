package com.lendingcatalog.util;

import com.lendingcatalog.util.exception.FileStorageException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorageService {

    // Requirement: File I/O
    public static void writeContentsToFile(String contents, String filename, boolean appendFile) throws FileStorageException {
        File file = new File(filename);
         try (PrintWriter printWriter = new PrintWriter(new FileOutputStream(file, appendFile))) {
             printWriter.println(contents);
           } catch (FileNotFoundException e) {
               throw new FileStorageException("unable to open the file " + filename);
        }

    }

    public static List<String> readContentsOfFile(String filename) throws FileStorageException {
        List<String> dataList = new ArrayList<>();
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String lineReader = scanner.nextLine();
                dataList.add(lineReader);
            }
        } catch (FileNotFoundException e) {
            throw new FileStorageException("unable to read the file " + filename);
        }
           return dataList;
    }
}

