package seedu.connoisseur.commands;

import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.storage.ConnoisseurData;
import seedu.connoisseur.ui.Ui;

import java.util.ArrayList;

import static seedu.connoisseur.messages.Messages.CATEGORY_PROMPT;
import static seedu.connoisseur.messages.Messages.PRICE_PROMPT;
import static seedu.connoisseur.messages.Messages.ADD_SUCCESS;
import static seedu.connoisseur.messages.Messages.RECOBY_PROMPT;
import static seedu.connoisseur.messages.Messages.MISSING_RECO_TITLE;
import static seedu.connoisseur.messages.Messages.LOCATION_PROMPT;
import static seedu.connoisseur.messages.Messages.MISSING_DELETE_TITLE;
import static seedu.connoisseur.messages.Messages.DELETE_SUCCESS;
import static seedu.connoisseur.messages.Messages.INVALID_DELETE_RECO_TITLE;
import static seedu.connoisseur.messages.Messages.INVALID_COMMAND;
import static seedu.connoisseur.messages.Messages.CONVERT_SUCCESS;

/**
 * Class with methods for different commands in recommendation mode.
 */
public class RecommendationList {
    private final Ui ui;
    public ArrayList<Recommendation> recommendations = new ArrayList<>();
    private ReviewList reviewList;

    public RecommendationList(ConnoisseurData connoisseurData, Ui ui, ReviewList reviewList) {
        this.ui = ui;
        this.recommendations = connoisseurData.getRecommendations();
        this.reviewList = reviewList;
    }

    public RecommendationList(Ui ui, ReviewList reviewList) {
        this.reviewList = reviewList;
        this.ui = ui;
    }

    /**
     * List reviews according to different types of input.
     */
    public void listRecommendations() {
        if (recommendations.size() == 0) {
            ui.printEmptyRecommendationListMessage();
        } else {
            printRecommendations(recommendations);
        }
    }

    /**
     * Prints the sorted recommendation.
     */
    public void printRecommendations(ArrayList<Recommendation> recommendationList) {
        ui.printRecommendationListHeading();
        for (int i = 0; i < recommendationList.size(); i++) {
            Recommendation currentRecommendation = recommendationList.get(i);
            ui.print("| " + (i + 1) + ". ");
            if (i < 9) {
                ui.print(" ");
            }
            ui.print(currentRecommendation.getTitle());
            ui.printWhiteSpaceTitle(currentRecommendation.getTitle().length());
            ui.print("| " + currentRecommendation.getCategory());
            ui.printWhiteSpace(currentRecommendation.getCategory().length());
            ui.print("| " + currentRecommendation.priceRange());
            ui.printWhiteSpace(currentRecommendation.priceRange().length());
            ui.print("| " + currentRecommendation.getLocation());
            ui.printWhiteSpace(currentRecommendation.getLocation().length());
            ui.print("| " + currentRecommendation.getRecommendedBy());
            ui.printWhiteSpace(currentRecommendation.getRecommendedBy().length());
            ui.println("|");
        }
        ui.printTableEndBorderForReco();
    }

