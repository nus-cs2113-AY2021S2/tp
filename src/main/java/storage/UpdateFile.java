package storage;

import canteens.Canteen;
import menus.Menu;
import reviews.Review;
import stores.Store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class UpdateFile extends Storage {

    private static String separator = "<>";
    private static ArrayList<Canteen> canteens;

    public UpdateFile(){

    }

    public static void deleteAndUpdateFile(FileWriter fw, ArrayList<Canteen> canteens) throws IOException {

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

    @Override
    public ArrayList<Canteen> execute() throws IOException {
        return canteens;
    }
}
