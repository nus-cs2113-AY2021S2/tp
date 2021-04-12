package seedu.allinonenus.foodstore;

public class TechnoStore extends FoodStore {

    public TechnoStore(String storeName, String storeDescription) {
        super(storeName, storeDescription);
    }

    @Override
    public String toString() {
        if (isHalal()) {
            return "Location: Techno Edge [Halal] " + getStoreName() + ": " + getStoreDescription();
        } else {
            return "Location: Techno Edge [Non-Halal] " + getStoreName() + ": " + getStoreDescription();
        }
    }

}
