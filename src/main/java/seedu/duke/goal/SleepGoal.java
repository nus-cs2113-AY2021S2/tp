package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;

public class SleepGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param intervalType     the interval type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     */
    public SleepGoal(IntervalType intervalType, double targetDuration) throws NumberFormatException {
        super(RecordType.SLEEP, intervalType, targetDuration);
        if (intervalType.equals(IntervalType.DAILY)) {
            if (targetDuration <= 0 || targetDuration > 24) {
                throw new NumberFormatException("Target duration invalid");
            }
        } else {
            if (targetDuration <= 0 || targetDuration > 168) {
                throw new NumberFormatException("Target duration invalid");
            }
        }

        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param intervalType     the interval type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     * @param daySet         the date when the goal is set.
     */
    public SleepGoal(IntervalType intervalType, double targetDuration, LocalDate daySet) {
        super(RecordType.SLEEP, intervalType, targetDuration, daySet);
        initializeProgress();
        lengthOfTarget = getLengthOfTarget();
        setSeparator();
    }

    @Override
    public String getProgressUnit() {
        return "hour(s)";
    }

    @Override
    public String getGoalSummary() {
        return "Date Set: " + getDaySet().format(DATE_FORMATTER) + "\n"
                + "Goal Type: " + getIntervalType().toString() + " " + getType().toString().toLowerCase() + "\n"
                + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
                + "Progress: " + getProgress() + " " + getProgressUnit();
    }

    @Override
    public String getGoalData() {
        return SEPARATOR_TAB + getDaySet().format(DATE_FORMATTER) + SEPARATOR_TAB + SEPARATOR_TAB
                + getIntervalType().toString().toLowerCase() + separatorBetweenTypeAndTarget
                + getTarget() + " " + getProgressUnit() + separatorBetweenTargetAndProgress
                + getProgress() + " " + getProgressUnit() + getAchieved() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "S" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + intervalType + SEPARATOR + target;
    }

    private int getLengthOfTarget() {
        return ("" + target).length() + getProgressUnit().length() + 1;
    }
}
