package seedu.connoisseur.storage;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

import static seedu.connoisseur.messages.Messages.CURRENT_DIRECTORY;
import static seedu.connoisseur.messages.Messages.FILE_SUCCESS;
import static seedu.connoisseur.messages.Messages.FILE_ALREADY_EXISTS;
import static seedu.connoisseur.messages.Messages.FOLDER_SUCCESS;
import static seedu.connoisseur.messages.Messages.FOLDER_ALREADY_EXISTS;

/**
 * Loads reviews from connoisseur.txt or
 * creates and saves new reviews to connoisseur's.txt
 */
public class Storage {
    private static Logger logger = Logger.getLogger("ConnoisseurLogger");
    private static String connoisseurFilePath;
    private static String recommendationFilePath;
    private Ui ui;

    /**
     * Constructor for Storage class. 
     */
    public Storage(Ui ui) {
        logger.setLevel(Level.OFF);
        logger.log(Level.INFO, CURRENT_DIRECTORY);
        String folderPath = System.getProperty("user.dir") + "/data";
        File folder = new File(folderPath);
        boolean folderIsCreated = folder.mkdir();
        if (folderIsCreated) {
            logger.log(Level.INFO, FOLDER_SUCCESS);
        } else {
            logger.log(Level.WARNING, FOLDER_ALREADY_EXISTS);
        }
        connoisseurFilePath = System.getProperty("user.dir") + "/data/connoisseur.txt";
        recommendationFilePath = System.getProperty("user.dir") + "/data/recommendation.txt";
        this.ui = ui;
        logger.log(Level.INFO, connoisseurFilePath);
        logger.log(Level.INFO, recommendationFilePath);
    }

    /**
     * Checks if ConnoisseurTextFile exists, else create new file.
     *
     * @return True if file exists or text file is created.
     */
    public boolean retrieveConnoisseurTextFile() {
        boolean hasTextFile = false;
        try {
            File connoisseurData = new File(connoisseurFilePath);
            if (connoisseurData.createNewFile()) {
                logger.log(Level.INFO, FILE_SUCCESS);
            } else {
                hasTextFile = true;
                logger.log(Level.WARNING, FILE_ALREADY_EXISTS);
            }
        } catch (IOException e) { //creating or retrieving data has errors
            ui.printErrorMessage(e);
        }
        return hasTextFile;
    }

    /**
     * Checks if RecommendationTextFile exists, else create new file.
     *
     * @return True if file exists or text file is created.
     */
    public boolean retrieveRecommendationTextFile() {
        boolean hasTextFile = false;
        try {
            File recommendationData = new File(recommendationFilePath);
            if (recommendationData.createNewFile()) {
                logger.log(Level.INFO, FILE_SUCCESS);
            } else {
                hasTextFile = true;
                logger.log(Level.WARNING, FILE_ALREADY_EXISTS);
            }
        } catch (IOException e) { //creating or retrieving data has errors
            ui.printErrorMessage(e);
        }
        return hasTextFile;
    }

    /**
     * Loads information from data.txt into connoisseur's list without change.
     *
     * @return Loaded review into connoisseur's list unformatted.
     */
    public ArrayList<String> loadConnoisseurData() {
        ArrayList<String> reviewList = new ArrayList<>();
        try {
            File connoisseurData = new File(connoisseurFilePath);
            Scanner connoisseurFileScanner = new Scanner(connoisseurData);
            String reviewsToLoad;
            while (connoisseurFileScanner.hasNextLine()) {
                reviewsToLoad = connoisseurFileScanner.nextLine();
                reviewList.add(reviewsToLoad);
            }
            connoisseurFileScanner.close();
        } catch (FileNotFoundException e) {
            ui.printErrorMessage(e);
        }
        return reviewList;
    }
    /**
     * Loads information from data.txt into recommendationsList without change.
     *
     * @return Loaded recommendations into crecommendationsList unformatted.
     */
    public ArrayList<String> loadRecommendationData() {
        ArrayList<String> recommendationsList = new ArrayList<>();
        try {
            File recommendationData = new File(recommendationFilePath);
            Scanner recommendationFileScanner = new Scanner(recommendationData);
            String recommendationsToLoad;

            while(recommendationFileScanner.hasNextLine()){
                recommendationsToLoad = recommendationFileScanner.nextLine();
                recommendationsList.add(recommendationsToLoad);
            }
            recommendationFileScanner.close();
        } catch (FileNotFoundException e) {
            ui.printErrorMessage(e);
        }
        return recommendationsList;
    }

    /**
     * Updates and saves new reviews to connoisseur.txt.
     *
     * @param reviewList Reviews list to be updated.
     */
    public void saveConnoisseurData(ArrayList<Review> reviewList, String sortMethod) {
        try {
            FileWriter connoisseurFileWriter = new FileWriter(connoisseurFilePath);
            connoisseurFileWriter.append("SortMethod: ").append(sortMethod).append("\n");
            for (Review review : reviewList) {
                String reviewToWrite = review.reviewToText() + "\n";
                connoisseurFileWriter.append(reviewToWrite);
            }
            connoisseurFileWriter.close();
        } catch (IOException e) {
            ui.printErrorMessage(e);
        }
    }

    /**
     * Updates and saves new Recommendation to recommendation.txt.
     *
     * @param recommendationList Recommendation list to be updated.
     */
    public void saveRecommendationData(ArrayList<Recommendation> recommendationList) {
        try {
            FileWriter recommendationFileWriter = new FileWriter(recommendationFilePath);
            for (Recommendation recommendation : recommendationList) {
                String recommendationToWrite = recommendation.recommendationToText() + "\n";
                recommendationFileWriter.append(recommendationToWrite);
            }
            recommendationFileWriter.close();
        } catch (IOException e) {
            ui.printErrorMessage(e);
        }
    }
}