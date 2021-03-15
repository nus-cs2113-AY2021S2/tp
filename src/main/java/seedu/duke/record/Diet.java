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

    public void addFood() {

    }

    public double getTotalCal() {
        return totalCalories;
    }

    public void printFoodList() {

    }

    @Override
    public String getRecordSummary() {
        return null;
    }
}
