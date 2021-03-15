package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchCommandTest {

    @BeforeEach
    public void setUp() throws Exception {
        Food chicken = new Food(FoodCategory.MEAT, "chicken",
                "30-06-2021", FoodStorageLocation.FREEZER);
        Food pork = new Food(FoodCategory.MEAT, "pork",
                "31-07-2021", FoodStorageLocation.LOWER_SHELF);
        Food lettuce = new Food(FoodCategory.VEGETABLE,"lettuce",
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF);

        Fridge.add(chicken);
        Fridge.add(pork);
        Fridge.add(lettuce);
    }

    private SearchCommand searchCommand(String foodName) throws EmptyDescriptionException {
        return new SearchCommand(foodName);
    }

    @Test
    public void searchCommand_foodInFridge_foodFound() throws EmptyDescriptionException {
        String expectedMessage = "You have chicken stored in FREEZER of your fridge.";
        String actualMessage = searchCommand("chicken").getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void searchCommand_foodNotInFridge_foodNotFound() throws EmptyDescriptionException {
        String expectedMessage = "You do not have oyster in your fridge.";
        String actualMessage = searchCommand("oyster").getMessagePrintedToUser();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void searchCommand_emptyString_emptyDescriptionException() {
        assertThrows(EmptyDescriptionException.class, () ->
                searchCommand(""));
    }

}