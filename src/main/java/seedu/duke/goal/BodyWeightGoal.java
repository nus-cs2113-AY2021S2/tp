package seedu.duke.goal;

import seedu.duke.record.RecordType;

public class BodyWeightGoal extends Goal {
    private final double targetBodyWeight;
    private double progress;

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType       the period type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     */
    public BodyWeightGoal(PeriodType periodType, double targetBodyWeight) {
        super(RecordType.BODYWEIGHT, periodType);
        this.targetBodyWeight = targetBodyWeight;
        initializeProgress();
    }

    /**
     * Gets the the target body weight.
     *
     * @return the target body weight to be burnt in kg.
     */
    public double getTargetBodyWeight() {
        return targetBodyWeight;
    }

    /**
     * Gets the progress of the body weight goal.
     *
     * @return the body weight in kg.
     */
    public double getProgress() {
        return progress;
    }

    /**
     * Initializes the progress of the body weight goal to 0 kg.
     */
    public void initializeProgress() {
        this.progress = 0;
    }

    /**
     * Updates the progress of the body weight goal.
     *
     * @param progress the body weight in kg.
     */
    public void updateProgress(double progress) {
        this.progress = progress;
    }

    @Override
    public String getProgressUnit() {
        return "Kg";
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
                + "Target: " + getTargetBodyWeight() + getProgressUnit() + "\n"
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
                + getTargetBodyWeight() + getProgressUnit() + "\t"
                + getProgress() + getProgressUnit() + "\n";
    }
}
