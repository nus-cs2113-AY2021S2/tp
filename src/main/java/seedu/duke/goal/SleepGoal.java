package seedu.duke.goal;

import seedu.duke.account.User;
import seedu.duke.record.RecordType;

import java.time.LocalDate;

public class SleepGoal extends Goal {
    private final double targetDuration;
    private double progress;

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType     the period type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     */
    public SleepGoal(PeriodType periodType, double targetDuration) {
        super(RecordType.SLEEP, periodType);
        this.targetDuration = targetDuration;
        initializeProgress();
    }

    public SleepGoal(PeriodType periodType, double targetDuration, LocalDate daySet) {
        super(RecordType.SLEEP, periodType);
        this.targetDuration = targetDuration;
        this.daySet = daySet;
        initializeProgress();
    }

    /**
     * Gets the the target sleeping duration.
     *
     * @return the target sleeping duration in hour(s).
     */
    public double getTargetDuration() {
        return targetDuration;
    }

    /**
     * Gets the progress of the sleeping duration goal.
     *
     * @return the sleeping duration in hour(s).
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Initializes the progress of the sleeping duration to 0hour.
     */
    public void initializeProgress() {
        this.progress = 0;
    }

    /**
     * Updates the progress of the sleeping duration goal.
     *
     * @param progress the sleeping duration in hour(s).
     */
    public void updateProgress(double progress) {
        this.progress = progress;
    }

    @Override
    public String getProgressUnit() {
        return "hour(s)";
    }

    /**
     * Gets a string summary of all info of this goal instance.
     *
     * @return a summary of all info of this goal instance in String.
     */
    @Override
    public String getGoalSummary() {
        return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                + "Target: " + getTargetDuration() + getProgressUnit() + "\n"
                + "Progress: " + getProgress() + getProgressUnit();
    }

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    @Override
    public String getGoalData() {
        return "\t" + getDaySet().format(DATE_FORMATTER) + "\t"
                + getPeriodType().toString().toLowerCase() + "\t"
                + getTargetDuration() + getProgressUnit() + "\t"
                + getProgress() + getProgressUnit() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "S" + SEPARATOR + daySet + SEPARATOR + periodType + SEPARATOR + targetDuration;
    }

    @Override
    public void setProgressAtLoadingTime(User user){

    }
}
