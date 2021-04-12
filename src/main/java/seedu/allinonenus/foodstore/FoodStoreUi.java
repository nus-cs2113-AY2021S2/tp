package seedu.allinonenus.foodstore;

import java.util.ArrayList;

public class FoodStoreUi {

    private static final String FIND_ERROR_MESSAGE =
            "Sorry, We are unable to find any food stores that fit the description";
    private static final String WELCOME_MESSAGE = "Welcome to Food Recommendation Bot!\n";
    private static final String AVAILABLE_COMMANDS = "Here are the list of commands: \n"
            + "1. help - Displays the list of commands available\n"
            + "2. add [store name] d/[store description] - Adds a new food store\n"
            + "3. list - Displays out all the food stores\n"
            + "4. delete [store index] - Deletes the store with that index\n"
            + "5. recommend - Recommends a random food store\n"
            + "6. clear - Clears all the food stores in the list\n"
            + "7. find [keyword] - Displays all the food stores that contains the keyword\n"
            + "8. halal [store index] - Sets a food store to halal status if it is non-halal, and vice versa\n"
            + "9. bye - Exits the Food Recommendation bot and returns to the Main Menu";
    private static final String EXIT_MESSAGE = "Goodbye, hope to see you again!";
    private static final String RECOMMEND_MESSAGE = "I recommend this store for you to try!";
    private static final String CLEAR_MESSAGE = "All food stores have been cleared from the list.";
    private static final String REMOVE_STORE_MESSAGE = "This store has been removed:";
    private static final String LIST_MESSAGE = "Here is the list of food stores:";
    private static final String ADD_STORE_MESSAGE = "This food store has been added to the list:";
    private static final String FILE_NOT_FOUND_MESSAGE = "File not found. Creating a new file...";
    private static final String NEW_LOCATION_INPUT_MESSAGE = "Please choose a location";
    private static final String AVAILABLE_LOCATIONS = "The locations available for choice are: \n"
            + "1. Frontier Canteen(Located near Science)\n"
            + "2. The Deck (Located near FASS)\n"
            + "3. University Town\n"
            + "4. Techno Edge (Located near Engineering)";
    private static final String AVAILABLE_RECOMMEND_LOCATIONS = "The locations available for choice are: \n"
            + "1. Frontier Canteen(Located near Science)\n"
            + "2. The Deck (Located near FASS)\n"
            + "3. University Town\n"
            + "4. Techno Edge (Located near Engineering)\n"
            + "5. Everything";
    private static final String INVALID_LOCATION_INPUT_MESSAGE = "Invalid location, please try again.\n"
            + "Enter help to view available locations again.";
    private static final String UPDATE_STORE_MESSAGE = "I have updated the following food store:";
    private static final String DIVIDER = "____________________________________________________________";
    private static final String FIND_MESSAGE = "These are the food stores that contains the keyword: ";
    private static final String UNKNOWN_COMMAND_MESSAGE = "Sorry, I do not understand that command"
            + "Enter help to view available commands again";

    public void printExitMessage() {
        showToUser(DIVIDER, EXIT_MESSAGE, DIVIDER);
    }

    public void printAvailableCommands() {
        showToUser(DIVIDER, AVAILABLE_COMMANDS, DIVIDER);
    }

    public void printWelcomeMessage() {
        showToUser(DIVIDER, WELCOME_MESSAGE, DIVIDER);
    }

    public void addStore(FoodStore foodStore) {
        showToUser(DIVIDER, ADD_STORE_MESSAGE, foodStore.toString(), DIVIDER);
    }

    public void deleteStore(FoodStore foodStore) {
        showToUser(DIVIDER, REMOVE_STORE_MESSAGE, foodStore.toString(), DIVIDER);
    }

    public void clearList() {
        showToUser(DIVIDER, CLEAR_MESSAGE, DIVIDER);
    }

    public void printDivider() {
        showToUser(DIVIDER);
    }

    public void recommendStore(FoodStore foodStore) {
        showToUser(DIVIDER, RECOMMEND_MESSAGE);
        printStore(foodStore);
        showToUser(DIVIDER);
    }

    public void printList(ArrayList<FoodStore> foodStores) {
        showToUser(DIVIDER, LIST_MESSAGE);
        for (int i = 0; i < foodStores.size(); i++) {
            FoodStore foodStore = foodStores.get(i);
            Integer index = i + 1;
            showToUser(index + ". " + foodStore.toString());
        }
        showToUser(DIVIDER);
    }

    public void printUnknownCommand() {
        showToUser(DIVIDER, UNKNOWN_COMMAND_MESSAGE, DIVIDER);
    }

    public void printFileNotFound() {
        showToUser(DIVIDER, FILE_NOT_FOUND_MESSAGE, DIVIDER);
    }

    public void printFindError() {
        showToUser(DIVIDER, FIND_ERROR_MESSAGE, DIVIDER);
    }

    public void printStore(FoodStore foodStore) {
        showToUser(foodStore.toString());
    }

    public void showAvailableLocations() {
        showToUser(DIVIDER, NEW_LOCATION_INPUT_MESSAGE, AVAILABLE_LOCATIONS, DIVIDER);
    }

    public void showRecommendAvailableLocations() {
        showToUser(DIVIDER, NEW_LOCATION_INPUT_MESSAGE, AVAILABLE_RECOMMEND_LOCATIONS, DIVIDER);
    }

    public void printInvalidLocationInput() {
        showToUser(DIVIDER, INVALID_LOCATION_INPUT_MESSAGE, DIVIDER);
    }

    public void printUpdatedStore(FoodStore foodStore) {
        showToUser(DIVIDER, UPDATE_STORE_MESSAGE, foodStore.toString(), DIVIDER);
    }

    public void showFindMessage() {
        showToUser(DIVIDER, FIND_MESSAGE);
    }

    public void showToUser(String... message) {
        for (String m : message) {
            System.out.println(m);
        }
    }
}
