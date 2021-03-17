package seedu.duke.record;

import java.time.LocalDate;

public class BodyWeight extends Record {
    private double weight;

    /**
     * Initializes the object with given record type and date.
     *
     * @param type the type of the record.
     * @param date the date of the record.
     */
    public BodyWeight(RecordType type, LocalDate date) {
        super(type, date);
        this.weight = 0;
    }

    /**
     * Return the summary of record
     */
    @Override
    public String getRecordSummary() {
        return null;
    }

    /**
     * Get the weight data
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Set the weight data
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
