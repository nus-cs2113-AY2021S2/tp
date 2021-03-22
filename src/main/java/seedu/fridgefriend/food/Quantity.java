package seedu.fridgefriend.food;

import seedu.fridgefriend.exception.InvalidQuantityException;

/**
 * Represent the quantity of a food that is stored in the fridge.
 */
public class Quantity {

    protected int number;

    public Quantity() {
    }

    public Quantity(String quantityString) throws InvalidQuantityException {
        assert quantityString != null : "quantity string should not be null";
        try {
            this.number = Integer.parseInt(quantityString);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidQuantityException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
