package seedu.duke.record;

import java.time.LocalDate;

public class Sleep extends Record {
    private final double duration;

    /**
     * Represents a record of sleeping data.
     *
     * @param duration the duration of the sleep.
     * @param date     the date of the sleep.
     */
    public Sleep(double duration, LocalDate date) {
        super(RecordType.SLEEP, date);
        this.duration = duration;
    }

    /**
     * Gets the duration of a sleep record.
     *
     * @return the duration of the sleep record.
     */
    public double getDuration() {
        return duration;
    }

    /**
     * Returns the sleep record summary.
     *
     * @return a String of the record summary.
     */
    @Override
    public String getRecordSummary() {
        return getDuration() + " " + getUnit() + " of sleep on " + getDate().format(DATE_FORMATTER);
    }

    @Override
    public String getRecordData() {
        return "\t\t\t" + getDate().format(DATE_FORMATTER)
                + "\t\t" + getDuration() + " " + getUnit();
    }

    @Override
    public String getRecordDataToStore() {
        return "S" + SEPARATOR + duration + SEPARATOR + getDate().format(DATE_FORMATTER);
    }

    private String getUnit() {
        return "hour(s)";
    }
}
