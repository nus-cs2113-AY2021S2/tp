package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.ExpiryDate;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.food.Quantity;
import seedu.fridgefriend.food.Weight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AddCommandTest {

    private Fridge fridge;

    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
    }

    @Test
    public void addCommand_foodInCorrectFormatWithWeight_successfullyAdded() throws InvalidDateException,
            InvalidQuantityException {
        AddCommand addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                "30-06-2021", FoodStorageLocation.FREEZER, new Weight("200g"));
        addCommand.setData(fridge);
        addCommand.execute();
        assertEquals("chicken", fridge.getFood(0).getFoodName());
        assertEquals(FoodCategory.MEAT, fridge.getFood(0).getCategory());
        assertEquals(FoodStorageLocation.FREEZER, fridge.getFood(0).getStorageLocation());
        assertEquals("200g", fridge.getFood(0).getQuantity().toString());

        ExpiryDate expiryDate = new ExpiryDate("30-06-2021");
        assertEquals(expiryDate.getExpiry(), fridge.getFood(0).getExpiryDate().getExpiry());

        String expectedMessage = "Great! I have added chicken into your fridge.\n"
                + "Details: Food name: chicken, category: MEAT, "
                + "expiry: 30-06-2021, stored in: FREEZER, weight: 200g";
        String actualMessage = addCommand.getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void addCommand_foodInCorrectFormatWithQuantity_successfullyAdded() throws InvalidDateException,
            InvalidQuantityException {
        AddCommand addCommand = new AddCommand("Coke", FoodCategory.BEVERAGE,
                "30-06-2021", FoodStorageLocation.FREEZER, new Quantity("5"));
        addCommand.setData(fridge);
        addCommand.execute();
        assertEquals("Coke", fridge.getFood(0).getFoodName());
        assertEquals(FoodCategory.BEVERAGE, fridge.getFood(0).getCategory());
        assertEquals(FoodStorageLocation.FREEZER, fridge.getFood(0).getStorageLocation());
        assertEquals("5", fridge.getFood(0).getQuantity().toString());

        ExpiryDate expiryDate = new ExpiryDate("30-06-2021");
        assertEquals(expiryDate.getExpiry(), fridge.getFood(0).getExpiryDate().getExpiry());

        String expectedMessage = "Great! I have added Coke into your fridge.\n"
                + "Details: Food name: Coke, category: BEVERAGE, "
                + "expiry: 30-06-2021, stored in: FREEZER, quantity: 5";
        String actualMessage = addCommand.getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void addCommand_invalidDate_InvalidDateException() {
        assertThrows(InvalidDateException.class, () -> {
            Command addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                    "abcd", FoodStorageLocation.FREEZER, new Weight("200g"));
        });
    }

    @Test
    public void addCommand_invalidWeight_InvalidQuantityException() {
        assertThrows(InvalidQuantityException.class, () -> {
            Command addCommand = new AddCommand("chicken", FoodCategory.MEAT,
                    "30-06-2021", FoodStorageLocation.FREEZER, new Weight("500g!@#"));
        });
    }

    @Test
    public void addCommand_invalidQuantity_InvalidQuantityException() {
        assertThrows(InvalidQuantityException.class, () -> {
            Command addCommand = new AddCommand("coke", FoodCategory.BEVERAGE,
                    "30-06-2021", FoodStorageLocation.FREEZER, new Weight("500g!@#"));
        });
    }
}