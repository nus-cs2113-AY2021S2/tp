package seedu.fridgefriend.food;

import java.util.ArrayList;

import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;


public class Fridge {

    private ArrayList<Food> fridge = new ArrayList<>();
    private String overflowMessage = "Sorry my friend, "
            + "You have exceeded the maximum quantity";

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

    //@@author kwokyto
    public void removeByIndex(int index) {
        fridge.remove(index);
    }

    //@@author Vinci-Hu
    private void editFoodQuantity(Food newFood, Food existingFood) throws InvalidQuantityException {
        long deltaQuantity = newFood.getQuantity();
        long oriQuantity = existingFood.getQuantity();
        long newQuantity = deltaQuantity + oriQuantity;
        if (newQuantity >= Integer.MAX_VALUE) {
            throw new InvalidQuantityException(overflowMessage);
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
                throw new InvalidQuantityException(overflowMessage);
            }
        }
        return (int)totalQuantity;
    }

    private boolean isOverFlow(long totalQuantity) {
        if (totalQuantity >= Integer. MAX_VALUE) {
            return true;
        }
        return false;
    }
}
