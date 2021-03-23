package seedu.fridgefriend.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

class RunningLowCommandTest {
    
    private Fridge fridge;

    @BeforeEach
    public void setUp() throws Exception {
        fridge = new Fridge();

        Food chicken = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.MEAT, "31-07-2021",
                FoodStorageLocation.LOWER_SHELF, 200);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 100);
        fridge.add(lettuce);

        Food pork = AddCommand.categoriseAndGenerateFood("pork", FoodCategory.MEAT, "31-07-2021",
                FoodStorageLocation.MIDDLE_SHELF, 500);
        fridge.add(pork);
    }
    
    @Test
    public void runningLowCommand_isRunningLow_listCorrectly() {
        RunningLowCommand runningLowCommand = new RunningLowCommand();
        runningLowCommand.setData(fridge);
        String expectedMessage = "You are running low on food in these categories:\n"
                + "1. VEGETABLE quantity: 100 out of 500\n"
                + "2. FRUIT quantity: 0 out of 500\n"
                + "3. SEAFOOD quantity: 0 out of 500\n"
                + "4. EGG quantity: 0 out of 500\n"
                + "5. DAIRY quantity: 0 out of 500\n"
                + "6. BEVERAGE quantity: 0 out of 500\n"
                + "7. COOKED_DISH quantity: 0 out of 500\n"
                + "8. READY_TO_EAT quantity: 0 out of 500\n"
                + "9. FROZEN quantity: 0 out of 500\n"
                + "10. OTHER quantity: 0 out of 500";
        runningLowCommand.execute();
        String actualMessage = runningLowCommand.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
