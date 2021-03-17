package canteens;

import stores.Store;

import java.util.ArrayList;

/**
 * Represents a canteen, with all its stores and functionality.
 */
public class Canteen {
    private String canteenName;
    private ArrayList<Store> stores;

    public static int CanteenCount;

    public Canteen(String canteenName) {
        this.canteenName = canteenName;
        stores = new ArrayList<>();
        CanteenCount++;
    }

    public void addStore(String storeName) {
        Store newStore = new Store(storeName);
        stores.add(newStore);
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
