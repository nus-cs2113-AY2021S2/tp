package stores;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private ArrayList<String> menus;
    private ArrayList<String> reviews;


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

    public ArrayList<String> getMenus() {
        return menus;
    }
}
