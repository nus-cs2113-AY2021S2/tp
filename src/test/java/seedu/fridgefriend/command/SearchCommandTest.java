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
                "27-03-2021", FoodStorageLocation.LOWER_SHELF, 300);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE,
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF, 100);

        fridge.add(lettuce);

        Food roastChicken = AddCommand.categoriseAndGenerateFood("roast chicken", FoodCategory.READY_TO_EAT,
                "31-12-2021", FoodStorageLocation.UPPER_SHELF, 1);
        fridge.add(roastChicken);
    }

    private SearchCommand searchCommand(String foodName) throws EmptyDescriptionException {
        SearchCommand searchCommand = new SearchCommand(foodName);
        searchCommand.setData(fridge);
        return searchCommand;
    }

    @Test
    public void searchCommand_foodInFridge_foodFound() throws EmptyDescriptionException {
        String expectedMessage = "These are the chicken in your fridge:"
                + "\n\t1. Food name: chicken, category: MEAT, "
                + "expiry: 27-03-2021, stored in: LOWER_SHELF, quantity: 300"
                + "\n\t2. Food name: roast chicken, category: READY_TO_EAT, "
                + "expiry: 31-12-2021, stored in: UPPER_SHELF, quantity: 1";
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