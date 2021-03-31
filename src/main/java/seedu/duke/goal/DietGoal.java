package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;


public class DietGoal extends Goal {


    /**
     * Initialize an instance of an diet goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be consumed.
     */
    public DietGoal(PeriodType periodType, double targetEnergy) {
        super(RecordType.DIET, periodType, targetEnergy);
        initializeProgress();
    }

    public DietGoal(PeriodType periodType, double targetEnergy, LocalDate daySet) {
        super(RecordType.DIET, periodType, targetEnergy, daySet);
        initializeProgress();;
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
                + "Target: " + getTarget() + " " + getProgressUnit() + "\n"
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
                + getPeriodType().toString().toLowerCase() + "\t\t"
                + getTarget() + " " + getProgressUnit() + "\t\t"
                + getProgress() + " " + getProgressUnit() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "D" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }
}