package seedu.duke.foods;

/**
 * Represents a portion of a specific food that is stored in the smart fridge.
 * When calling constructor, FoodCategory and foodName are NECESSARY fields.
 * The date fields are represented by strings for now, they are OPTIONAL as well as storage location.
 * For Jingjie: for now you can use the first constructor.
 * todo: If needed, make the class abstract and add children classes(only when necessary unique methods are needed).
 */
public class Food {
    protected FoodCategory category;
    protected String foodName;
    protected String storageDate;
    protected String expiryDate;
    protected FoodStorageLocation storageLocation;

    public Food(FoodCategory category, String foodName) {
        this.category = category;
        this.foodName = foodName;
    }

    public Food(FoodCategory category, String foodName,
                String storageDate, String expiryDate, FoodStorageLocation storageLocation) {
        this.category = category;
        this.foodName = foodName;
        this.storageDate = storageDate;
        this.expiryDate = expiryDate;
        this.storageLocation = storageLocation;
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

    public String getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(String storageDate) {
        this.storageDate = storageDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public FoodStorageLocation getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(FoodStorageLocation storageLocation) {
        this.storageLocation = storageLocation;
    }
}
