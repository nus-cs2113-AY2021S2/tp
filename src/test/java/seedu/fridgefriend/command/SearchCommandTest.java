package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.EmptyDescriptionException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;
import seedu.fridgefriend.food.Weight;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SearchCommandTest {

    private Fridge fridge;

    @BeforeEach
    public void setUp() throws Exception {
        fridge = new Fridge();
        Food chicken = new Food(FoodCategory.MEAT, "chicken",
                "30-06-2021", FoodStorageLocation.FREEZER, new Weight("200g"));
        fridge.add(chicken);

        Food pork = new Food(FoodCategory.MEAT, "pork",
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, new Weight("500g"));
        fridge.add(pork);

        Food lettuce = new Food(FoodCategory.VEGETABLE,"lettuce",
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF, new Weight("100g"));
        fridge.add(lettuce);
    }

    private SearchCommand searchCommand(String foodName) throws EmptyDescriptionException {
        SearchCommand searchCommand = new SearchCommand(foodName);
        searchCommand.setData(fridge);
        return searchCommand;
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