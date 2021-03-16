package seedu.fridgefriend.food;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import seedu.fridgefriend.exception.InvalidDateException;

public class FoodTest {

    @Test
    void testNewFood() {
        Food pork = new Food(FoodCategory.MEAT, "pork");
        assertEquals(FoodCategory.MEAT, pork.getCategory());
        assertEquals("pork", pork.getFoodName());
    }

    @Test
    void testStorageExpiryDate() throws InvalidDateException {
        Food beef = new Food(FoodCategory.MEAT, "beef");
        beef.setExpiryDate("15-03-2021");
        assertEquals("15-03-2021", beef.getExpiryDate().toString());
    }

    @Test
    void invalidDate_wrongDateFormate_exceptionThrown() {
        Food chicken = new Food(FoodCategory.MEAT, "chicken");
        assertThrows(InvalidDateException.class, () -> {
            chicken.setExpiryDate("15-3-2021");
        });
    }

    @Test
    void testStorageLocation() {
        Food grouper = new Food(FoodCategory.SEAFOOD, "grouper");
        grouper.setStorageLocation(FoodStorageLocation.FREEZER);
        assertEquals(FoodStorageLocation.FREEZER, grouper.getStorageLocation());
    }

    @Test
    void testChangeFoodDescriptionCategory() {
        Food chocolate = new Food(FoodCategory.DAIRY, "chocolate");
        assertEquals(FoodCategory.DAIRY, chocolate.getCategory());
        assertEquals("chocolate", chocolate.getFoodName());
        chocolate.setFoodName("melted chocolate");
        chocolate.setCategory(FoodCategory.OTHER);
        assertEquals(FoodCategory.OTHER, chocolate.getCategory());
        assertEquals("melted chocolate", chocolate.getFoodName());
    }

    @Test
    void testNewFoodAllParameters() throws InvalidDateException {
        Food eggs = new Food(FoodCategory.EGG, "eggs",
                "20-03-2021", FoodStorageLocation.UPPER_SHELF);
        assertEquals(FoodCategory.EGG, eggs.getCategory());
        assertEquals("eggs", eggs.getFoodName());
        assertEquals("20-03-2021", eggs.getExpiryDate().toString());
        assertEquals(FoodStorageLocation.UPPER_SHELF, eggs.getStorageLocation());
    }
}
