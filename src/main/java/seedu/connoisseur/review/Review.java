package seedu.connoisseur.review;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Review {
    protected String title;
    protected String category;
    protected String dateOfEntry;
    protected int rating;
    protected String starRating;
    protected String description;
    public static int MAX_NUM_OF_STARS = 5;


    /**
     * Gets the date of the review. 
     * @return date of entry as a string
     */
    public String getDate() {
        return dateOfEntry;
    }

    /**
     * Gets the title of the review. 
     * @return title of review
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the review. 
     * @param title new title to be set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the category of the experience. 
     * @return category of the experience as a string
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the experience. 
     * @param category new category of experience
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets the rating of the experience. 
     * @return rating of the experience as an integer
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating of the experience. 
     * @param rating new rating to be set
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Gets the description of the experience. 
     * @return description of the experience as a string
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the experience. 
     * @param description new description to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Creates a review. 
     * @param title title of the review
     * @param category category of the experience
     * @param rating rating of the experience
     * @param description description of the experience
     */
    public Review(String title, String category, int rating, String description) {
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.starRating = starRating(rating);
        this.description = description;
        LocalDate date = LocalDate.now();
        this.dateOfEntry = date.format(DateTimeFormatter.ofPattern("MMM d yyyy"));

    }

    /**
     * Converts the rating to visual form. 
     * @param rating rating of the experience
     * @return rating of the experience as a string
     */
    public String starRating(int rating) {
        String starRating = "";
        for (int i = 0; i < MAX_NUM_OF_STARS; i++) {
            if (rating > 0) {
                starRating = starRating.concat("★");
            } else {
                starRating = starRating.concat("✰");
            }
            rating--;
        }
        return starRating;
    }

    /**
     * Converts the review to a string. 
     * @return review as a string for display
     */
    public String toString() {
        return title + "      " + rating + "      " + dateOfEntry;
    }

    //TODO: implement following functions
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
