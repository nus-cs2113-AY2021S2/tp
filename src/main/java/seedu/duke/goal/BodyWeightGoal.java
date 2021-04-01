package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;

public class BodyWeightGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType       the period type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     */
    public BodyWeightGoal(PeriodType periodType, double targetBodyWeight) {
        super(RecordType.BODYWEIGHT, periodType, targetBodyWeight);
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType       the period type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     * @param daySet           the date when the goal is set.
     */
    public BodyWeightGoal(PeriodType periodType, double targetBodyWeight, LocalDate daySet) {
        super(RecordType.BODYWEIGHT, periodType, targetBodyWeight, daySet);
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    @Override
    public void initializeProgress() {
        progress = -1;
    }

    @Override
    public boolean isAchieved() {
        return progress == target;
    }

    @Override
    public String getProgressUnit() {
        return "Kg";
    }

    @Override
    public String getGoalSummary() {
        if (progress == -1) {
            return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                    + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                    + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                    + "Progress: " + "You haven't add any body weight record.";
        } else {
            return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                    + "Goal Type: " + getPeriodType().toString() + " " + getType().toString().toLowerCase() + "\n"
                    + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                    + "Progress: " + getProgress() + getProgressUnit();
        }
    }

    @Override
    public String getGoalData() {
        if (progress == -1) {
            return "\t" + getDaySet().format(DATE_FORMATTER) + "\t\t"
                    + getPeriodType().toString().toLowerCase() + getAchieved() + separatorBetweenTypeAndTarget
                    + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                    + "None Progress" + getAchieved() + "\n";
        } else {
            return "\t" + getDaySet().format(DATE_FORMATTER) + "\t\t"
                    + getPeriodType().toString().toLowerCase() + separatorBetweenTypeAndTarget
                    + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                    + getProgress() + " " + getProgressUnit() + getAchieved() + "\n";
        }
    }

    @Override
    public String getGoalDataToStore() {
        return "W" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }

    private int getLengthOfTarget() {
        return ("" + target).length() + getProgressUnit().length() + 1;
    }
}
