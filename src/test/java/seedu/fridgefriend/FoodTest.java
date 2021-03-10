package seedu.fridgefriend;

import org.junit.jupiter.api.Test;
import seedu.fridgefriend.food.Food;
import seedu.fridgefriend.food.FoodCategory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FoodTest {

    @Test
    void testNewFood() {
        Food pork = new Food(FoodCategory.MEAT, "pork");
        assertEquals(FoodCategory.MEAT, pork.getCategory());
        assertEquals("pork", pork.getFoodName());
    }
}
