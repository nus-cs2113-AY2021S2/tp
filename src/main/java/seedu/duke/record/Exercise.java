package seedu.duke.record;

import seedu.duke.exception.TypeException;

import java.time.LocalDate;

import static seedu.duke.common.Messages.HEADER_FOR_EXERCISE_RECORD_ACTIVITY;
import static seedu.duke.common.Messages.HEADER_FOR_EXERCISE_RECORD_DURATION;
import static seedu.duke.record.WorkoutCategory.INVALID;

public class Exercise extends Record {
    private static final int SPACES_FOR_ACTIVITY = HEADER_FOR_EXERCISE_RECORD_ACTIVITY.length();
    private static final int SPACES_FOR_DURATION = HEADER_FOR_EXERCISE_RECORD_DURATION.length();
    private double calories;
    private final WorkoutCategory workoutCategory;
    private final double duration;
    private String separatorBetweenActivityAndDuration;
    private String separatorBetweenDurationAndCalorie;
    private int lengthOfActivity;
    private int lengthOfDuration;

    public Exercise(String activityStr, String durationStr, LocalDate date) throws TypeException,
            NumberFormatException {
        super(RecordType.EXERCISE, date);
        try {
            workoutCategory = WorkoutCategory.valueOf(activityStr.toUpperCase());
            if (workoutCategory == INVALID) {
                throw new IllegalArgumentException();
            }
            this.duration = Double.parseDouble(durationStr);
            if (duration <= 0 || duration >= 1440) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Exercise time invalid");
        } catch (IllegalArgumentException e) {
            throw new TypeException("workout type exception");
        }
        this.calories = duration * workoutCategory.getCaloriePerMin();
        lengthOfActivity = workoutCategory.toString().length();
        lengthOfDuration = getDurationLength();
        setSeparators();
    }


    public double getCalories() {
        return calories;
    }

    public WorkoutCategory getWorkoutCategory() {
        return workoutCategory;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String getRecordSummary() {
        return getDuration() + " " + getUnit() + " of "
                + getWorkoutCategory() + " exercise on " + getDate().format(DATE_FORMATTER);
    }

    @Override
    public String getRecordData() {
        return SEPARATOR_TAB + SEPARATOR_TAB + getDate().format(DATE_FORMATTER)
                + SEPARATOR_TAB + getWorkoutCategory()
                + separatorBetweenActivityAndDuration + getDuration() + " " + getUnit()
                + separatorBetweenDurationAndCalorie + getCalories() + " " + getCaloriesUnit();
    }

    @Override
    public String getRecordDataToStore() {
        return "E" + SEPARATOR + workoutCategory + SEPARATOR + duration + SEPARATOR + getDate().format(DATE_FORMATTER);
    }

    private String getUnit() {
        return "minute(s)";
    }

    private String getCaloriesUnit() {
        return "Kcal";
    }

    private int getDurationLength() {
        int length = ("" + duration).length();
        return ("" + duration).length() + getUnit().length() + 1;
    }

    private void setSeparators() {
        setSeparatorBetweenActivityAndDuration();
        setSeparatorBetweenDurationAndCalorie();
    }

    private void setSeparatorBetweenActivityAndDuration() {
        separatorBetweenActivityAndDuration = "";
        for (int i = 0; i < SPACES_FOR_ACTIVITY - lengthOfActivity; i++) {
            separatorBetweenActivityAndDuration += " ";
        }
    }

    private void setSeparatorBetweenDurationAndCalorie() {
        separatorBetweenDurationAndCalorie = "";
        for (int i = 0; i < SPACES_FOR_DURATION - lengthOfDuration; i++) {
            separatorBetweenDurationAndCalorie += " ";
        }
    }
}
