package seedu.fridgefriend.food;

import java.util.ArrayList;

import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;


public class Fridge {

    private ArrayList<Food> fridge = new ArrayList<>();
    private String exceedAddMessage = "Sorry my friend, "
            + "the quantity you have entered "
            + "has exceed the maximum allowable quantity.";
    private String exceedTotalQuantityMessage = "Sorry my friend, "
            + "the total quantity of a category "
            + "has exceed the maximum quantity.\n"
            + "Please remove food with large quantity.";
    private static final int MAX_ALLOWABLE_QUANTITY = 1000000;
    private static final int MAX_ALLOWABLE_TOTAL_QUANTITY = 10000000;

    //@@author Vinci-Hu
    /**
     * Call the UniqueFoodnameChecker methods before adding.
     * Checks if foodname already exists;
     * checks if its quantity can be added to existing food item.
     * If foodname exists but storage or expiry information are not identical,
     * will throw an exception to ask user to use a different foodname.
     * @param food food object to add obtained from parser.
     * @throws RepetitiveFoodIdentifierException as name suggests.
     */
    public void add(Food food) throws RepetitiveFoodIdentifierException, InvalidQuantityException {
        UniqueFoodnameChecker checker = new UniqueFoodnameChecker(fridge, food);
        if (checker.isFoodnameUnique()) {
            fridge.add(food);
        } else {
            if (checker.isParamIdentical()) {
                Food existingFood = checker.getExistingFood();
                editFoodQuantity(food, existingFood);
            } else {
                throw new RepetitiveFoodIdentifierException();
            }
        }
    }

    //@@author kwokyto
    public int getSize() {
        return fridge.size();
    }

    //@@author kwokyto
    public Food getFood(int i) {
        return fridge.get(i);
    }

    //@@author Vinci-Hu
    private void editFoodQuantity(Food newFood, Food existingFood) throws InvalidQuantityException {
        long deltaQuantity = newFood.getQuantity();
        long originalQuantity = existingFood.getQuantity();
        long newQuantity = deltaQuantity + originalQuantity;
        if (newQuantity > MAX_ALLOWABLE_QUANTITY) {
            throw new InvalidQuantityException(exceedAddMessage);
        }
        newFood.setQuantity((int)newQuantity);
        existingFood.setQuantity((int)newQuantity);
    }

    public ArrayList<Food> getFridge() {
        return fridge;
    }

    public void clearFridge() {
        fridge.clear();
    }
  
    //@@author kwokyto
    /**
     * Returns a boolean indicated if the food in a category is running out.
     * 
     * @param foodCategory category to check
     * @return true if food in that category is running out, false otherwise
     */
    public boolean isRunningOut(FoodCategory foodCategory) throws InvalidQuantityException {
        int totalQuantity = getTotalQuantity(foodCategory);
        return totalQuantity < FoodCategory.getMinimumQuantity(foodCategory);
    }

    //@@author kwokyto
    public int getTotalQuantity(FoodCategory foodCategory) throws InvalidQuantityException {
        long totalQuantity = 0;
        for (Food food : this.fridge) {
            if (food.getCategory() == foodCategory) {
                totalQuantity += food.getQuantity();
            }
            if (isOverFlow(totalQuantity)) {
                throw new InvalidQuantityException(exceedTotalQuantityMessage);
            }
        }
        return (int)totalQuantity;
    }

    //@@author SimJJ96
    private boolean isOverFlow(long totalQuantity) {
        if (totalQuantity > MAX_ALLOWABLE_TOTAL_QUANTITY) {
            return true;
        }
        return false;
    }
}
