package seedu.fridgefriend.command;

import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;

import java.util.List;

/**
 * List the items in the fridge to the user. User may specify the
 * specific food category to be listed.
 */
public class ListCommand extends Command {

    private static final int EXTRA_INDEX = 1;
    private final FoodCategory foodCategory;
    private final String category;

    public ListCommand(String description) {
        this.category = description.toUpperCase();
        this.foodCategory = FoodCategory.convertStringToFoodCategory(category);
    }

    @Override
    public void execute(List<Food> fridge) {
        if (category.equals("")) {
            listEverythingInFridge(fridge);
        } else {
            listByCategory(fridge);
        }
    }

    private void listByCategory(List<Food> fridge) {
        try {
            checkIsValidCategory();
            System.out.println("These are the " + foodCategory + " in your fridge:");
            for (int i = 0; i < fridge.size(); i++) {
                matchCategory(i, fridge);
            }
            System.out.println();
        } catch (InvalidInputException invalidInputException) {
            System.out.println("Sorry my friend, please enter a valid food category.\n");
        }
    }

    private void listEverythingInFridge(List<Food> fridge) {
        System.out.println("Here are the items in your fridge:");
        for (int i = 0; i < fridge.size(); i++) {
            int indexShownToUser = i + EXTRA_INDEX;
            System.out.println("\t" + indexShownToUser +  ". "
                    + fridge.get(i).getFoodName() + " ["
                    + fridge.get(i).getCategory() + "]");
        }
        System.out.println();
    }

    private void checkIsValidCategory() throws InvalidInputException {
        if (!FoodCategory.contains(category)) {
            throw new InvalidInputException();
        }
    }

    private void matchCategory(int index, List<Food> fridge) {
        if (fridge.get(index).getCategory().equals(foodCategory)) {
            int indexShownToUser = index + EXTRA_INDEX;
            System.out.println("\t" + indexShownToUser +  ". "
                    + fridge.get(index).getFoodName());
        }
    }

}
