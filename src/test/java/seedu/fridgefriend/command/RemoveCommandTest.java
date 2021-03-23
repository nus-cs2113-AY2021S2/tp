package seedu.fridgefriend.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.fridgefriend.exception.FoodNameNotFoundException;
import seedu.fridgefriend.exception.InvalidQuantityException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

class RemoveCommandTest {

    private Fridge fridge;
    private RemoveCommand removeCommand;

    /*Solution below adapted from https://github.com/se-edu/addressbook-level2/blob/master
            /test/java/seedu/addressbook/commands/DeleteCommandTest.java*/

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
        removeCommand = new RemoveCommand("pork", 1000);
        removeCommand.setData(fridge);
    }

    @Test
    public void removeCommand_removePortionOfFood_successfullyRemovePortion()
            throws InvalidQuantityException, FoodNameNotFoundException {
        RemoveCommand removeCommand = new RemoveCommand("chicken", 100);
        removeCommand.setData(fridge);
        removeCommand.execute();
        String actualMessage = removeCommand.getMessagePrintedToUser();
        String expectedMessage = "Noted! I've removed 100 of the food "
                + "chicken from your fridge.\n"
                + "New quantity: 100";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void removeCommand_removeAllOfFood_successfullyRemoveObject()
            throws InvalidQuantityException, FoodNameNotFoundException {
        RemoveCommand removeCommand = new RemoveCommand("chicken", 200);
        removeCommand.setData(fridge);
        removeCommand.execute();
        String actualMessage = removeCommand.getMessagePrintedToUser();
        String expectedMessage = "Noted! I've removed chicken from your fridge.\n"
                + "Now you have 2 food in the fridge.";
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void removeCommand_invalidQuantity_invalidQuantityException() {
        assertThrows(InvalidQuantityException.class, () ->
                removeCommand.execute());
    }

    /*
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
    */
}