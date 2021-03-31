package canteens;

import stores.Store;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents a canteen, with all its stores and functionality.
 */
public class Canteen {
    private String canteenName;
    private ArrayList<Store> stores;

    private static Logger logger = Logger.getLogger(Store.class.getName());

    public Canteen(String canteenName) {
        this.canteenName = canteenName;
        stores = new ArrayList<>();
        logger.log(Level.INFO, "New Canteen object " + canteenName + " created");
    }

    public void addStore(String storeName) {
        logger.log(Level.INFO, "Creating new store in " + canteenName);
        Store newStore = new Store(storeName);
        stores.add(newStore);
    }

    public void deleteStore(int storeIndex) {
        stores.remove(storeIndex);
    }

    public int getNumStores() {
        return stores.size();
    }

    public ArrayList<Store> getStores() {
        return stores;
    }

    public Store getStore(int index) {

        return stores.get(index);
    }

    public String getCanteenName() {
        return canteenName;
    }
}
