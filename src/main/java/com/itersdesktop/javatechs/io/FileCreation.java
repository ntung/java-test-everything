package com.itersdesktop.javatechs.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCreation {
    public static void main(String[] args) throws IOException {
        String dir = "target" + File.separator + "indexing";
        Path dirPath = Paths.get(dir);
        if (!Files.exists(dirPath)) {
            Files.createDirectory(dirPath);
        }

        String fileName = "test.txt";
        Path filePath = dirPath.resolve(fileName);
        if (!Files.exists(filePath)) {
            Files.createFile(filePath);
        }

        File test = new File(dir, "test.txt");
        if (test.exists()) {
            System.out.println("File has been created.");
            writeUsingFiles("Dr Tung Nguyen", test.getAbsolutePath());
        } else {
            System.out.println("Errors occurred when creating the file.");
        }
    }

    private static void writeUsingFiles(String data, String absFilePath) {
        try {
            Files.write(Paths.get(absFilePath), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
