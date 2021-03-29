package stores;

import menus.Menu;
import reviews.Review;

import java.util.ArrayList;

public class Store {
    private String storeName;
    private ArrayList<Review> reviews;
    private ArrayList<Menu> menus;
    public static int storeCount;
    public static double ratingSum = 0;
    public static int ratingCount = 0;
    public static double averageRating;

    public Store(String storeName) {
        this.storeName = storeName;
        menus = new ArrayList<>();
        reviews = new ArrayList<>();
        storeCount++;
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

    public int getRatingCount() {
        return ratingCount;
    }

    public double getAverageRating() {
        for (Review rating : reviews) {
            ratingSum = ratingSum + rating.getRating();
            ratingCount++;
        }
        averageRating = ratingSum / ratingCount;
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public void addReview(Review newReview) {
        reviews.add(newReview);
    }

    public void deleteReview(int reviewCount) {
        reviews.remove(reviewCount - 1);
    }

    public void addMenu(Menu newMenu) {
        menus.add(newMenu);
    }
}
