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
                String[] menuDetails = storedLine[1].split("//");
                store.addMenu(new Menu(menuDetails[0], Double.parseDouble(menuDetails[1])));
            } else if (storedLine[0].equals("review")) {
                String[] reviewDetails = storedLine[1].split("//");
                store.addReview(new Review(reviewDetails[0], Double.parseDouble(reviewDetails[1])));
            } else {
                continue;
            }
        }
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
