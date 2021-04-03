package seedu.connoisseur.storage;

import java.util.ArrayList;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;

public class ConnoisseurData {
    private final String sortMethod;
    private final boolean displayStars;
    private final ArrayList<Review> reviewList;
    private final ArrayList<Recommendation> recoList;


    public ConnoisseurData(String sortMethod, boolean displayStars, ArrayList<Review> reviewList, 
            ArrayList<Recommendation> recoList) {
        this.sortMethod = sortMethod;
        this.displayStars = displayStars;
        this.reviewList = reviewList;
        this.recoList = recoList;
    }

    public String getSortMethod() {
        return this.sortMethod;
    }

    public boolean getDisplayStars() {
        return this.displayStars;
    }

    public ArrayList<Review> getReviews() {
        return this.reviewList;
    }

    public ArrayList<Recommendation> getRecommendations() {
        return this.recoList;
    }
}
