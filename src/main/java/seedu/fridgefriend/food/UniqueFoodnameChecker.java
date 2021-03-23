package seedu.fridgefriend.food;

import java.util.ArrayList;

public class UniqueFoodnameChecker {
    private ArrayList<Food> fridge = new ArrayList<>();
    private Food foodToCheck;
    private Food existingFood = null;

    public Food getExistingFood() {
        return existingFood;
    }

    public UniqueFoodnameChecker(ArrayList<Food> currentFridge, Food foodToAdd) {
        fridge = currentFridge;
        foodToCheck = foodToAdd;
    }

    public boolean isFoodnameUnique() {
        String nameToCheck = foodToCheck.getFoodName();
        for (Food food : fridge) {
            if (nameToCheck.equals(food.getFoodName())) {
                existingFood = food;
                return false;
            }
        }
        return true;
    }

    public boolean isParamIdentical() {
        boolean isLocIdentical = foodToCheck.getStorageLocation()
                .equals(existingFood.getStorageLocation());
        boolean isCatIdentical = foodToCheck.getCategory()
                .equals(existingFood.getCategory());
        boolean isExpIdentical = foodToCheck.getExpiryDate().toString()
                .equals(existingFood.getExpiryDate().toString());
        return isLocIdentical && isCatIdentical && isExpIdentical;
    }
}