    /**
     * Checks for duplicate recommendation.
     *
     * @param title title of recommendation.
     */
    public boolean checkAndPrintDuplicateRecommendation(String title) {
        int recIndex = -1;
        for (int i = 0; i < recommendations.size(); i++) {
            if ((recommendations.get(i).getTitle().toLowerCase()).compareTo(title.toLowerCase()) == 0) {
                recIndex = i;
            }
        }
        if (recIndex != -1) {
            System.out.println("There is a recommendation in your list with the same title: ");
            Recommendation currentRecommendation = recommendations.get(recIndex);
            ui.print((recommendations.indexOf(currentRecommendation) + 1) + ". ");
            if (recommendations.indexOf(currentRecommendation) < 9) {
                ui.print(" ");
            }
            ui.print(currentRecommendation.getTitle());
            ui.printWhiteSpace(currentRecommendation.getTitle().length());
            ui.print(currentRecommendation.getCategory());
            ui.printWhiteSpace(currentRecommendation.getCategory().length());
            ui.print(currentRecommendation.priceRange());
            ui.printWhiteSpace(currentRecommendation.priceRange().length());
            ui.println(currentRecommendation.getRecommendedBy());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a recommendation.
     *
     * @param title title of recommendation
     */
    public void addRecommendation(String title) {
        try {
            addRecommendationDetails(title);
        } catch (DuplicateException de) {
            System.out.println("Please try again with a unique title instead!");
        }
    }

    /**
     * Prompts for details of recommendation.
     *
     * @param title title of recommendation.
     */
    public void addRecommendationDetails(String title) throws DuplicateException {
        if (title == null || title.isBlank()) {
            ui.println(MISSING_RECO_TITLE);
            return;
        }
        boolean isDuplicate;
        isDuplicate = checkAndPrintDuplicateRecommendation(title);
        if (isDuplicate) {
            throw new DuplicateException();
        }
        ui.println(CATEGORY_PROMPT);
        String category = ui.readCommand().toLowerCase();
        ui.println(PRICE_PROMPT);
        try {
            String priceRange = ui.readCommand();
            double priceLow;
            double priceHigh;
            double priceFirst = Double.parseDouble(priceRange.split("-", 2)[0].trim());
            double priceSecond = Double.parseDouble(priceRange.split("-", 2)[1].trim());
            if (priceFirst > priceSecond) {
                priceLow = priceSecond;
                priceHigh = priceFirst;
            } else {
                priceLow = priceFirst;
                priceHigh = priceSecond;
            }
            priceLow = Math.round(priceLow * 100.0) / 100.0;
            priceHigh = Math.round(priceHigh * 100.0) / 100.0;
            ui.println(RECOBY_PROMPT);
            String recommendedBy = ui.readCommand();
            ui.println(LOCATION_PROMPT);
            String location = ui.readCommand();
            Recommendation r = new Recommendation(title, category, priceLow, priceHigh, recommendedBy, location);
            recommendations.add(r);
            ui.println(title + ADD_SUCCESS);
        } catch (NumberFormatException e) {
            ui.printInvalidRatingMessage();
        }
    }

    /**
     * Delete review.
     */
    public void deleteRecommendation(String title) {
        if (title == null || title.isBlank()) {
            ui.println(MISSING_DELETE_TITLE);
            return;
        }
        int reviewIndex = -1;
        for (int i = 0; i < recommendations.size(); i++) {
            if (recommendations.get(i).getTitle().compareTo(title) == 0) {
                reviewIndex = i;
                break;
            }
        }
        if (reviewIndex == -1) {
            ui.println(INVALID_DELETE_RECO_TITLE);
        } else {
            recommendations.remove(reviewIndex);
            ui.println(title + DELETE_SUCCESS);
        }
    }

    public void convertRecommendation(String title) {
        String category;
        String rating;
        String description;
        if (title == null || title.isBlank()) {
            ui.println(MISSING_DELETE_TITLE);
            return;
        }
        int recommendationIndex = -1;
        for (int i = 0; i < recommendations.size(); i++) {
            if (recommendations.get(i).getTitle().compareTo(title) == 0) {
                recommendationIndex = i;
                break;
            }
        }
        if (recommendationIndex == -1) {
            ui.println(INVALID_DELETE_RECO_TITLE);
        } else {
            category = recommendations.get(recommendationIndex).getCategory();
            description = "Price range: " + recommendations.get(recommendationIndex).priceRange()
                    + "| Location: " + recommendations.get(recommendationIndex).getLocation()
                    + "| RecBy: " + recommendations.get(recommendationIndex).getRecommendedBy();
            Review r = new Review(title, category, 0, description);

            System.out.println("Done! How would you rate your experience out of 5 stars?");
            rating = ui.readCommand();

            try {
                if (Integer.parseInt(rating) <= 5 && Integer.parseInt(rating) >= 0) {
                    r.setRating(Integer.parseInt(rating));
                } else {
                    System.out.println("Invalid rating, failed to edit rating ");
                }
                System.out.println("Add in details of your experience? (y/n)");
                switch (ui.readCommand().toLowerCase()) {
                case "y":
                    System.out.println("Enter your new description of the review: ");
                    String newDescription = ui.readCommand();
                    r.setDescription(newDescription);
                    break;
                case "n":
                    break;
                default:
                    ui.println(INVALID_COMMAND);
                }
                reviewList.receiveConvert(r);
            } catch (NumberFormatException ne) {
                System.out.println("Invalid rating, failed to edit rating ");
            }

            recommendations.remove(recommendationIndex);
            ui.println(title + CONVERT_SUCCESS);
        }

    }
}