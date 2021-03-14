package stores;

import menus.Menu;
import reviews.Review;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private ArrayList<Review> reviews;
    private ArrayList<Menu> menus;


    public Store(String storeName) {
        this.storeName = storeName;
        menus = new ArrayList<>();
        reviews = new ArrayList<>();
    }

    public void displayStore() {
        System.out.println(storeName);
    }


    public ArrayList<Review> getReviews() {
        return reviews;
    }


    public String getStoreName() {
        return storeName;
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void addReview(Review newReview) {
        reviews.add(newReview);
    }

    public void addMenu(Menu newMenu) {
        menus.add(newMenu);
    }
}
