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
    public static int NO_OF_STARS = 5;
    private static final ArrayList<Review> reviewList = new ArrayList<>();
    private static int noOfReviews = 0;

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

    public static int getNoOfStars() {
        return NO_OF_STARS;
    }

    public static void setNoOfStars(int noOfStars) {
        NO_OF_STARS = noOfStars;
    }

    public static int getNoOfReviews() {
        return noOfReviews;
    }

    public static void setNoOfReviews(int noOfReviews) {
        Review.noOfReviews = noOfReviews;
    }

    public Review(String title, String category, int rating, String description) {
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.starRating = starRating(rating);
        this.description = description;
        LocalDate date = LocalDate.now();
        this.dateOfEntry = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

        reviewList.add(new Review(title, category, rating, description));
        noOfReviews++;
    }

    public String starRating(int rating) {
        String starRating = "";
        for (int i = 0; i < NO_OF_STARS; i++) {
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
}
