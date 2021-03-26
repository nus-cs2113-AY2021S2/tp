package seedu.fridgefriend.food;

import java.time.LocalDate;

import seedu.fridgefriend.exception.InvalidDateException;
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
    protected int quantity;

    public Food(String foodName, FoodCategory category, String expiryString,
                FoodStorageLocation storageLocation, int quantity)
                throws InvalidDateException {
        LoggingHandler.logInfo("Food object initiated. food name: " + foodName);
        this.setCategory(category);
        this.setFoodName(foodName);
        this.setExpiryDate(expiryString);
        this.setStorageLocation(storageLocation);
        this.setQuantity(quantity);
    }

    @Override
    public String toString() {
        String format = "Food name: %1$s, category: %2$s, expiry: %3$s, stored in: %4$s, quantity: %5$s";;

        return String.format(
                format,
                getFoodName(),
                getCategory().name(), 
                getExpiryDate().toString(), 
                getStorageLocation().name(),
                getQuantity());
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
        LoggingHandler
                .logInfo("Storage location has been changed to " + storageLocation + " in food object " + foodName);
    }

    public boolean isExpiring() {
        LocalDate cutOff = LocalDate.now().plusDays(7);
        LocalDate expiry = this.getExpiryDate().getExpiry();
        return expiry.isBefore(cutOff);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
