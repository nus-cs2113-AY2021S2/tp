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
    }

    public void addFood(FoodCategory category) {
//        this.Food.setCategory(category);     // Not sure how to write this part
    }

    public void totalCalories(double totalCalories ){
        this.totalCalories = totalCalories;
    }

    public double getTotalCal() {
        return totalCalories;
    }

    public void printFoodList() {
     //   System.out.println(Food.getCategory());  // Not sure how to write this part
    }

    @Override
    public String getRecordSummary() {
        return null;
    }
}
