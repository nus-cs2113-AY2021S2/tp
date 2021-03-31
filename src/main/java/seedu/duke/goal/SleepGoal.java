package seedu.duke.goal;

import seedu.duke.account.User;
import seedu.duke.record.RecordType;

import java.time.LocalDate;

public class SleepGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType     the period type of the goal which can be daily or weekly.
     * @param targetDuration the target sleeping duration.
     */
    public SleepGoal(PeriodType periodType, double targetDuration) {
        super(RecordType.SLEEP, periodType, targetDuration);
        initializeProgress();
    }

    public SleepGoal(PeriodType periodType, double targetDuration, LocalDate daySet) {
        super(RecordType.SLEEP, periodType, targetDuration, daySet);
        initializeProgress();
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
                + "Target: " + getTarget() + getProgressUnit() + "\n"
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
                + getTarget() + getProgressUnit() + "\t"
                + getProgress() + getProgressUnit() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "S" + SEPARATOR + daySet + SEPARATOR + periodType + SEPARATOR + target;
    }

}
