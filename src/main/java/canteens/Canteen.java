package canteens;

import stores.Store;

import java.util.ArrayList;

/**
 * Represents a canteen, with all its stores and functionality
 */
public class Canteen {
    private String canteenName;
    private ArrayList<Store> stores;

    public Canteen(String canteenName) {
        this.canteenName = canteenName;
        stores = new ArrayList<>();
    }

    public void displayCanteen() {
        System.out.println(canteenName);
    }

    public ArrayList<Store> getStores() {
        return stores;
    }
}
