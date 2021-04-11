package storage;

import canteens.Canteen;
import stores.Store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile extends Storage {

    private static String separator = "<>";
    private static ArrayList<Canteen> canteens;

    public WriteToFile(){

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

    @Override
    public ArrayList<Canteen> execute() throws IOException {
        return canteens;
    }
}
