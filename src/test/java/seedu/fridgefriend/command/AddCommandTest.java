package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.exception.InvalidQuantityException;
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
    public void addCommand_foodInCorrectFormat_successfullyAdded()
            throws InvalidDateException {
        AddCommand addCommand = new AddCommand("Coke", FoodCategory.BEVERAGE,
                "30-06-2021", FoodStorageLocation.FREEZER, 5);
        addCommand.setData(fridge);
        addCommand.execute();
        assertEquals("Coke", fridge.getFood(0).getFoodName());
        assertEquals(FoodCategory.BEVERAGE, fridge.getFood(0).getCategory());
        assertEquals(FoodStorageLocation.FREEZER, fridge.getFood(0).getStorageLocation());
        assertEquals(5, fridge.getFood(0).getQuantity());

        ExpiryDate expiryDate = new ExpiryDate("30-06-2021");
        assertEquals(expiryDate.getExpiry(), fridge.getFood(0).getExpiryDate().getExpiry());

        String expectedMessage = "Great! I have added Coke into your fridge.\n"
                + "Details: Food name: Coke, category: BEVERAGE, "
                + "expiry: 30-06-2021, stored in: FREEZER, quantity: 5";
        String actualMessage = addCommand.getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void addCommand_foodCorrectFormat_changeFoodParameters()
            throws InvalidDateException {
        AddCommand addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                "30-06-2021", FoodStorageLocation.FREEZER, 200);
        addCommand.setData(fridge);
        addCommand.execute();
        assertEquals("chicken", fridge.getFood(0).getFoodName());
        assertEquals(FoodCategory.MEAT, fridge.getFood(0).getCategory());
        assertEquals(FoodStorageLocation.FREEZER, fridge.getFood(0).getStorageLocation());
        assertEquals(200, fridge.getFood(0).getQuantity());

        ExpiryDate expiryDate = new ExpiryDate("30-06-2021");
        assertEquals(expiryDate.getExpiry(), fridge.getFood(0).getExpiryDate().getExpiry());

        String expectedMessage = "Great! I have added chicken into your fridge.\n"
                + "Details: Food name: chicken, category: MEAT, "
                + "expiry: 30-06-2021, stored in: FREEZER, quantity: 200";
        String actualMessage = addCommand.getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);

        fridge.getFood(0).setExpiryDate("12-04-2021");
        assertEquals("12-04-2021", fridge.getFood(0).getExpiryDate().toString());
        fridge.getFood(0).setFoodName("cooked chicken");
        fridge.getFood(0).setCategory(FoodCategory.READY_TO_EAT);
        assertEquals(FoodCategory.READY_TO_EAT, fridge.getFood(0).getCategory());
        assertEquals("cooked chicken", fridge.getFood(0).getFoodName());
    }

    @Test
    public void addCommand_invalidDate_InvalidDateException() {
        assertThrows(InvalidDateException.class, () -> {
            Command addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                    "abcd", FoodStorageLocation.FREEZER, 200);
        });
    }

}