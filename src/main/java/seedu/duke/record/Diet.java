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
     * Add food inside foodlist.
     */
    public void addFood(Food food) {
        foodList.add(food);    // Not sure how to write this part
    }

    /**
     * Set the total calories.
     */
    public void totalCalories(double totalCalories) {
        this.totalCalories = totalCalories;
    }

    /**
     * Get the total calories.
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
     * Return a record summary.
     */
    @Override
    public String getRecordSummary() {
        return "You have eat total calories:" + this.totalCalories;
    }
}
