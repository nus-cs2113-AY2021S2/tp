package seedu.duke.record;

import java.time.LocalDate;
import java.util.ArrayList;

public class Diet extends Record {

    private double totalCalories;
    private ArrayList<Food> foodList = new ArrayList<>();

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */

    public Diet(RecordType type, LocalDate date, double totalCalories) {
        super(type, date);
        this.totalCalories = totalCalories;
    }

    /**
     * Add food inside food list.
     */
    public void addFood(Food food) {
        foodList.add(food);    // Not sure how to write this part
    }

    /**
     * Sets a new category of food.
     *
     * @param category set new category.
     */
    public void totalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     * Gets the total calorie.
     *
     * @return the total calorie.
     */
    public double getTotalCal() {
        return totalCalories;
    }

    /**
     * Print the list of food.
     */
    public void printFoodList() {
        for (int i = 0; i < foodList.size(); i++) {
            System.out.print(foodList.get(i));
        }
    }

    /**
     * Gets the summary of users' diet record.
     *
     * @return the diet summary.
     */
    @Override
    public String getRecordSummary() {
        return "You have eat total calories:" + this.totalCalories;
    }
}
