package seedu.duke.exception;

import seedu.duke.record.FoodCategory;

public class TypeException extends Exception {
    private String invalidType;

    public TypeException(String type) {
        invalidType = type;
    }

    public String toString() {
        if (invalidType.equals("food type exception")) {
            return "The food type is invalid, the acceptable food list is:\n" + FoodCategory.validFoodList;
        }
        return "";
    }
}
