package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoveCommandTest {

    /*Solution below adapted from https://github.com/se-edu/addressbook-level2/blob/master
            /test/java/seedu/addressbook/commands/DeleteCommandTest.java*/
    @BeforeAll
    public static void setUp() throws Exception {
        Food chicken = new Food(FoodCategory.MEAT, "chicken",
                "30-06-2021", FoodStorageLocation.FREEZER);
        Food pork = new Food(FoodCategory.MEAT, "pork",
                "31-07-2021",FoodStorageLocation.LOWER_SHELF);
        Food lettuce = new Food(FoodCategory.VEGETABLE,"lettuce",
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF);

        Fridge.add(chicken);
        Fridge.add(pork);
        Fridge.add(lettuce);
    }

    @Test
    public void removeCommand_validIndex_successfullyRemove() throws InvalidIndexException {
        RemoveCommand removeCommand = new RemoveCommand(1);
        removeCommand.execute();
        String actualMessage = removeCommand.getMessagePrintedToUser();
        String expectedMessage = "Noted! I've removed chicken"
                + " from your fridge.\n"
                + "Now you have 2"
                + " food in the fridge.";
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void removeCommand_invalidIndex_invalidIndexException() {
        assertThrows(InvalidIndexException.class, () ->
                new RemoveCommand(10).execute());
    }

}