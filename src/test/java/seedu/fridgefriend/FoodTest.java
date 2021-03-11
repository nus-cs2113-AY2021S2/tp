package seedu.fridgefriend;

import org.junit.jupiter.api.Test;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;
import seedu.fridgefriend.food.FoodStorageLocation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {

    @Test
    void testNewFood() {
        Food pork = new Food(FoodCategory.MEAT, "pork");
        assertEquals(FoodCategory.MEAT, pork.getCategory());
        assertEquals("pork", pork.getFoodName());
    }

    @Test
    void testStorageExpiryDate() {
        Food beef = new Food(FoodCategory.MEAT, "beef");
        beef.setExpiryDate("15 March 2021");
        assertEquals("15 March 2021", beef.getExpiryDate());
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
    void testNewFoodAllParameters() {
        Food eggs = new Food(FoodCategory.EGG, "eggs",
                "20 March 2021", FoodStorageLocation.UPPER_SHELF);
        assertEquals(FoodCategory.EGG, eggs.getCategory());
        assertEquals("eggs", eggs.getFoodName());
        assertEquals("20 March 2021", eggs.getExpiryDate());
        assertEquals(FoodStorageLocation.UPPER_SHELF, eggs.getStorageLocation());
    }
}
