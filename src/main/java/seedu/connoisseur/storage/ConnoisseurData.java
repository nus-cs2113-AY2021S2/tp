package seedu.connoisseur.storage;

import java.util.ArrayList;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;

public class ConnoisseurData {
    private final String sortMethod;
    private final ArrayList<Review> reviewList;
    private final ArrayList<Recommendation> recoList;

    public ConnoisseurData(String sortMethod, ArrayList<Review> reviewList, ArrayList<Recommendation> recoList) {
        this.sortMethod = sortMethod;
        this.reviewList = reviewList;
        this.recoList = recoList;
    }

    public String getSortMethod() {
        return this.sortMethod;
    }

    public ArrayList<Review> getReviewList() {
        return this.reviewList;
    }

    public ArrayList<Recommendation> getRecoList() {
        return this.recoList;
    }
}
