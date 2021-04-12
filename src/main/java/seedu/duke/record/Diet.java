package seedu.duke.record;

import seedu.duke.exception.TypeException;

import java.time.LocalDate;
import java.util.Locale;

import static seedu.duke.common.Messages.HEADER_FOR_DIET_RECORD_FOOD;
import static seedu.duke.common.Messages.HEADER_FOR_DIET_RECORD_WEIGHT;
import static seedu.duke.record.FoodCategory.INVALID;
import static seedu.duke.record.RecordType.DIET;

public class Diet extends Record {
    private static final int SPACES_FOR_FOOD = HEADER_FOR_DIET_RECORD_FOOD.length();
    private static final int SPACES_FOR_WEIGHT = HEADER_FOR_DIET_RECORD_WEIGHT.length();
    private final double calorie;
    private final FoodCategory foodCategory;
    private final double amount;
    private final String formattedDate;
    private static final String SUMMARY_FORMAT = "%sg %s on %s";
    private String separatorBetweenFoodAndWeight;
    private String separatorBetweenWeightAndCalorie;
    private int lengthOfFood;
    private int lengthOfAmount;

    public Diet(String foodString, String amountStr, LocalDate date) throws TypeException, NumberFormatException {
        super(DIET, date);
        foodCategory = FoodCategory.getFoodCategory(foodString);
        if (foodCategory == INVALID) {
            throw new TypeException("food type exception");
        }
        try {
            this.amount = Double.parseDouble(amountStr);
            if (amount <= 0 || amount > 3000) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Food amount invalid");
        }
        calorie = amount * foodCategory.getCaloriePer100g() / 100;
        this.date = date;
        formattedDate = date.format(DATE_FORMATTER);
        lengthOfFood = foodCategory.toString().length();
        lengthOfAmount = getWeightLength();
        setSeparators();
    }

    /**
     * Gets the calorie of the food.
     *
     * @return the calorie of the food.
     */
    public double getCalorie() {
        return calorie;
    }

    /**
     * Gets the weight of the food in g.
     *
     * @return the weight of the food in g.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Gets the category of the food.
     *
     * @return the category of the food.
     */
    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    /**
     * Gets the summary of users' diet record.
     *
     * @return the diet summary.
     */
    @Override
    public String getRecordSummary() {
        return String.format(SUMMARY_FORMAT, "" + amount,
                foodCategory.toString().toLowerCase(Locale.ROOT), formattedDate);
    }

    /**
     * Gets the record data of this diet record in a row.
     *
     * @return a string of the record data of this diet record in a row.
     */
    @Override
    public String getRecordData() {
        return SEPARATOR_TAB + SEPARATOR_TAB + getDate().format(DATE_FORMATTER)
                + SEPARATOR_TAB + getFoodCategory()
                + separatorBetweenFoodAndWeight + getAmount() + " " + getUnit()
                + separatorBetweenWeightAndCalorie + getCalorie() + " " + getCaloriesUnit();
    }

    @Override
    public String getRecordDataToStore() {
        return "D" + SEPARATOR + foodCategory + SEPARATOR + amount + SEPARATOR + getDate().format(DATE_FORMATTER);
    }

    private String getUnit() {
        return "g";
    }

    private String getCaloriesUnit() {
        return "Kcal";
    }

    private int getWeightLength() {
        return ("" + amount).length() + getUnit().length() + 1;
    }

    private void setSeparators() {
        setSeparatorBetweenFoodAndWeight();
        setSeparatorBetweenWeightAndCalorie();
    }

    private void setSeparatorBetweenFoodAndWeight() {
        separatorBetweenFoodAndWeight = "";
        for (int i = 0; i < SPACES_FOR_FOOD - lengthOfFood; i++) {
            separatorBetweenFoodAndWeight += " ";
        }
    }

    private void setSeparatorBetweenWeightAndCalorie() {
        separatorBetweenWeightAndCalorie = "";
        for (int i = 0; i < SPACES_FOR_WEIGHT - lengthOfAmount; i++) {
            separatorBetweenWeightAndCalorie += " ";
        }
    }
}
