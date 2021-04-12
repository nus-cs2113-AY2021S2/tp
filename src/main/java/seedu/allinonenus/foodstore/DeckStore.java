package seedu.allinonenus.foodstore;

public class DeckStore extends FoodStore{

    public DeckStore(String storeName, String storeDescription) {
        super(storeName, storeDescription);
    }

    @Override
    public String toString() {
        if (isHalal()) {
            return "Location: The Deck [Halal] " + getStoreName() + ": " + getStoreDescription();
        } else {
            return "Location: The Deck [Non-Halal] " + getStoreName() + ": " + getStoreDescription();
        }
    }

}
