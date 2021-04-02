package parser;

import canteens.Canteen;
import command.AddCanteenCommand;
import command.AddMenu;
import command.AddReviewCommand;
import command.AddStoreCommand;
import command.Command;
import command.DeleteCanteenCommand;
import command.DeleteMenu;
import command.DeleteReviewCommand;
import command.DeleteStoreCommand;
import command.DisplayCanteensCommand;
import command.DisplayMenusCommand;
import command.ExitCommand;
import command.HelpCommand;
import command.HomeCommand;
import command.ReadReviewsCommand;
import command.ResetStoreCommand;
import exceptions.DukeExceptions;
import nusfoodreviews.NusFoodReviews;
import reviews.Review;
import stores.Store;
import menus.Menu;
import ui.Ui;

import java.util.ArrayList;

import static stores.Store.averageRating;


public class Parser {

    private NusFoodReviews nusFoodReviews;
    private Ui ui;

    public Parser(NusFoodReviews nusFoodReviews, Ui ui) {
        this.nusFoodReviews = nusFoodReviews;
        this.ui = ui;
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

    public Command parse(String line, Store store, Canteen canteen) throws DukeExceptions {
        Command newCommand;
        if (line.equals("home")) {
            newCommand = new HomeCommand(nusFoodReviews);
        } else if (line.equals("list")) {
            newCommand = new ResetStoreCommand(nusFoodReviews);
        } else if (line.equals("menu")) {
            newCommand = new DisplayMenusCommand(store);
        } else if (line.equals("add")) { //add review
            newCommand = new AddReviewCommand(store,canteen);
        } else if (line.equals("exit")) {
            newCommand = new ExitCommand();
        } else if (line.equals("reviews")) {
            newCommand = new ReadReviewsCommand(store);
        } else if (line.equals("help")) {
            newCommand = new HelpCommand();
        } else {
            throw new DukeExceptions("Please enter a valid command!");
        }
        return newCommand;
    }

    //parse admin commands only
    public Command parseAdminCommand(String line) throws DukeExceptions {
        Command newCommand;
        int currentCanteenIndex;
        int currentStoreIndex;

        ArrayList<Canteen> canteens = nusFoodReviews.getCanteens();
        ArrayList<Store> stores;
        ArrayList<Review> reviews;
        ArrayList<Menu> menus = null;

        switch (line) {
        case "1":
            newCommand = new DisplayCanteensCommand();
            break;
        case "2":
            ui.showAddCanteen();
            String canteenName = ui.readCommand();
            newCommand = new AddCanteenCommand(canteenName);
            break;
        case "3":
            nusFoodReviews.setCanteenIndex();
            currentCanteenIndex = nusFoodReviews.getCanteenIndex();
            ui.showDisplayStores(canteens.get(currentCanteenIndex));
            ui.showAddStore();
            String storeName = ui.readCommand();
            newCommand = new AddStoreCommand(currentCanteenIndex, storeName);
            break;
        case "4":
            nusFoodReviews.setCanteenIndex(); //show UI to get canteen
            currentCanteenIndex = nusFoodReviews.getCanteenIndex(); //get canteen index
            ui.showDisplayStores(canteens.get(currentCanteenIndex)); //display stores
            ui.chooseStore();
            currentStoreIndex = Integer.parseInt(ui.readCommand()) - 1;
            newCommand = new AddMenu(currentCanteenIndex,currentStoreIndex,
                    canteens.get(currentCanteenIndex));
            break;
        case "5":
            ui.showDisplaySelectCanteens(canteens, "delete");
            int numCanteens = canteens.size();
            int canteenIndex = parseInt(ui.readCommand(), Math.min(1, numCanteens), numCanteens) - 1;
            newCommand = new DeleteCanteenCommand(canteenIndex);
            break;
        case "6":
            nusFoodReviews.setCanteenIndex();
            currentCanteenIndex = nusFoodReviews.getCanteenIndex();
            ui.showDisplaySelectStores(canteens.get(currentCanteenIndex));
            int storeIndex = parseInt(ui.readCommand(), 2,
                    canteens.get(currentCanteenIndex).getNumStores()) - 1;
            newCommand = new DeleteStoreCommand(currentCanteenIndex, storeIndex);
            break;
        case "7":
            nusFoodReviews.setCanteenIndex();
            currentCanteenIndex = nusFoodReviews.getCanteenIndex();
            nusFoodReviews.setStoreIndex();
            currentStoreIndex = nusFoodReviews.getStoreIndex();
            stores = canteens.get(currentCanteenIndex).getStores();
            reviews = canteens.get(currentCanteenIndex).getStore(currentStoreIndex).getReviews();
            averageRating = stores.get(currentStoreIndex).getAverageRating();
            ui.showReviews(stores.get(currentStoreIndex).getStoreName(),reviews,averageRating);
            ui.showDeleteReview();
            int reviewNumber = parseInt(ui.readCommand(),1,
                    canteens.get(currentCanteenIndex).getStore(currentStoreIndex).getRatingCount()) - 1;
            newCommand = new DeleteReviewCommand(currentCanteenIndex, currentStoreIndex, reviewNumber);
            break;
        case "8":
            nusFoodReviews.setCanteenIndex(); //show UI to get canteen
            currentCanteenIndex = nusFoodReviews.getCanteenIndex(); //get canteen index
            ui.showDisplayStores(canteens.get(currentCanteenIndex)); //display stores
            ui.chooseStore();
            currentStoreIndex = Integer.parseInt(ui.readCommand()) - 1; //get store index
            menus = canteens.get(currentCanteenIndex).getStore(currentStoreIndex).getMenus(); //get menus
            ui.showDisplayMenu(canteens.get(currentCanteenIndex).getStore(currentStoreIndex).getStoreName(),
                    menus); //displaymenu to delete
            ui.chooseMenu();
            int menuNumber = parseInt(ui.readCommand(),1,
                    canteens.get(currentCanteenIndex).getStore(currentStoreIndex).getMenuCount()) - 1;
            newCommand = new DeleteMenu(currentCanteenIndex, currentStoreIndex, menuNumber);
            break;
        case "9":
            newCommand = new ExitCommand();
            break;
        default:
            throw new DukeExceptions("Please enter a valid index!");
        }
        assert true;
        return newCommand;
    }
}
