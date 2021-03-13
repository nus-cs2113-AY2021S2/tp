package stores;

import menus.Menu;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private ArrayList<String> reviews;
    private ArrayList<Menu> menus;


    public Store(String storeName) {
        this.storeName = storeName;
        menus = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public void displayStore() {
        System.out.println(storeName);
    }

    public void displayReviews() {
        int count=1;
        for (String review : reviews) {
            System.out.println(count+"."+review);
            count++;
        }

    }

    public ArrayList<String> getReviews() {
        return reviews;
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
