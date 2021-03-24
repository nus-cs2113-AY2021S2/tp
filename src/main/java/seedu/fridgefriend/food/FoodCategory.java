package seedu.fridgefriend.food;

/**
 * Subject to changes with discussion.
 */
public enum FoodCategory {
    VEGETABLE,      // e.g. eggplant, spinach, bok choy, including beans and fungus
    FRUIT,          // e.g. strawberry, apple, grapes
    MEAT,           // e.g. pork, beef, lamb, chicken
    SEAFOOD,        // e.g. salmon, mackerel, crab, prawn
    EGG,            // e.g. egg, duck egg, quail egg
    DAIRY,          // e.g. milk, butter, cheese, yoghurt
    BEVERAGE,       // e.g. coke, orange juice
    COOKED_DISH,    // e.g. tomato scrambled eggs, chicken soup
    READY_TO_EAT,   // e.g. sandwich
    FROZEN,    // e.g. frozen dumpling, ice cream
    OTHER;

    private static int vegetableMinimumQuantity = 500;
    private static int fruitMinimumQuantity = 500;
    private static int meatMinimumQuantity = 500;
    private static int seafoodMinimumQuantity = 500;
    private static int eggMinimumQuantity = 500;
    private static int dairyMinimumQuantity = 500;
    private static int beverageMinimumQuantity = 500;
    private static int cookedMinimumQuantity = 500;
    private static int readyMinimumQuantity = 500;
    private static int frozenMinimumQuantity = 500;
    private static int otherMinimumQuantity = 500;

    public static boolean contains(String string) {
        for (FoodCategory foodCategory : values()) {
            if (foodCategory.name().equals(string)) {
                return true;
            }
        }
        return false;
    }

    public static FoodCategory convertStringToFoodCategory(String rawCategoryStr) {
        String processedCategoryStr = rawCategoryStr.toUpperCase();
        if (FoodCategory.contains(processedCategoryStr)) {
            return FoodCategory.valueOf(processedCategoryStr);
        } else {
            return FoodCategory.OTHER;
        }
    }

    public static boolean isValidCategory(String line) {
        return FoodCategory.contains(line.toUpperCase());
    }

    public static int getMinimumQuantity(FoodCategory foodCategory) {
        assert foodCategory != null : "foodCategory cannot be null";
        switch (foodCategory) {
        case BEVERAGE:
            return beverageMinimumQuantity;
        case COOKED_DISH:
            return cookedMinimumQuantity;
        case DAIRY:
            return dairyMinimumQuantity;
        case EGG:
            return eggMinimumQuantity;
        case FROZEN:
            return frozenMinimumQuantity;
        case FRUIT:
            return fruitMinimumQuantity;
        case MEAT:
            return meatMinimumQuantity;
        case OTHER:
            return otherMinimumQuantity;
        case READY_TO_EAT:
            return readyMinimumQuantity;
        case SEAFOOD:
            return seafoodMinimumQuantity;
        case VEGETABLE:
            return vegetableMinimumQuantity;
        default:
            return 0;
        }
    }

    public static void setMinimumQuantity(FoodCategory foodCategory, int quantity) {
        assert foodCategory != null : "foodCategory cannot be null";
        switch (foodCategory) {
        case BEVERAGE:
            beverageMinimumQuantity = quantity;
            break;
        case COOKED_DISH:
            cookedMinimumQuantity = quantity;
            break;
        case DAIRY:
            dairyMinimumQuantity = quantity;
            break;
        case EGG:
            eggMinimumQuantity = quantity;
            break;
        case FROZEN:
            frozenMinimumQuantity = quantity;
            break;
        case FRUIT:
            fruitMinimumQuantity = quantity;
            break;
        case MEAT:
            meatMinimumQuantity = quantity;
            break;
        case OTHER:
            otherMinimumQuantity = quantity;
            break;
        case READY_TO_EAT:
            readyMinimumQuantity = quantity;
            break;
        case SEAFOOD:
            seafoodMinimumQuantity = quantity;
            break;
        case VEGETABLE:
            vegetableMinimumQuantity = quantity;
            break;
        default:
            return;
        }
    }
    
}




