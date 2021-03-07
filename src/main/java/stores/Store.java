package stores;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private ArrayList<String> menus;

    public Store(String storeName) {
        this.storeName = storeName;
        menus = new ArrayList<>();
    }

    public void displayStore() {
        System.out.println(storeName);
    }

    public ArrayList<String> getMenus() {
        return menus;
    }
}
