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
    }

    public void weight(){

    }

    @Override
    public String getRecordSummary() {
        return null;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
