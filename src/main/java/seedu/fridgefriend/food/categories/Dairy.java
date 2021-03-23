package seedu.fridgefriend.food.categories;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Quantity;

public class Dairy extends Food {

    public Dairy(String foodName, FoodCategory category, String expiryString,
                 FoodStorageLocation storageLocation, Quantity quantity)
                 throws InvalidDateException, InvalidQuantityException {
        super(foodName, category, expiryString, storageLocation, quantity);
    }
}
