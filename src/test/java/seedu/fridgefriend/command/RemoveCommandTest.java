package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidIndexException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RemoveCommandTest {

    private Fridge fridge;

    /*Solution below adapted from https://github.com/se-edu/addressbook-level2/blob/master
            /test/java/seedu/addressbook/commands/DeleteCommandTest.java*/
    @BeforeEach
    public void setUp() throws Exception {
        fridge = new Fridge();
        Food chicken = new Food(FoodCategory.MEAT, "chicken",
                "30-06-2021", FoodStorageLocation.FREEZER);
        fridge.add(chicken);

        Food pork = new Food(FoodCategory.MEAT, "pork",
                "31-07-2021",FoodStorageLocation.LOWER_SHELF);
        fridge.add(pork);

        Food lettuce = new Food(FoodCategory.VEGETABLE,"lettuce",
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF);
        fridge.add(lettuce);
    }

    @Test
    public void removeCommand_validIndex_successfullyRemove() throws InvalidIndexException {
        RemoveCommand removeCommand = new RemoveCommand(1);
        removeCommand.setData(fridge);
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