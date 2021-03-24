package parser;

import command.AddReviewCommand;
import command.DisplayMenusCommand;
import command.ExitCommand;
import command.ResetIndexesCommand;
import command.ReadReviewsCommand;
import command.Command;
import command.AddStoreCommand;
import command.DisplayStoresCommand;
import exceptions.DukeExceptions;
import reviews.Review;
import stores.Store;
import ui.Ui;


public class Parser {

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
        if (line.equals("list")) {
            newCommand = new ResetIndexesCommand();
        } else if (line.equals("menu")) {
            newCommand = new DisplayMenusCommand(store);
        } else if (line.equals("add")) {
            Review review = getReviewDetails();
            newCommand = new AddReviewCommand(store, review);
        } else if (line.startsWith("exit")) {
            newCommand = new ExitCommand();
        } else if (line.equals("reviews")) {
            newCommand = new ReadReviewsCommand(store);
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }

    public Review getReviewDetails() throws DukeExceptions {
        String description;
        double rating;
        try {
            Ui.enterReview();
            description = Ui.readCommand();
            Ui.enterRating();
            rating = Double.parseDouble(Ui.readCommand());
        } catch (NumberFormatException e) {
            throw new DukeExceptions("Review not added. Please input your review in proper format!");
        }
        return new Review(description, rating);
    }

    //parse admin commands only
    public Command parseAdminCommand(String line, int maxStores) throws DukeExceptions {
        Command newCommand;

        if (line.equals("1")) {
            newCommand = new AddStoreCommand();
        } else if (line.startsWith("list")) {
            newCommand = new DisplayStoresCommand();
        } else if (line.startsWith("exit")) {
            newCommand = new ExitCommand();
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }
}
