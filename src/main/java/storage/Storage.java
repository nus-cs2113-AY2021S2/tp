package storage;

import canteens.Canteen;
import menus.Menu;
import reviews.Review;
import stores.Store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private static String filePath;
    private static ArrayList<Canteen> canteens;

    public Storage(String filePath) {
        this.filePath = filePath;
        this.canteens = new ArrayList<Canteen>();
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
        Canteen canteen;
        Store store;

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
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
                store = findStore(canteen,storedLine[1]);
                store.addReview(new Review(reviewDetails[0], Double.parseDouble(reviewDetails[1])));
                break;
            case 4:
                //check if canteen exist
                canteen = findCanteen(storedLine[0]);
                //check if store exist
                store = findStore(canteen,storedLine[1]);
                store.addMenu(new Menu(storedLine[2], Double.parseDouble(storedLine[3])));
                break;
            default:
                System.out.println("file corrupted!");
            }
        }
    }

    private static Store findStore(Canteen canteen,String storeName) {
        Store store = null;
        boolean hasStore = false;

        for (Store storeIndex :canteen.getStores()) {
            //if have store then assign it
            if (storeIndex.getStoreName().equals(storeName)) {
                store =  storeIndex;
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

    public static void save(ArrayList<Canteen> canteens) {
        try {
            FileWriter fw = new FileWriter(filePath);
            saveCanteens(fw, canteens);
            fw.close();
        } catch (IOException e) {
            System.out.println("File Path was not found!");
        }
    }

    public static void saveCanteens(FileWriter fw, ArrayList<Canteen> canteens) throws IOException {
        for (Canteen canteen: canteens) {
            fw.write("canteen<>" + canteen.getCanteenName() + "\n");
            ArrayList<Store> stores = canteen.getStores();
            saveStores(fw, stores);
        }
    }

    public static void saveStores(FileWriter fw, ArrayList<Store> stores) throws IOException {
        for (Store store: stores) {
            fw.write("store<>" + store.getStoreName() + "\n");
            ArrayList<Menu> menus = store.getMenus();
            ArrayList<Review> reviews = store.getReviews();
            saveMenus(fw, menus);
            saveReviews(fw, reviews);
        }
    }

    public static void saveMenus(FileWriter fw, ArrayList<Menu> menus) throws IOException {
        for (Menu menu: menus) {
            fw.write("menu<>" + menu.getItemName() + "//" + menu.getPrice() + "\n");
        }
    }

    public static void saveReviews(FileWriter fw, ArrayList<Review> reviews) throws IOException {
        for (Review review: reviews) {
            fw.write("menu<>" + review.getDescription() + "//" + review.getRating() + "\n");
        }
    }
}
