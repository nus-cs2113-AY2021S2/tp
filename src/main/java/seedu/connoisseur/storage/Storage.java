package seedu.connoisseur.storage;

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
    private static String filePath;
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
        filePath = System.getProperty("user.dir") + "/data/connoisseur.txt";
        this.ui = ui;
        logger.log(Level.INFO, filePath);
    }

    /**
     * Checks if textfile exists, else create new file.
     *
     * @return True if file exists or text file is created.
     */
    public boolean retrieveTextFile() {
        boolean hasTextFile = false;
        try {
            File data = new File(filePath);
            if (data.createNewFile()) {
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
    public ArrayList<String> loadData() {
        ArrayList<String> reviewList = new ArrayList<>();
        try {
            File data = new File(filePath);
            Scanner fileScanner = new Scanner(data);
            String reviewsToLoad;
            while (fileScanner.hasNextLine()) {
                reviewsToLoad = fileScanner.nextLine();
                reviewList.add(reviewsToLoad);
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            ui.printErrorMessage(e);
        }
        return reviewList;
    }

    /**
     * Updates and saves new reviews to connoisseur.txt.
     *
     * @param reviewList Reviews list to be updated.
     */
    public void saveData(ArrayList<Review> reviewList) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            for (Review review : reviewList) {
                String reviewToWrite = review.reviewToText() + "\n";
                fileWriter.append(reviewToWrite);
            }
            fileWriter.close();
        } catch (IOException e) {
            ui.printErrorMessage(e);
        }
    }
}