package seedu.connoisseur.commands;

import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.exceptions.EmptyInputException;
import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.storage.ConnoisseurData;
import seedu.connoisseur.ui.Ui;

import java.util.ArrayList;

import static seedu.connoisseur.messages.Messages.PRICE_PROMPT;
import static seedu.connoisseur.messages.Messages.LOCATION_PROMPT;
import static seedu.connoisseur.messages.Messages.RECOBY_PROMPT;
import static seedu.connoisseur.messages.Messages.RECO_TITLE_PROMPT;
import static seedu.connoisseur.messages.Messages.CATEGORY_PROMPT;
import static seedu.connoisseur.messages.Messages.ADD_SUCCESS;

/**
 * Class with methods for different commands in recommendation mode.
 */
public class RecommendationList {
    private final Ui ui;
    public ArrayList<Recommendation> recommendations = new ArrayList<>();

    public RecommendationList(ConnoisseurData connoisseurData, Ui ui) {
        this.ui = ui;
        this.recommendations = connoisseurData.getRecommendations();
    }

    public RecommendationList(Ui ui) {
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
            ui.print("| " + currentRecommendation.dollarRange());
            ui.printWhiteSpace(currentRecommendation.dollarRange().length());
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
            ui.print(currentRecommendation.dollarRange());
            ui.printWhiteSpace(currentRecommendation.dollarRange().length());
            ui.println(currentRecommendation.getRecommendedBy());
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds a recommendation.
     */
    public void addRecommendation() {
        try {
            addRecommendationDetails();
        } catch (DuplicateException de) {
            ui.printNoUniqueTitleMessage();
        } catch (EmptyInputException ee) {
            ui.printEmptyInputMessage();
        }
    }

    /**
     * Prompts for details of recommendation.
     */
    public void addRecommendationDetails() throws DuplicateException, EmptyInputException {

        ui.println(RECO_TITLE_PROMPT);
        String title = ui.readCommand();
        boolean isDuplicate;
        isDuplicate = checkAndPrintDuplicateRecommendation(title);
        if (isDuplicate) {
            throw new DuplicateException();
        }
        if (title.isBlank()) {
            throw new EmptyInputException();
        }
        ui.println(CATEGORY_PROMPT);
        String category = ui.readCommand().toLowerCase();
        if (category.isBlank()) {
            throw new EmptyInputException();
        }
        ui.println(PRICE_PROMPT);
        try {
            String priceRange = ui.readCommand();
            int priceLow;
            int priceHigh;
            int priceFirst = Integer.parseInt(priceRange.split("-", 2)[0].trim());
            int priceSecond = Integer.parseInt(priceRange.split("-", 2)[1].trim());
            if (priceFirst > priceSecond) {
                priceLow = priceSecond;
                priceHigh = priceFirst;
            } else {
                priceLow = priceFirst;
                priceHigh = priceSecond;
            }
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
}