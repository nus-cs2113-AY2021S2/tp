package seedu.fridgefriend.food;

import java.util.ArrayList;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;


public class Fridge {


    private ArrayList<Food> fridge = new ArrayList<>();

    /**
     * Call the UniqueFoodnameChecker methods before adding.
     * Checks if foodname already exists;
     * checks if its quantity can be added to existing food item.
     * If foodname exists but storage or expiry information are not identical,
     * will throw an exception to ask user to use a different foodname.
     * @param food food object to add obtained from parser.
     * @throws RepetitiveFoodIdentifierException as name suggests.
     */
    public void add(Food food) throws RepetitiveFoodIdentifierException {
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

    public int getSize() {
        return fridge.size();
    }

    public Food getFood(int i) {
        return fridge.get(i);
    }

    public void removeByIndex(int index) {
        fridge.remove(index);
    }

    private void editFoodQuantity(Food newFood, Food existingFood) {
        int deltaQuantity = newFood.getQuantity();
        int oriQuantity = existingFood.getQuantity();
        int newQuantity = deltaQuantity + oriQuantity;
        newFood.setQuantity(newQuantity);
        existingFood.setQuantity(newQuantity);
    }

    public ArrayList<Food> getFridge() {
        return fridge;
    }

    public void clearFridge() {
        fridge.clear();
    }
    
    /**
     * Returns a boolean indicated if the food in a category is running out.
     * 
     * @param foodCategory category to check
     * @return true if food in that category is running out, false otherwise
     */
    public boolean isRunningOut(FoodCategory foodCategory) {
        int totalQuantity = getTotalQuantity(foodCategory);
        return totalQuantity < FoodCategory.getMinimumQuantity(foodCategory);
    }

    public int getTotalQuantity(FoodCategory foodCategory) {
        int totalQuantity = 0;
        for (Food food : this.fridge) {
            if (food.getCategory() == foodCategory) {
                totalQuantity += food.getQuantity();
            }
        }
        return totalQuantity;
    }
}
