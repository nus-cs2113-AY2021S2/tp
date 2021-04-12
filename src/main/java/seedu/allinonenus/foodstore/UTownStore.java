package seedu.allinonenus.foodstore;

public class UTownStore extends FoodStore {

    public UTownStore(String storeName, String storeDescription) {
        super(storeName, storeDescription);
    }

    @Override
    public String toString() {
        if (isHalal()) {
            return "Location: UTown [Halal] " + getStoreName() + ": " + getStoreDescription();
        } else {
            return "Location: UTown [Non-Halal] " + getStoreName() + ": " + getStoreDescription();
        }
    }

}
