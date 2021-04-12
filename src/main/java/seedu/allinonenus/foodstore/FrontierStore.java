package seedu.allinonenus.foodstore;

public class FrontierStore extends FoodStore {

    public FrontierStore(String storeName, String storeDescription) {
        super(storeName, storeDescription);
    }

    @Override
    public String toString() {
        if (isHalal()) {
            return "Location: Frontier [Halal] " + getStoreName() + ": " + getStoreDescription();
        } else {
            return "Location: Frontier [Non-Halal] " + getStoreName() + ": " + getStoreDescription();
        }
    }

}
