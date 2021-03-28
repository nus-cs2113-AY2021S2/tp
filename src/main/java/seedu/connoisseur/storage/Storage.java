package seedu.connoisseur.storage;

import seedu.connoisseur.recommendation.Recommendation;
import seedu.connoisseur.review.Review;
import seedu.connoisseur.ui.Ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.json.JSONObject;
import org.json.JSONArray;


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
    private static String dataFilePath;
    private Ui ui;

    /**
     * Constructor for Storage class.
     */
    public Storage(Ui ui) {
        this.ui = ui;
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
        dataFilePath = System.getProperty("user.dir") + "/data/connoisseur.json";
        logger.log(Level.INFO, dataFilePath);
    }

    /**
     * Checks if ConnoisseurTextFile exists, else create new file.
     *
     * @return True if file exists or text file is created.
     */
    public boolean retrieveDataFile() {
        boolean fileAlreadyExists = false;
        try {
            File connoisseurData = new File(dataFilePath);
            if (connoisseurData.createNewFile()) {
                logger.log(Level.INFO, FILE_SUCCESS);
            } else {
                fileAlreadyExists = true;
                logger.log(Level.WARNING, FILE_ALREADY_EXISTS);
            }
        } catch (IOException e) { //creating or retrieving data has errors
            ui.printErrorMessage(e);
        }
        return fileAlreadyExists;
    }

    public ConnoisseurData loadConnoisseurData() {
        ConnoisseurData connoisseurData;
        try {
            File dataFile = new File(dataFilePath);
            Scanner connoisseurFileScanner = new Scanner(dataFile);
            String reviewsToLoad;
            reviewsToLoad = connoisseurFileScanner.nextLine();
            JSONObject data = new JSONObject(reviewsToLoad);
            String sortMethod = data.getString("sortMethod");
            ArrayList<Review> reviewList = loadReviews(data.getJSONArray("reviews"));
            ArrayList<Recommendation> recommendationList = loadRecommendations(data.getJSONArray("recommendations"));
            connoisseurData = new ConnoisseurData(sortMethod, reviewList, recommendationList);
            connoisseurFileScanner.close();
        } catch (FileNotFoundException | NoSuchElementException e) {
            ui.printErrorMessage(e);
            connoisseurData = new ConnoisseurData("latest", new ArrayList<Review>(), new ArrayList<Recommendation>());
        }
        return connoisseurData;
    }

    public ArrayList<Review> loadReviews(JSONArray reviews) {
        ArrayList<Review> reviewList = new ArrayList<Review>();
        for (int i=0; i<reviews.length(); i++) {
            String title = reviews.getJSONObject(i).getString("title");
            String category = reviews.getJSONObject(i).getString("category");
            int rating = reviews.getJSONObject(i).getInt("rating");
            String description = reviews.getJSONObject(i).getString("description");
            String date = reviews.getJSONObject(i).getString("date");
            Review review = new Review(title, category, rating, description, date);
            reviewList.add(review);
        }
        return reviewList;
    }

    public ArrayList<Recommendation> loadRecommendations(JSONArray recommendations) {
        ArrayList<Recommendation> recommendationList = new ArrayList<Recommendation>();
        for (int i=0; i<recommendations.length(); i++) {
            String title = recommendations.getJSONObject(i).getString("title");
            String category = recommendations.getJSONObject(i).getString("category");
            int price = recommendations.getJSONObject(i).getInt("price");
            String referrer = recommendations.getJSONObject(i).getString("referrer");
            Recommendation reco = new Recommendation(title, category, price, referrer);
            recommendationList.add(reco);
        }
        return recommendationList;
    }

    public void saveConnoisseurData(ArrayList<Review> reviewList, ArrayList<Recommendation> recommendationList, String sortMethod) {
        try {
            FileWriter connoisseurFileWriter = new FileWriter(dataFilePath);
            JSONObject data = new JSONObject();
            JSONArray reviews = saveReviews(reviewList);
            JSONArray recommendations = saveRecommendations(recommendationList);
            data.put("sortMethod", sortMethod);
            data.put("reviews", reviews);
            data.put("recommendations", recommendations);
            connoisseurFileWriter.append(data.toString());
            connoisseurFileWriter.close();
        } catch (IOException e) {
            ui.printErrorMessage(e);
        }
    }

    public JSONArray saveReviews(ArrayList<Review> reviewList) {
        JSONArray reviews = new JSONArray();
        for (int i=0; i<reviewList.size(); i++) {
            Review review = reviewList.get(i);
            JSONObject reviewToWrite = new JSONObject();
            reviewToWrite.put("title", review.getTitle());
            reviewToWrite.put("category", review.getCategory());
            reviewToWrite.put("rating", review.getRating());
            reviewToWrite.put("description", review.getDescription());
            reviewToWrite.put("date", review.getDateTime());
            reviews.put(i, reviewToWrite);
        }
        return reviews;
    }

    public JSONArray saveRecommendations(ArrayList<Recommendation> recommendationList) {
        JSONArray recommendations = new JSONArray();
        for (int i=0; i<recommendationList.size(); i++) {
            Recommendation recommendation = recommendationList.get(i);
            JSONObject recommendationToWrite = new JSONObject();
            recommendationToWrite.put("title", recommendation.getTitle());
            recommendationToWrite.put("category", recommendation.getCategory());
            recommendationToWrite.put("price", recommendation.getPrice());
            recommendationToWrite.put("referrer", recommendation.getRecommendedBy());
            recommendations.put(i, recommendationToWrite);
        }
        return recommendations;
    }
}