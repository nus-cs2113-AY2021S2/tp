package seedu.fridgefriend.command;

import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.ExpiryDate;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCommandTest {

    @Test
    void addCommand_correctData_correctlyConstructed() throws InvalidDateException, InvalidInputException {
        AddCommand addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                "30-06-2021", FoodStorageLocation.FREEZER);
        ExpiryDate expiryDate = new ExpiryDate("30-06-2021");
        addCommand.execute();

        assertEquals("chicken",Fridge.getFood(0).getFoodName());
        assertEquals(FoodCategory.MEAT,Fridge.getFood(0).getCategory());
        assertEquals(expiryDate.getExpiry(), Fridge.getFood(0).getExpiryDate().getExpiry());
        assertEquals(FoodStorageLocation.FREEZER, Fridge.getFood(0).getStorageLocation());
    }

    @Test
    void addCommand_invalidDate_expectException() {
        assertThrows(InvalidDateException.class, () -> {
            Command addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                    "abcd", FoodStorageLocation.FREEZER);
        });
    }
}