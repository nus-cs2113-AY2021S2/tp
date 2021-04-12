package seedu.allinonenus.foodstore;

public class FoodStoreParser {

    private static final String INVALID_ADD_MESSAGE = "Please enter the command in the correct format: "
            + "add [Store name] d/[Store description]";
    private static final String OUT_OF_BOUNDS_MESSAGE = "Sorry, the number you inputted is out of bounds."
            + "Please use the list command to check the store index.";
    private static final String INVALID_HALAL_MESSAGE = "Please enter the command in the correct format: "
            + "halal [Store index]";
    private static final String INVALID_FIND_MESSAGE = "Please enter the command in the correct format: "
            + "find [keyword]";
    private static final String INVALID_DELETE_MESSAGE = "Please enter the command in the correct format: "
            + "delete [Store index]";

    public FoodStore parseAddCommand(String input, int locationIndex) throws FoodExceptions {
        input = input.replace("add ", "");
        input = input.trim();
        boolean hasStoreName = !input.isEmpty();
        boolean hasDescriptionTag = input.contains("d/");
        boolean hasDescription;
        if (hasDescriptionTag) {
            String[] inputArguments = input.split("d/");
            hasDescription = inputArguments.length > 1;
        } else {
            hasDescription = false;
        }
        boolean validInput = hasDescription && hasStoreName;
        if (!validInput) {
            throw new FoodExceptions(INVALID_ADD_MESSAGE);
        } else {
            String[] inputArguments = input.split("d/");
            String storeName = inputArguments[0];
            String storeDescription = inputArguments[1];
            switch (locationIndex) {
            case 1:
                return new FrontierStore(storeName,storeDescription);
            case 2:
                return new DeckStore(storeName,storeDescription);
            case 3:
                return new UTownStore(storeName,storeDescription);
            case 4:
                return new TechnoStore(storeName,storeDescription);
            default:
                throw new FoodExceptions(INVALID_ADD_MESSAGE);
            }
        }
    }

    public int parseDeleteCommand(String input, int listSize) throws FoodExceptions {
        input = input.replace("delete ", "");
        input = input.trim();
        int index;
        try {
            index = Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            throw new FoodExceptions(INVALID_DELETE_MESSAGE);
        }
        boolean isEmpty = input.isEmpty();
        boolean validIndex = (index < listSize) && (index >= 0);
        boolean validInput = !isEmpty && validIndex;
        if (!validInput) {
            throw new FoodExceptions(OUT_OF_BOUNDS_MESSAGE);
        } else {
            return index;
        }
    }

    public int parseHalalCommand(String input, int listSize) throws FoodExceptions {
        input = input.replace("halal ", "");
        input = input.trim();
        int index;
        try {
            index = Integer.parseInt(input) - 1;
        } catch (NumberFormatException e) {
            throw new FoodExceptions(INVALID_HALAL_MESSAGE);
        }
        boolean isEmpty = input.isEmpty();
        boolean validIndex = (index < listSize) && (index >= 0);
        boolean validInput = !isEmpty && validIndex;
        if (!validInput) {
            throw new FoodExceptions(OUT_OF_BOUNDS_MESSAGE);
        } else {
            return index;
        }
    }

    public String parseFindCommand(String input) throws FoodExceptions {
        input = input.replace("find ", "");
        input = input.trim();
        boolean isEmpty = input.isEmpty();
        if (isEmpty) {
            throw new FoodExceptions(INVALID_FIND_MESSAGE);
        } else {
            return input;
        }
    }

}
