package storage;

import canteens.Canteen;
import menus.Menu;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static BufferedReader reader;
    private static ArrayList<Canteen> canteens;
    public static final String separator = "<>";
    public static final String  DEFAULT_STORAGE_FILEPATH = "data/DoNotEdit.txt";
    private static final String DEFAULT_STORAGE_DIRECTORY = "data";

    public Storage(BufferedReader reader) {
        this.reader = reader;
        this.canteens = new ArrayList<Canteen>();
    }

    public static ArrayList<Canteen> load() throws IOException {
        readFiles(reader);
        return canteens;
    }

    private static void readFiles(BufferedReader reader) throws IOException {
        String line;
        if (new File(DEFAULT_STORAGE_FILEPATH).exists()) {
            Ui.showDirectoryFound();
            Scanner sc = new Scanner(new File(DEFAULT_STORAGE_FILEPATH));
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                readFunc(line);
            }
        } else {
            File d = new File(DEFAULT_STORAGE_DIRECTORY);
            if (d.mkdir()) {
                Ui.showDirectoryCreated();
            }
            PrintWriter pw = new PrintWriter(DEFAULT_STORAGE_FILEPATH);
            while ((line = reader.readLine()) != null) {
                pw.println(line);
                readFunc(line);
            }
            pw.close();
        }
    }

    private static void readFunc(String line) {
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
            canteen = findCanteen(storedLine[0]);
            //add new store to canteen
            store = new Store(storedLine[1]);
            canteen.getStores().add(store);
            break;
        case 3:
            String[] reviewDetails = storedLine[2].split("//");
            //check if canteen exist
            canteen = findCanteen(storedLine[0]);
            //check if store exist
            store = findStore(canteen, storedLine[1]);
            store.addReview(new Review(reviewDetails[0], Double.parseDouble(reviewDetails[1]),reviewDetails[2]));
            break;
        case 4:
            //check if canteen exist
            canteen = findCanteen(storedLine[0]);
            //check if store exist
            store = findStore(canteen, storedLine[1]);
            store.addMenu(new Menu(storedLine[2], Double.parseDouble(storedLine[3])));
            break;
        default:
            System.out.println("file corrupted!");
        }
    }

    private static Store findStore(Canteen canteen, String storeName) {
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

    private static Canteen findCanteen(String canteenName) {
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

    public static void save(FileWriter fw, ArrayList<Canteen> canteens) throws IOException {

        for (Canteen canteen :canteens) {
            //print canteen
            fw.write(canteen.getCanteenName() + "\n");
            for (Store store : canteen.getStores()) {
                //print canteen  + store
                fw.write(canteen.getCanteenName() + separator + store.getStoreName() + "\n");
                for (Review review: store.getReviews()) {
                    //print canteen + store + review
                    fw.write(canteen.getCanteenName() + separator + store.getStoreName() + separator
                            + review.getDescription() + "//" + review.getRating() + "//" + review.getDate() + "\n");
                }
                for (Menu menus : store.getMenus()) {
                    //print canteen + store + menuName + menuPrice
                    fw.write(canteen.getCanteenName() + separator + store.getStoreName() + separator
                            + menus.getItemName() + separator + menus.getPrice() + "\n");
                }
            }
        }
        fw.close();
    }

    public static void saveCanteen(FileWriter fw, String canteenName) throws IOException {
        fw.write(canteenName + "\n");
        fw.close();
    }

    public static void saveStore(FileWriter fw, String canteenName, String storeName) throws IOException {
        fw.write(canteenName + separator + storeName + "\n");
        fw.close();
    }

    public static void saveMenu(FileWriter fw, String canteenName, String storeName,
                                String menuName,String menuPrice) throws IOException {
        fw.write(canteenName + separator + storeName + separator + menuName
                    + separator + menuPrice + "\n");
        fw.close();
    }

    public static void saveReview(FileWriter fw, Canteen canteen, Store store,
                                  String description, String rating, String date) throws IOException {

        fw.write(canteen.getCanteenName() + separator
                + store.getStoreName() + separator + description + "//" + rating + "//" + date + "\n");
        fw.close();
    }

}

