package seedu.fridgefriend.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.fridgefriend.exception.InvalidDateException;
import seedu.fridgefriend.exception.RepetitiveFoodIdentifierException;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

//@@author leeyp
class HistoryCommandTest {

    private Fridge fridge;

    @BeforeEach
    public void setUp() {
        fridge = new Fridge();
    }

    @Test
    public void historyCommand_SuccessfullyReadHistory() throws InvalidDateException,
            RepetitiveFoodIdentifierException {
        AddCommand addCommand1 = new AddCommand("Coke", FoodCategory.BEVERAGE,
                "30-06-2021", FoodStorageLocation.FREEZER, 5);
        addCommand1.setData(fridge);
        addCommand1.execute();

        AddCommand addCommand2 = new AddCommand("chicken", FoodCategory.MEAT,
                "30-06-2021", FoodStorageLocation.FREEZER, 200);
        addCommand2.setData(fridge);
        addCommand2.execute();

        AddCommand addCommand3 = new AddCommand("Milk", FoodCategory.DAIRY,
                "31-12-2021", FoodStorageLocation.FRIDGE_DOOR, 2);
        addCommand3.setData(fridge);
        addCommand3.execute();

        AddCommand addCommand4 = new AddCommand("Milk", FoodCategory.DAIRY,
                "31-12-2021", FoodStorageLocation.FRIDGE_DOOR, 3);
        addCommand4.setData(fridge);
        addCommand4.execute();

        String expectedMessage = "This is the full history of items you've added in the fridge:\n"
                + "\t1. Food name: Coke, category: BEVERAGE, expiry: "
                + "30-06-2021, stored in: FREEZER, quantity: 5\n"
                + "\t2. Food name: chicken, category: MEAT, expiry: "
                + "30-06-2021, stored in: FREEZER, quantity: 200\n"
                + "\t3. Food name: Milk, category: DAIRY, expiry: "
                + "31-12-2021, stored in: FRIDGE_DOOR, quantity: 2\n"
                + "\t4. Food name: Milk, category: DAIRY, expiry: "
                + "31-12-2021, stored in: FRIDGE_DOOR, quantity: 3";

        String actualMessage = HistoryCommand.getHistoryMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void historyCommand_SuccessfullyClearHistory() {
        HistoryCommand.clearHistory();

        String expectedMessage = "This is the full history of items you've added in the fridge:";

        String actualMessage = HistoryCommand.getHistoryMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}