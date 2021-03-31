package seedu.duke.goal;

import seedu.duke.account.User;
import seedu.duke.record.RecordType;

import java.time.LocalDate;

public class ExerciseGoal extends Goal {

    /**
     * Initialize an instance of an exercise goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be burnt.
     */
    public ExerciseGoal(PeriodType periodType, double targetEnergy) {
        super(RecordType.EXERCISE, periodType, targetEnergy);
        initializeProgress();
    }

    public ExerciseGoal(PeriodType periodType, double targetEnergy, LocalDate daySet) {
        super(RecordType.EXERCISE, periodType, targetEnergy, daySet);
        initializeProgress();
    }


    @Override
    public String getProgressUnit() {
        return "Kcal";
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
                + "Target: " + getTarget()  + " " + getProgressUnit() + "\n"
                + "Progress: " + getProgress() + " " + getProgressUnit();
    }

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    @Override
    public String getGoalData() {
        return "\t" + getDaySet().format(DATE_FORMATTER) + "\t\t"
                + getPeriodType().toString().toLowerCase() + "\t\t   "
                + getTarget() + " " + getProgressUnit() + "\t\t"
                + getProgress() + " " + getProgressUnit() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "E" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }

}
