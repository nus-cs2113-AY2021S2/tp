package seedu.duke.goal;

import seedu.duke.account.FitCenter;
import seedu.duke.account.User;
import seedu.duke.record.RecordType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import static seedu.duke.command.CommandRecordType.DIET;

public class DietGoal extends Goal {
    private final double targetEnergy;
    private double progress;

    /**
     * Initialize an instance of an diet goal.
     *
     * @param periodType   the period type of the goal which can be daily or weekly.
     * @param targetEnergy the target energy to be consumed.
     */
    public DietGoal(PeriodType periodType, double targetEnergy) {
        super(RecordType.DIET, periodType);
        this.targetEnergy = targetEnergy;
        initializeProgress();
    }

    public DietGoal(PeriodType periodType, double targetEnergy, LocalDate daySet) {
        super(RecordType.DIET, periodType);
        this.targetEnergy = targetEnergy;
        this.daySet = daySet;
    }

    /**
     * Gets the the target energy to be consumed.
     *
     * @return the target energy to be consumed in kcal.
     */
    public double getTargetEnergy() {
        return targetEnergy;
    }

    /**
     * Gets the progress of the diet goal (energy consumed).
     *
     * @return the energy consumed in kcal.
     */
    public double getProgress() {
        return progress;
    }

    @Override
    public void setProgressAtLoadingTime(User user) {
        LocalDate currentDate = LocalDate.now();
        FitCenter fitCenter = user.getFitCenter();
        progress = fitCenter.getProgress(DIET, currentDate);
    }

    /**
     * Initializes the progress of the diet goal (energy consumed) to 0 kcal.
     */
    public void initializeProgress() {
        this.progress = 0;
    }

    /**
     * Updates the progress of the diet goal (energy consumed).
     *
     * @param progress the energy consumed in kcal.
     */
    public void updateProgress(double progress) {
        this.progress = progress;
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
                + "Target: " + getTargetEnergy() + getProgressUnit() + "\n"
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
                + getTargetEnergy() + getProgressUnit() + "\t"
                + getProgress() + getProgressUnit() + "\n";
    }

    @Override
    public String getGoalDataToStore() {
        return "D" + SEPARATOR + daySet + SEPARATOR + periodType + SEPARATOR + targetEnergy;
    }
}