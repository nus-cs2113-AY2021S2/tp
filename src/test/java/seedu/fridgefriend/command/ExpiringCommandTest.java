package seedu.fridgefriend.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;
import seedu.fridgefriend.food.Fridge;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiringCommandTest {
    private Fridge fridge;
    private String expiringDate;
    private String expiredDate;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    //@@author Vinci-Hu
    @BeforeEach
    public void setUp() throws Exception {
        // LocalDate today = LocalDate.now();
        LocalDate testDate1 = LocalDate.now().plusDays(5);
        String date1 = testDate1.format(formatter);
        expiringDate = date1;
        LocalDate testDate2 = LocalDate.now().plusDays(18);
        String date2 = testDate2.format(formatter);

        fridge = new Fridge();

        Food chicken = AddCommand.categoriseAndGenerateFood("chicken", FoodCategory.MEAT,
                date1, FoodStorageLocation.LOWER_SHELF, 200);
        fridge.add(chicken);

        Food lettuce = AddCommand.categoriseAndGenerateFood("lettuce", FoodCategory.VEGETABLE,
                date2, FoodStorageLocation.LOWER_SHELF, 100);
        fridge.add(lettuce);

    }

    @Test
    public void expiringCommand_NoExpiry_ListTheExpiringOnly() {
        ExpiringCommand expiringCommand = new ExpiringCommand();
        expiringCommand.setData(fridge);
        expiringCommand.execute();
        String expectedMessage = "These are the food expiring in the following week:\n"
                + "1. Food name: chicken, category: MEAT, expiry: "
                + expiringDate
                + ", stored in: LOWER_SHELF, quantity: 200";
        String actualMessage = expiringCommand.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void expiringCommand_GotExpiry_ListBothCorrectly() throws Exception {
        LocalDate testDate3 = LocalDate.now().minusMonths(2);
        String date3 = testDate3.format(formatter);
        expiredDate = date3;

        Food pork = AddCommand.categoriseAndGenerateFood("pork", FoodCategory.MEAT,
                date3, FoodStorageLocation.MIDDLE_SHELF, 500);
        fridge.add(pork);

        ExpiringCommand expiringCommand = new ExpiringCommand();
        expiringCommand.setData(fridge);
        expiringCommand.execute();
        String expectedMessage = "These are the food expiring in the following week:\n"
                + "1. Food name: chicken, category: MEAT, expiry: "
                + expiringDate
                + ", stored in: LOWER_SHELF, quantity: 200\n\n"
                + "These are the food that has already expired, please consider removing them:\n"
                + "1. Food name: pork, category: MEAT, expiry: "
                + expiredDate
                + ", stored in: MIDDLE_SHELF, quantity: 500";
        String actualMessage = expiringCommand.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}