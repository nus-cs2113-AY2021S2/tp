package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.exception.InvalidFoodCategoryException;
import seedu.fridgefriend.exception.InvalidFoodLocationException;
import seedu.fridgefriend.exception.InvalidInputException;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ListCommandTest {

    private Fridge fridge;

    //@@author SimJJ96
    @BeforeEach
    public void setUp() throws Exception {
        fridge = new Fridge();

        Food chicken = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.MEAT,
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, 200);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE,
                "17-05-2021", FoodStorageLocation.LOWER_SHELF, 100);
        fridge.add(lettuce);

        Food pork = AddCommand.categoriseAndGenerateFood("pork", FoodCategory.MEAT,
                "31-07-2021", FoodStorageLocation.MIDDLE_SHELF, 500);
        fridge.add(pork);
    }

    @Test
    public void listCommand_listAnInvalidCategory_invalidInputException() {
        assertThrows(InvalidInputException.class, () ->
                new ListCommand("abc123").execute());
    }
    //@author

    //@@author Vinci-Hu
    @Test
    public void listCommand_listAValidCategory_ListTheCategoryInCorrectSequence() throws InvalidFoodCategoryException {
        ListCommand listCommand = new ListCommand("MEAT");
        listCommand.setData(fridge);
        String expectedMessage = "These are the MEAT in your fridge:\n"
                + "\t1. Food name: chicken, category: MEAT, expiry: "
                + "31-07-2021, stored in: LOWER_SHELF, quantity: 200\n"
                + "\t2. Food name: pork, category: MEAT, expiry: "
                + "31-07-2021, stored in: MIDDLE_SHELF, quantity: 500";
        String actualMessage = listCommand.getListByCategoryMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void listCommand_listAll_listAllFoodInFridge() {
        ListCommand listCommand = new ListCommand("");
        listCommand.setData(fridge);
        String expectedMessage = "Here are the items in your fridge:\n"
                + "\t1. Food name: chicken, category: MEAT, expiry: "
                + "31-07-2021, stored in: LOWER_SHELF, quantity: 200\n"
                + "\t2. Food name: lettuce, category: VEGETABLE, expiry: "
                + "17-05-2021, stored in: LOWER_SHELF, quantity: 100\n"
                + "\t3. Food name: pork, category: MEAT, expiry: "
                + "31-07-2021, stored in: MIDDLE_SHELF, quantity: 500";
        String actualMessage = listCommand.getListAllMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    //@@author

    //@@author leeyp
    @Test
    public void listCommand_listAValidLocation_ListTheLocationInCorrectSequence() throws InvalidFoodLocationException {
        ListCommand listCommand = new ListCommand("LOWER_SHELF");
        listCommand.setData(fridge);
        String expectedMessage = "These are the food stored in LOWER_SHELF:\n"
                + "\t1. Food name: chicken, category: MEAT, expiry: "
                + "31-07-2021, stored in: LOWER_SHELF, quantity: 200\n"
                + "\t2. Food name: lettuce, category: VEGETABLE, expiry: "
                + "17-05-2021, stored in: LOWER_SHELF, quantity: 100";
        String actualMessage = listCommand.getListByStorageLocationMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void listCommand_listByOthersCategoryAndStorageLocation() throws Exception {
        Fridge fridgeOther = new Fridge();

        Food chickenOther = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.OTHER,
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, 200);
        fridgeOther.add(chickenOther);

        Food lettuceOther = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE,
                "17-05-2021", FoodStorageLocation.OTHER, 100);
        fridgeOther.add(lettuceOther);

        Food porkOther = AddCommand.categoriseAndGenerateFood("pork", FoodCategory.OTHER,
                "31-07-2021", FoodStorageLocation.OTHER, 500);
        fridgeOther.add(porkOther);

        Food duckNotOther = AddCommand.categoriseAndGenerateFood("duck", FoodCategory.MEAT,
                "31-07-2021", FoodStorageLocation.LOWER_SHELF, 500);
        fridgeOther.add(duckNotOther);

        ListCommand listCommand = new ListCommand("OTHER");

        listCommand.setData(fridgeOther);
        String expectedMessage = "These are the food that belong to OTHER:\n"
                + "\t1. Food name: chicken, category: OTHER, expiry: "
                + "31-07-2021, stored in: LOWER_SHELF, quantity: 200\n"
                + "\t2. Food name: lettuce, category: VEGETABLE, expiry: "
                + "17-05-2021, stored in: OTHER, quantity: 100\n"
                + "\t3. Food name: pork, category: OTHER, expiry: "
                + "31-07-2021, stored in: OTHER, quantity: 500";
        String actualMessage = listCommand.getListByOthersMessage();
        assertEquals(expectedMessage, actualMessage);
    }
    //@@author

}