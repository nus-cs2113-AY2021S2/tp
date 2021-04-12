package seedu.duke.record;

import java.util.Locale;

public enum WorkoutCategory {
    WALKING(6),
    RUNNING(6.6),
    CYCLING(6.9),
    ELLIPTICAL(4.7),
    ROWER(7.3),
    STAIRSTEPPER(3.5),
    HIKING(8),
    HIIT(10.5),
    YOGA(5.2),
    DANCE(6.3),
    COOLDOWN(1.2),
    SWIMMING(9.3),
    CORETRAINING(2.4),
    INVALID(-1);
    private final double caloriePerMin;

    WorkoutCategory(double caloriePerMin) {
        this.caloriePerMin = caloriePerMin;
    }

    public double getCaloriePerMin() {
        return caloriePerMin;
    }

    public static String getValidWorkoutList() {
        StringBuilder workoutList = new StringBuilder();
        int i = 1;
        for (WorkoutCategory workoutCategory : WorkoutCategory.values()) {
            if (!workoutCategory.equals(INVALID)) {
                workoutList.append(i).append(". ").append(workoutCategory.toString().toLowerCase(Locale.ROOT))
                        .append("\n");
                i++;
            }
        }
        return workoutList.toString();
    }
}
