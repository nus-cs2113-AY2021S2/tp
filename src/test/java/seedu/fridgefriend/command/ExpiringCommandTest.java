package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiringCommandTest {
    private Fridge fridge;

    //@@author Vinci-Hu
    @BeforeEach
    public void setUp() throws Exception {
        fridge = new Fridge();

        Food chicken = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.MEAT,
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, 200);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE,
                "12-04-2021", FoodStorageLocation.LOWER_SHELF, 100);
        fridge.add(lettuce);

        Food pork = AddCommand.categoriseAndGenerateFood("pork", FoodCategory.MEAT,
                "11-04-2021", FoodStorageLocation.MIDDLE_SHELF, 500);
        fridge.add(pork);
    }

    @Test
    public void expiringCommand_NoExpiry_ListTheExpiringOnly() {
        ExpiringCommand expiringCommand = new ExpiringCommand();
        expiringCommand.setData(fridge);
        expiringCommand.execute();
        String expectedMessage = "Expired message: No food has expired! Congratulations!"
                + "Expiring message: These are the food expiring in the next week:\n"
                + "1. Food name: pork, category: MEAT, expiry: 11-04-2021, stored in: "
                + "MIDDLE_SHELF, quantity: 500";
        String actualMessage = expiringCommand.messageForTesting();
        assertEquals(expectedMessage, actualMessage);
    }
}
