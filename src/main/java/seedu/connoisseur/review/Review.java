package seedu.connoisseur.review;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Review {
    protected String title;
    protected String category;
    protected String dateOfEntry;
    protected int rating;
    protected String starRating;
    protected String description;
    public static int NUM_OF_STARS = 5;



    public String getDate() {
        return dateOfEntry;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static int getNumOfStars() {
        return NUM_OF_STARS;
    }

    public static void setNumOfStars(int noOfStars) {
        NUM_OF_STARS = noOfStars;
    }

    public Review(String title, String category, int rating, String description) {
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.starRating = starRating(rating);
        this.description = description;
        LocalDate date = LocalDate.now();
        this.dateOfEntry = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

    }

    public String starRating(int rating) {
        String starRating = "";
        for (int i = 0; i < NUM_OF_STARS; i++) {
            if (rating > 0) {
                starRating = starRating.concat("★");
            } else {
                starRating = starRating.concat("✰");
            }
            rating--;
        }
        return starRating;
    }

    public String toString() {
        return title + "      " + rating + "      " + dateOfEntry;
    }

    public static int getReviewIndex(String title2) {
        return 0;
    }

    public String reviewToText() {
        return null;
    }
    public static Review textToReview(String review) {
        return null;
    }
}
