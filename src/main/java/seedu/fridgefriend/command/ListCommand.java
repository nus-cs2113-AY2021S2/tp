package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.utilities.Ui;

/**
 * Represents a command to list the items in the fridge to the user.
 * When calling constructor, description is a necessary field
 * to specify whether to list everything or list by category.
 */
public class ListCommand extends Command {

    private static final int EXTRA_INDEX = 1;
    private static final int START_INDEX_SHOWN_TO_USER = 1;
    private int counter;
    private final FoodCategory foodCategory;
    private final String category;

    public ListCommand(String categoryType) {
        this.category = categoryType.toUpperCase();
        this.foodCategory = FoodCategory.convertStringToFoodCategory(category);
        this.counter = START_INDEX_SHOWN_TO_USER;
    }

    @Override
    public void execute() throws InvalidInputException {
        if (category.equals("")) {
            listAll();
        } else {
            listByCategory();
        }
    }

    private void listByCategory() throws InvalidInputException {
        checkIsValidCategory();
        String message = getListByCategoryMessage();
        Ui.printMessage(message);
    }

    private void listAll() {
        Ui.printMessage(getListAllMessage());
    }

    /**
     * Returns the food that match the category that was specified.
     *
     * @return string of food that match the category in the fridge
     */
    public String getListByCategoryMessage() {
        StringBuilder message = new StringBuilder("These are the " + foodCategory + " in your fridge:");
        for (int i = 0; i < fridge.getSize(); i++) {
            message.append(getMatchCategoryFoodDescription(i));
        }

        assert message != null : "message string should not be null";
        return message.toString();
    }

    /**
     * Returns all the food in the fridge.
     *
     * @return string of the food names that are in the fridge
     */
    public String getListAllMessage() {
        StringBuilder message = new StringBuilder("Here are the items in your fridge:");
        for (int i = 0; i < fridge.getSize(); i++) {
            message.append(getFoodDescription(i));
        }
        return message.toString();
    }

    private String getFoodDescription(int index) {
        int indexShownToUser = index + EXTRA_INDEX;
        Food food = fridge.getFood(index);
        String foodDescription = 
                "\n\t" + indexShownToUser +  ". "
                + food.getFoodName() + " ["
                + food.getCategory() + "]";
        return foodDescription;
    }

    private void checkIsValidCategory() throws InvalidInputException {
        if (!FoodCategory.contains(category)) {
            String errorMessage = "Sorry my friend, please enter a valid food category.";
            throw new InvalidInputException(errorMessage);
        }
    }

    private String getMatchCategoryFoodDescription(int index) {
        String foodDescription = "";
        Food food = fridge.getFood(index);
        FoodCategory category = food.getCategory();
        if (category.equals(foodCategory)) {
            foodDescription = "\n\t" + counter + ". " + food.getFoodName();
            ++counter;
        }
        return foodDescription;
    }

}
