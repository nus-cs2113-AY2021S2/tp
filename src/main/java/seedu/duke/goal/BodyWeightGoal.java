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
    }

    public BodyWeightGoal(PeriodType periodType, double targetBodyWeight, LocalDate daySet) {
        super(RecordType.BODYWEIGHT, periodType, targetBodyWeight, daySet);
        initializeProgress();
    }

    protected void initializeProgress() {
        progress = -1;
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

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    @Override
    public String getGoalData() {
        if (progress == -1) {
            return "\t" + getDaySet().format(DATE_FORMATTER) + "\t\t"
                    + getPeriodType().toString().toLowerCase() + "\t\t"
                    + getTarget() + " " + getProgressUnit() + "\t\t"
                    + "None Proress" + "\n";
        } else {
            return "\t" + getDaySet().format(DATE_FORMATTER) + "\t\t"
                    + getPeriodType().toString().toLowerCase() + "\t\t"
                    + getTarget() + " " + getProgressUnit() + "\t\t"
                    + getProgress() + " " + getProgressUnit() + "\n";
        }
    }

    @Override
    public String getGoalDataToStore() {
        return "W" + SEPARATOR + getDaySet().format(DATE_FORMATTER) + SEPARATOR + periodType + SEPARATOR + target;
    }
}
