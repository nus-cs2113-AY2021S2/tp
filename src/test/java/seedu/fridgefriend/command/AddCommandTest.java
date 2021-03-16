package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.food.ExpiryDate;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCommandTest {

    private Fridge fridge;

    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
    }

    @Test
    public void addCommand_foodInCorrectFormat_successfullyAdded() throws InvalidDateException {
        AddCommand addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                "30-06-2021", FoodStorageLocation.FREEZER);
        addCommand.setData(fridge);
        addCommand.execute();
        assertEquals("chicken", fridge.getFood(0).getFoodName());
        assertEquals(FoodCategory.MEAT, fridge.getFood(0).getCategory());
        assertEquals(FoodStorageLocation.FREEZER, fridge.getFood(0).getStorageLocation());

        ExpiryDate expiryDate = new ExpiryDate("30-06-2021");
        assertEquals(expiryDate.getExpiry(), fridge.getFood(0).getExpiryDate().getExpiry());

        String expectedMessage = "Great! I have added chicken into your fridge.\n"
                + "Details: ||Food name: chicken, category: MEAT, "
                + "expiry: 30-06-2021, stored in: FREEZER||";
        String actualMessage = addCommand.getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void addCommand_invalidDate_InvalidDateException() {
        assertThrows(InvalidDateException.class, () -> {
            Command addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                    "abcd", FoodStorageLocation.FREEZER);
        });
    }
}