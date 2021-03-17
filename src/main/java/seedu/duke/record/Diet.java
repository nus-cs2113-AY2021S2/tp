package seedu.duke.record;

import java.time.LocalDate;

public class Diet extends Record {

    private double totalCalories;

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */

    public Diet(RecordType type, LocalDate date) {
        super(type, date);
        this.totalCalories = 0;
    }

    public void addFood(FoodCategory category) {
 //       Food.setCategory(category);     // Not sure how to write this part
    }

    /**
     * Set the total calories
     */
    public void totalCalories(double totalCalories ){
        this.totalCalories = totalCalories;
    }

    /**
     * Get the total calories
     */
    public double getTotalCal() {
        return totalCalories;
    }

    /**
     * Print the list of food
     */
    public void printFoodList() {
        System.out.println(Food.getCategory());  // Not sure how to write this part
    }

    @Override
    public String getRecordSummary() {
        return null;
    }
}
