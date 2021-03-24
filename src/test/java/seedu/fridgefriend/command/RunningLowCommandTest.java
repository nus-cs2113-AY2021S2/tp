package seedu.fridgefriend.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

class RunningLowCommandTest {
    
    private Fridge fridge;

    public void semiPopulateFridge() throws Exception {
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

    public void fullyPopulateFridge() throws Exception {
        fridge = new Fridge();

        Food chicken = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.MEAT, "31-07-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(lettuce);

        Food apple = AddCommand.categoriseAndGenerateFood("apple", FoodCategory.FRUIT, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(apple);

        Food fish = AddCommand.categoriseAndGenerateFood("fish", FoodCategory.SEAFOOD, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(fish);

        Food egg = AddCommand.categoriseAndGenerateFood("egg", FoodCategory.EGG, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(egg);

        Food cheese = AddCommand.categoriseAndGenerateFood("cheese", FoodCategory.DAIRY, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(cheese);

        Food coke = AddCommand.categoriseAndGenerateFood("coke", FoodCategory.BEVERAGE, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(coke);

        Food soup = AddCommand.categoriseAndGenerateFood("soup", FoodCategory.COOKED_DISH, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(soup);

        Food sandwich = AddCommand.categoriseAndGenerateFood("sandwich", FoodCategory.READY_TO_EAT, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(sandwich);

        Food iceCream = AddCommand.categoriseAndGenerateFood("iceCream", FoodCategory.FROZEN, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(iceCream);

        Food icePack = AddCommand.categoriseAndGenerateFood("icePack", FoodCategory.OTHER, "17-03-2021",
                FoodStorageLocation.LOWER_SHELF, 1000);
        fridge.add(icePack);
    }
    
    @Test
    public void runningLowCommand_isSemiPopulated_listCorrectly() throws Exception {
        semiPopulateFridge();
        RunningLowCommand runningLowCommand = new RunningLowCommand();
        runningLowCommand.setData(fridge);
        String expectedMessage = "You are running low on food in these categories:\n"
                + "1. VEGETABLE quantity: 100 out of 500\n" + "2. FRUIT quantity: 0 out of 500\n"
                + "3. SEAFOOD quantity: 0 out of 500\n" + "4. EGG quantity: 0 out of 500\n"
                + "5. DAIRY quantity: 0 out of 500\n" + "6. BEVERAGE quantity: 0 out of 500\n"
                + "7. COOKED_DISH quantity: 0 out of 500\n" + "8. READY_TO_EAT quantity: 0 out of 500\n"
                + "9. FROZEN quantity: 0 out of 500\n" + "10. OTHER quantity: 0 out of 500";
        runningLowCommand.execute();
        String actualMessage = runningLowCommand.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    
    @Test
    public void runningLowCommand_isFullyPopulated_correctMessage() throws Exception {
        fullyPopulateFridge();
        RunningLowCommand runningLowCommand = new RunningLowCommand();
        runningLowCommand.setData(fridge);
        String expectedMessage = "Congrats! You are all stocked up on food! :D";
        runningLowCommand.execute();
        String actualMessage = runningLowCommand.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
