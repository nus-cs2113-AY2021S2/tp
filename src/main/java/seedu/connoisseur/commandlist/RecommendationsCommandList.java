package seedu.connoisseur.commandlist;

import seedu.connoisseur.exceptions.DuplicateException;
import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.storage.ConnoisseurData;
import seedu.connoisseur.storage.Storage;
import seedu.connoisseur.ui.Ui;

import java.util.ArrayList;

import static seedu.connoisseur.messages.Messages.CATEGORY_PROMPT;
import static seedu.connoisseur.messages.Messages.PRICE_PROMPT;
import static seedu.connoisseur.messages.Messages.ADD_SUCCESS;
import static seedu.connoisseur.messages.Messages.RECOBY_PROMPT;
import static seedu.connoisseur.messages.Messages.MISSING_RECO_TITLE;
import static seedu.connoisseur.messages.Messages.LOCATION_PROMPT;

/**
 * Class with methods for different commands in recommendation mode.
 */
public class RecommendationsCommandList {
    private final Ui ui;
    public ArrayList<Recommendation> recommendationList = new ArrayList<>();

    public RecommendationsCommandList(ConnoisseurData connoisseurData, Ui ui, Storage storage) {
        this.ui = ui;
        this.recommendationList = connoisseurData.getRecoList();
    }

    public RecommendationsCommandList(Ui ui, Storage storage) {
        this.ui = ui;
    }

    /**
     * List reviews according to different types of input.
     */
    public void listRecommendations(ArrayList<Recommendation> recommendationList) {
        if (recommendationList.size() == 0) {
            ui.printEmptyRecommendationListMessage();
        } else {
            printRecommendation(recommendationList);
        }
    }

    /**
     * Prints the sorted recommendation.
     */
    public void printRecommendation(ArrayList<Recommendation> recommendationList) {
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
        for (int i = 0; i < recommendationList.size(); i++) {
            if ((recommendationList.get(i).getTitle().toLowerCase()).compareTo(title.toLowerCase()) == 0) {
                recIndex = i;
            }
        }
        if (recIndex != -1) {
            System.out.println("There is a recommendation in your list with the same title: ");
            Recommendation currentRecommendation = recommendationList.get(recIndex);
            ui.print((recommendationList.indexOf(currentRecommendation) + 1) + ". ");
            if (recommendationList.indexOf(currentRecommendation) < 9) {
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
            recommendationList.add(r);
            ui.println(title + ADD_SUCCESS);
        } catch (NumberFormatException e) {
            ui.printInvalidRatingMessage();
        }
    }
}