package seedu.duke.record;

import java.time.LocalDate;

public class BodyWeight extends Record {
    private final double weight;

    public BodyWeight(double weight, LocalDate date) throws NumberFormatException {
        super(RecordType.BODYWEIGHT, date);
        this.weight = weight;
        if (weight < 30 || weight > 400) {
            throw new NumberFormatException("Body weight invalid");
        }
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
     * Gets the body weight summary.
     *
     * @return the summary of body weight.
     */
    @Override
    public String getRecordSummary() {
        return "Body weight " + getWeight() + " " + getUnit() + " on " + getDate().format(DATE_FORMATTER);
    }

    @Override
    public String getRecordData() {
        return SEPARATOR_TAB + SEPARATOR_TAB + getDate().format(DATE_FORMATTER)
                + SEPARATOR_TAB + SEPARATOR_TAB + getWeight() + " " + getUnit();
    }

    @Override
    public String getRecordDataToStore() {
        return "W"  + SEPARATOR + weight + SEPARATOR + getDate().format(DATE_FORMATTER);
    }

    private String getUnit() {
        return "Kg";
    }


}
