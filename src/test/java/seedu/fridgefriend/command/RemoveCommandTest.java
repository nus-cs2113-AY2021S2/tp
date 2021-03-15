package seedu.fridgefriend.command;

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

    /*Solution below adapted from https://github.com/se-edu/addressbook-level2/blob/master
            /test/java/seedu/addressbook/commands/DeleteCommandTest.java*/
    @BeforeEach
    public void setUp() throws Exception {
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

    private RemoveCommand createRemoveCommand(int displayIndexToRemove) throws InvalidIndexException {
        return new RemoveCommand(displayIndexToRemove);
    }

    @Test
    public void removeCommand_correctData_correctlyConstructed() throws InvalidIndexException {
        int actualIndex = 0;
        String expectedMessage = "Noted! I've removed " + Fridge.getFood(actualIndex).getFoodName()
                + " from your fridge.\n"
                + "Now you have " + Fridge.getSize()
                + " food in the fridge.";
        String actualMessage = createRemoveCommand(1).getMessagePrintedToUser();
        assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void removeCommand_invalidIndex_expectException() {
        assertThrows(InvalidIndexException.class, () ->
                createRemoveCommand(0));
    }


}