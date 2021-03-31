package seedu.duke.record;

import seedu.duke.exception.TypeException;

import java.time.LocalDate;

import static seedu.duke.record.WorkoutCategory.INVALID;

public class Exercise extends Record {
    private double calories;
    private final WorkoutCategory workoutCategory;
    private final int duration;
    private int spaceCount;
    private String separator = "";

    public Exercise(String activityStr, int duration, LocalDate date) throws TypeException {
        super(RecordType.EXERCISE, date);
        try {
            workoutCategory = WorkoutCategory.valueOf(activityStr.toUpperCase());
            if (workoutCategory == INVALID) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            throw new TypeException("workout type exception");
        }
        spaceCount = 16 - workoutCategory.toString().length();
        for (int i = 0; i < spaceCount; i++) {
            separator += " ";
        }
        this.duration = duration;
        this.calories = duration * workoutCategory.getCaloriePerMin();
    }


    public double getCalories() {
        return calories;
    }

    public WorkoutCategory getWorkoutCategory() {
        return workoutCategory;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String getRecordSummary() {
        return getDuration() + " minutes of "
                + getWorkoutCategory() + " exercise on " + getDate().format(DATE_FORMATTER);
    }

    @Override
    public String getRecordData() {
        return "\t\t\t" + getDate().format(DATE_FORMATTER)
                + "\t" + getWorkoutCategory()
                + separator + getDuration() + " minute(s)"
                + "\t" + getCalories() + " cal";
    }

    @Override
    public String getRecordDataToStore() {
        return "E" + SEPARATOR + workoutCategory + SEPARATOR + duration + SEPARATOR + getDate().format(DATE_FORMATTER);
    }
}
