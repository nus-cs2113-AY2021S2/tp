package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;

import static seedu.duke.common.Messages.MESSAGE_NO_BODY_WEIGHT_PROGRESS;

public class BodyWeightGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param intervalType     the interval type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     */
    public BodyWeightGoal(IntervalType intervalType, double targetBodyWeight) throws NumberFormatException {
        super(RecordType.BODYWEIGHT, intervalType, targetBodyWeight);
        if (targetBodyWeight < 40 || targetBodyWeight > 400) {
            throw new NumberFormatException("Target weight invalid");
        }
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param intervalType     the interval type of the goal which can be daily or weekly.
     * @param targetBodyWeight the target body weight.
     * @param daySet           the date when the goal is set.
     */
    public BodyWeightGoal(IntervalType intervalType, double targetBodyWeight, LocalDate daySet) {
        super(RecordType.BODYWEIGHT, intervalType, targetBodyWeight, daySet);
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
                    + "Goal Type: " + getIntervalType().toString() + " " + getType().toString().toLowerCase() + "\n"
                    + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                    + "Progress: " + MESSAGE_NO_BODY_WEIGHT_PROGRESS;
        } else {
            return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                    + "Goal Type: " + getIntervalType().toString() + " " + getType().toString().toLowerCase() + "\n"
                    + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                    + "Progress: " + getProgress() + getProgressUnit();
        }
    }

    @Override
    public String getGoalData() {
        if (progress == -1) {
            return SEPARATOR_TAB + getDaySet().format(DATE_FORMATTER) + SEPARATOR_TAB + SEPARATOR_TAB
                    + getIntervalType().toString().toLowerCase() + separatorBetweenTypeAndTarget
                    + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                    + MESSAGE_NO_BODY_WEIGHT_PROGRESS + "\n";
        } else {
            return SEPARATOR_TAB + getDaySet().format(DATE_FORMATTER) + SEPARATOR_TAB + SEPARATOR_TAB
                    + getIntervalType().toString().toLowerCase() + separatorBetweenTypeAndTarget
                    + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                    + getProgress() + " " + getProgressUnit() + getAchieved() + "\n";
        }
    }

    @Override
    public String getGoalDataToStore() {
        return "W" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + intervalType + SEPARATOR + target;
    }

    private int getLengthOfTarget() {
        return ("" + target).length() + getProgressUnit().length() + 1;
    }
}
