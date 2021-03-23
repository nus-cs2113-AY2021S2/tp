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

    private Fridge fridge;

    @BeforeEach
    public void setUp() throws Exception {
        fridge = new Fridge();

        Food chicken = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.MEAT,
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, 200);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE,
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF, 100);

        fridge.add(lettuce);

        Food pork = AddCommand.categoriseAndGenerateFood("pork", FoodCategory.MEAT,
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, 500);
        fridge.add(pork);
    }

    private SearchCommand searchCommand(String foodName) throws EmptyDescriptionException {
        SearchCommand searchCommand = new SearchCommand(foodName);
        searchCommand.setData(fridge);
        return searchCommand;
    }

    @Test
    public void searchCommand_foodInFridge_foodFound() throws EmptyDescriptionException {
        String expectedMessage = "You have chicken stored in LOWER_SHELF of your fridge.";
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