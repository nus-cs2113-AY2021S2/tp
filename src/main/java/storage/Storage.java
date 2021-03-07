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
        this.canteens = new ArrayList<>();
    }

    public static ArrayList<Canteen> load() {
        try {
            File canteenFile = new File(filePath);
            Scanner fileReader = new Scanner(canteenFile);
            readFiles(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("File Path was not found!");
        }
        return canteens;
    }

    private static void readFiles(Scanner fileReader) {
        Canteen canteen = null;
        Store store = null;
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            String[] storedLine = line.split("<>");
            if (storedLine[0].equals("canteen")) {
                canteen = new Canteen(storedLine[1]);
                canteens.add(canteen);
            } else if (storedLine[0].equals("store")) {
                store = new Store(storedLine[1]);
                canteen.getStores().add(store);
            } else if (storedLine[0].equals("menu")) {
                store.getMenus().add(storedLine[1]);
            } else {
                continue;
            }
        }
    }
}
