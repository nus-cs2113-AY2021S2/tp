package seedu.fridgefriend.food;

public class MinimumQuantity {

    //@@author kwokyto
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

    //@@author kwokyto
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
            return MinimumQuantity.vegetableMinimumQuantity;
        default:
            return 0;
        }
    }

    //@@author kwokyto
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
            MinimumQuantity.vegetableMinimumQuantity = quantity;
            break;
        default:
            return;
        }
    }
}
