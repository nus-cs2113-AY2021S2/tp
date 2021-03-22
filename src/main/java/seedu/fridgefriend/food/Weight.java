package seedu.fridgefriend.food;

import seedu.fridgefriend.exception.InvalidQuantityException;

/**
 * Represent the weight of a food that is stored in the fridge.
 */
public class Weight extends Quantity {

    private String unit;

    public Weight(String quantityString) throws InvalidQuantityException {
        try {
            //Split the string starting with digits follow by alphabet i.e 100g
            String[] words = quantityString.split("(?<=\\d)(?=[a-z])");
            this.number = Integer.parseInt(words[0]);
            this.unit = words[1];
            checkFormat();
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            throw new InvalidQuantityException();
        }
    }

    private void checkFormat() throws InvalidQuantityException {
        if (unit.length() > 1 || !unit.equals("g")) {
            throw new InvalidQuantityException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number) + unit;
    }

}
