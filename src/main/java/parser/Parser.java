package parser;


import command.AddCanteenCommand;
import command.AddReviewCommand;
import command.AddStoreCommand;
import command.Command;
import command.DeleteCanteenCommand;
import command.DeleteReviewCommand;
import command.DeleteStoreCommand;
import command.DisplayCanteensCommand;
import command.DisplayMenusCommand;
import command.ExitCommand;
import command.HomeCommand;
import command.ReadReviewsCommand;
import command.ResetStoreCommand;
import exceptions.DukeExceptions;
import nusfoodreviews.NusFoodReviews;
import reviews.Review;
import stores.Store;
import ui.Ui;

import java.util.ArrayList;

import static stores.Store.averageRating;


public class Parser {

    private NusFoodReviews nusFoodReviews;

    public Parser(NusFoodReviews nusFoodReviews) {

        this.nusFoodReviews = nusFoodReviews;
    }

    public int parseInt(String line, int inclusiveMin, int inclusiveMax) throws DukeExceptions {
        int parsedInt;

        try {
            parsedInt = Integer.parseInt(line);
            if (parsedInt < inclusiveMin || parsedInt > inclusiveMax) {
                String exceptionMessage;
                if (inclusiveMin == inclusiveMax) {
                    exceptionMessage = "Please enter a valid index!";
                } else {
                    exceptionMessage = "Please enter a valid index in the range of " + inclusiveMin
                            + " and " + inclusiveMax + "!";
                }
                throw new DukeExceptions(exceptionMessage);
            }
        } catch (NumberFormatException e) {
            throw new DukeExceptions("Please enter a valid integer index!");
        }
        return parsedInt;
    }

    public Command parse(String line, Store store, int maxStores) throws DukeExceptions {
        Command newCommand;
        if (line.equals("home")) {
            newCommand = new HomeCommand();
        } else if (line.equals("list")) {
            newCommand = new ResetStoreCommand();
        } else if (line.equals("menu")) {
            newCommand = new DisplayMenusCommand(store);
        } else if (line.equals("add")) {
            newCommand = new AddReviewCommand(store);
        } else if (line.startsWith("exit")) {
            newCommand = new ExitCommand();
        } else if (line.equals("reviews")) {
            newCommand = new ReadReviewsCommand(store);
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }

    //parse admin commands only
    public Command parseAdminCommand(String line) throws DukeExceptions {
        Command newCommand;

        switch (line) {
        case "1":
            newCommand = new DisplayCanteensCommand();
            break;
        case "2":
            Ui.showAddCanteen();
            String canteenName = Ui.readCommand();
            newCommand = new AddCanteenCommand(canteenName);
            break;
        case "3":
            nusFoodReviews.setCanteenIndex();
            int currentCanteenIndex = nusFoodReviews.getCanteenIndex();
            Ui.showDisplayStores(nusFoodReviews.getCanteens().get(currentCanteenIndex));
            Ui.showAddStore();
            String storeName = Ui.readCommand();
            newCommand = new AddStoreCommand(currentCanteenIndex, storeName);
            break;
        case "4":
            Ui.showDisplaySelectCanteens(nusFoodReviews.getCanteens());
            int canteenIndex = parseInt(Ui.readCommand(), 1, nusFoodReviews.getCanteens().size()) - 1;
            newCommand = new DeleteCanteenCommand(canteenIndex);
            break;
        case "5":
            nusFoodReviews.setCanteenIndex();
            currentCanteenIndex = nusFoodReviews.getCanteenIndex();
            Ui.showDisplaySelectStores(nusFoodReviews.getCanteens().get(currentCanteenIndex));
            int storeIndex = parseInt(Ui.readCommand(), 2,
                    nusFoodReviews.getCanteens().get(currentCanteenIndex).getNumStores()) - 1;
            newCommand = new DeleteStoreCommand(currentCanteenIndex, storeIndex);
            break;
        case "6":
            nusFoodReviews.setCanteenIndex();
            currentCanteenIndex = nusFoodReviews.getCanteenIndex();
            nusFoodReviews.setStoreIndex();
            int currentStoreIndex = nusFoodReviews.getStoreIndex();
            ArrayList<Store> stores = nusFoodReviews.getCanteens()
                    .get(currentCanteenIndex).getStores();
            ArrayList<Review> reviews = nusFoodReviews.getCanteens()
                    .get(currentCanteenIndex).getStore(currentStoreIndex).getReviews();
            averageRating = stores.get(currentStoreIndex).getAverageRating();
            Ui.showReviews(stores.get(currentStoreIndex).getStoreName(),reviews,averageRating);
            Ui.showDeleteReview();
            int reviewNumber = parseInt(Ui.readCommand(),1,
                    nusFoodReviews.getCanteens().get(currentCanteenIndex).getStore(currentStoreIndex).getRatingCount());
            newCommand = new DeleteReviewCommand(currentCanteenIndex,currentStoreIndex, reviewNumber);
            break;
        case "7":
            newCommand = new ExitCommand();
            break;
        default:
            throw new DukeExceptions("Please enter a valid index!");
        }
        assert true;
        return newCommand;
    }
}
