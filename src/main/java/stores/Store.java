package stores;

import menus.Menu;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private ArrayList<Menu> menus;

    public Store(String storeName) {
        this.storeName = storeName;
        menus = new ArrayList<>();
    }

    public void displayStore() {
        System.out.println(storeName);
    }

    public String getStoreName() {
        return storeName;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void addMenu(Menu newMenu) {
        menus.add(newMenu);
    }
}
