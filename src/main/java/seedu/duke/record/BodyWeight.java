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
    public BodyWeight(RecordType type, LocalDate date, double weight) {
        super(type, date);
        this.weight = weight;
    }

    /**
     * Gets the body weight summary.
     *
     * @return the summary of body weight.
     */
    @Override
    public String getRecordSummary() {
        return null;
    }

    /**
     * Gets the weight date.
     *
     * @return the user's weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Sets a new weight of user.
     *
     * @param weight set users' weight.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
