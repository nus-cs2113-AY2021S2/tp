package seedu.fridgefriend.food;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.utilities.LoggingHandler;

/**
 * Represents a portion of a specific food that is stored in the smart fridge.
 * When calling constructor, category, foodName, expiryString, storageLocation
 * and quantity are NECESSARY fields.
 */
public abstract class Food {
    protected FoodCategory category;
    protected String foodName;
    protected ExpiryDate expiryDate;
    protected FoodStorageLocation storageLocation;
    protected Quantity quantity;

    public Food(String foodName, FoodCategory category, String expiryString,
                FoodStorageLocation storageLocation, Quantity quantity)
            throws InvalidDateException, InvalidQuantityException {
        LoggingHandler.logInfo("Food object initiated. food name: " + foodName);
        this.setCategory(category);
        this.setFoodName(foodName);
        this.setExpiryDate(expiryString);
        this.setStorageLocation(storageLocation);
        this.setQuantity(quantity);
    }

    @Override
    public String toString() {
        String format;
        if (getQuantity() instanceof Weight) {
            format = "Food name: %1$s, category: %2$s, expiry: %3$s, stored in: %4$s, weight: %5$s";
        } else {
            format = "Food name: %1$s, category: %2$s, expiry: %3$s, stored in: %4$s, quantity: %5$s";
        }
        return String.format(
                format,
                getFoodName(),
                getCategory().name(), 
                getExpiryDate().toString(), 
                getStorageLocation().name(),
                getQuantity().toString());
    }

    public FoodCategory getCategory() {
        return category;
    }

    public void setCategory(FoodCategory category) {
        this.category = category;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryString) throws InvalidDateException {
        ExpiryDate expiryDate = new ExpiryDate(expiryString);
        this.expiryDate = expiryDate;
        LoggingHandler.logInfo("Expiry date has been changed to "
                + expiryDate + " in food object " + foodName);
    }

    public FoodStorageLocation getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(FoodStorageLocation storageLocation) {
        this.storageLocation = storageLocation;
        LoggingHandler.logInfo("Storage location has been changed to "
                + storageLocation + " in food object " + foodName);
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }


}
