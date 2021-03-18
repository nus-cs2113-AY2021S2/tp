/*
package io;

import parser.DataParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    private static DataParser dataParser;

    public FileManager() {
        dataParser = new DataParser();
    }

    // TODO: insert object
    public void saveFile(ArrayList<_> _) throws IOException {
        File path = new File("_.txt");
        if (!path.exists()) {
            if (!path.createNewFile()) {
                throw new IOException();
            }
        }
        FileWriter fileWriter = new FileWriter(path);
        for (_ _ : _) {
            fileWriter.write(_.formatData());
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public ArrayList<_> loadFile() throws FileNotFoundException {
        ArrayList<_> _ = new ArrayList<>();

        File path = new File("_.txt");
        if (!path.exists()) {
            throw new FileNotFoundException();
        }
        Scanner scanner = new Scanner(path);
        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                _ _ = dataParser.parseData(line);
                if (_ != null) {
                    _.add(_);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to load!");
        }
        return _;
    }
}
*/