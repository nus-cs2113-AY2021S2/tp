package storage;

import canteens.Canteen;
import stores.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String filePath;
    private static ArrayList<Canteen> canteens;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public static ArrayList<Canteen> load() {
        try {
            File canteenFile = new File(filePath);
            Scanner fileReader = new Scanner(canteenFile);
            readFiles(fileReader);
        } catch(FileNotFoundException e) {
            System.out.println("File Path was not found!");
        }
        return canteens;
    }

    private static void readFiles(Scanner fileReader) {
        while(fileReader.hasNextLine()) {
            return;
        }
    }
}
