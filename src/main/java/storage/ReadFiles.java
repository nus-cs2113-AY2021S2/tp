package storage;

import canteens.Canteen;
import menus.Menu;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFiles extends Storage {

    private static BufferedReader reader;
    private static ArrayList<Canteen> canteens;
    private static final String DEFAULT_STORAGE_DIRECTORY = "data";

    public ReadFiles(BufferedReader reader) {
        this.reader = reader;
        this.canteens = new ArrayList<Canteen>();
    }

    @Override
    public ArrayList<Canteen> execute() throws IOException {
        readFiles(reader);
        return canteens;
    }

    private void readFiles(BufferedReader reader) throws IOException {
        String line;
        if (new File(DEFAULT_STORAGE_FILEPATH).exists()) {
            Ui.showDirectoryFound();
            Scanner sc = new Scanner(new File(DEFAULT_STORAGE_FILEPATH));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                filterLine(line);
            }
        } else {
            File d = new File(DEFAULT_STORAGE_DIRECTORY);
            if (d.mkdir()) {
                Ui.showDirectoryCreated();
            }
            PrintWriter pw = new PrintWriter(DEFAULT_STORAGE_FILEPATH);
            while ((line = reader.readLine()) != null) {
                pw.println(line);
                filterLine(line);
            }
            pw.close();
        }
    }

    private void filterLine(String line) {
        Canteen canteen;
        Store store;
        String[] storedLine = line.split("<>");

        switch (storedLine.length) {
        case 1:
            canteen = new Canteen(storedLine[0]);
            canteens.add(canteen);
            break;
        case 2:
            //check if canteen exist
            canteen = findDuplicateCanteen(storedLine[0]);
            //add new store to canteen
            store = new Store(storedLine[1]);
            canteen.getStores().add(store);
            break;
        case 3:
            String[] reviewDetails = storedLine[2].split("//");
            //check if canteen exist
            canteen = findDuplicateCanteen(storedLine[0]);
            //check if store exist
            store = findDuplicateStore(canteen, storedLine[1]);
            store.addReview(new Review(reviewDetails[0], Double.parseDouble(reviewDetails[1]), reviewDetails[2]));
            break;
        case 4:
            //check if canteen exist
            canteen = findDuplicateCanteen(storedLine[0]);
            //check if store exist
            store = findDuplicateStore(canteen, storedLine[1]);
            store.addMenu(new Menu(storedLine[2], Double.parseDouble(storedLine[3])));
            break;
        default:
            System.out.println("file corrupted!");
        }
    }

    private Store findDuplicateStore(Canteen canteen, String storeName) {
        Store store = null;
        boolean hasStore = false;

        for (Store storeIndex : canteen.getStores()) {
            //if have store then assign it
            if (storeIndex.getStoreName().equals(storeName)) {
                store = storeIndex;
                hasStore = true;
            }
        }
        //if dont have store then add store
        if (!hasStore) {
            store = new Store(storeName);
            canteen.getStores().add(store);
        }
        return store;
    }

    private Canteen findDuplicateCanteen(String canteenName) {
        Canteen canteen = null;
        boolean hasCanteen = false;

        //check for duplicate canteens
        for (Canteen canteenIndex : canteens) {
            //meaning canteen already exist
            if (canteenIndex.getCanteenName().equals(canteenName)) {
                canteen = canteenIndex;
                hasCanteen = true;
            }
        }
        //its a new canteen
        if (!hasCanteen) {
            canteen = new Canteen(canteenName);
            canteens.add(canteen);
        }
        return canteen;
    }

}
