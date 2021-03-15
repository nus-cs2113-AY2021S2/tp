package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListCommandTest {

    @BeforeAll
    public static void setUp() throws Exception {
        Food chicken = new Food(FoodCategory.MEAT, "chicken",
                "30-06-2021", FoodStorageLocation.FREEZER);
        Food pork = new Food(FoodCategory.MEAT, "pork",
                "31-07-2021", FoodStorageLocation.LOWER_SHELF);
        Food lettuce = new Food(FoodCategory.VEGETABLE,"lettuce",
                "17-03-2021", FoodStorageLocation.MIDDLE_SHELF);

        Fridge.add(chicken);
        Fridge.add(pork);
        Fridge.add(lettuce);
    }

    @Test
    public void listCommand_listAValidCategory_ListTheCategory() throws InvalidInputException {
        ListCommand listCommand = new ListCommand("MEAT");
        String expectedMessage = "These are the MEAT in your fridge:\n"
                + "\t1. chicken\n"
                + "\t2. pork";
        String actualMessage = listCommand.getListByCategoryMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void listCommand_listAnInvalidCategory_invalidInputException() {
        assertThrows(InvalidInputException.class, () ->
                new ListCommand("abc123").execute());
    }

    @Test
    public void listCommand_listAll_listAllFoodInFridge() {
        ListCommand listCommand = new ListCommand("");
        String expectedMessage = "Here are the items in your fridge:\n"
                + "\t1. chicken [MEAT]\n"
                + "\t2. pork [MEAT]\n"
                + "\t3. lettuce [VEGETABLE]";
        String actualMessage = listCommand.getListAllMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}