package seedu.duke.goal;

import seedu.duke.record.RecordType;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents the abstraction of a goal to be achieved.
 */
public abstract class Goal {
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    protected static final int SPACES_FOR_TYPE = 16;
    protected static final int SPACES_FOR_TARGET = 16;
    protected LocalDate daySet;
    protected RecordType type;
    protected PeriodType periodType;
    protected double target;
    protected double progress;
    protected int lengthOfPeriodType;
    protected int lengthOfTarget;
    protected String separatorBetweenTypeAndTarget;
    protected String separatorBetweenTargetAndProgress;
    public static final String SEPARATOR = " | ";

    /**
     * Initializes the instance with goal type and period type.
     *
     * @param type       the type of the goal which corresponds to the type of health records.
     * @param periodType the period type of the goal which can be daily or weekly.
     */
    public Goal(RecordType type, PeriodType periodType) {
        this.type = type;
        this.periodType = periodType;
        daySet = LocalDate.now();
        lengthOfPeriodType = getLengthOfPeriodType();
    }

    public Goal(RecordType type, PeriodType periodType, double target) {
        this.type = type;
        this.periodType = periodType;
        daySet = LocalDate.now();
        this.target = target;
        lengthOfPeriodType = getLengthOfPeriodType();
    }

    public Goal(RecordType type, PeriodType periodType, double target, LocalDate date) {
        this.type = type;
        this.periodType = periodType;
        daySet = date;
        this.target = target;
        lengthOfPeriodType = getLengthOfPeriodType();
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    protected void initializeProgress() {
        progress = 0;
    }

    public double getTarget() {
        return target;
    }

    /**
     * Gets the date when the goal is set by the user.
     *
     * @return the date when the goal is set by the user.
     */
    public LocalDate getDaySet() {
        return daySet;
    }

    /**
     * Gets the type of the goal.
     *
     * @return the type of the goal which corresponds to the type of health records.
     */
    public RecordType getType() {
        return type;
    }

    /**
     * Gets the period type of a goal.
     *
     * @return the period type of the goal which can be daily or weekly.
     */
    public PeriodType getPeriodType() {
        return periodType;
    }

    /**
     * Gets a string summary of all info of this goal instance.
     *
     * @return a summary of all info of this goal instance in String.
     */
    public abstract String getGoalSummary();

    /**
     * Gets all data of the goal in a table row.
     *
     * @return a string of all data of the goal in a table row.
     */
    public abstract String getGoalData();

    public abstract String getProgressUnit();

    public abstract String getGoalDataToStore();

    protected void setSeparatorBetweenTypeAndTarget() {
        separatorBetweenTypeAndTarget = "";
        for(int i = 0; i < SPACES_FOR_TYPE - lengthOfPeriodType; i++) {
            separatorBetweenTypeAndTarget += " ";
        }
    }

    protected void setSeparatorBetweenTargetAndProgress() {
        separatorBetweenTargetAndProgress = "";
        for(int i = 0; i < SPACES_FOR_TARGET - lengthOfTarget; i++) {
            separatorBetweenTargetAndProgress += " ";
        }
    }

    private int getLengthOfPeriodType() {
        return periodType.toString().length();
    }

    protected void setSeparator() {
        setSeparatorBetweenTargetAndProgress();
        setSeparatorBetweenTypeAndTarget();
    }
}
