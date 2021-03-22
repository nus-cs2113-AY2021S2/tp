package seedu.fridgefriend.food;

import seedu.fridgefriend.exception.InvalidQuantityException;

public class Weight extends Quantity {

    private String unit;
    public static final String UNIT_CHARACTER = "g";

    public Weight(String quantityString) throws InvalidQuantityException {
        try {
            String[] words = quantityString.split("(?<=\\d)(?=[a-z])");
            this.number = Integer.parseInt(words[0]);
            this.unit = words[1];
            if (unit.length() > 1 || !unit.equals("g")) {
                throw new InvalidQuantityException();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException exception) {
            throw new InvalidQuantityException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(number) + unit;
    }

}
