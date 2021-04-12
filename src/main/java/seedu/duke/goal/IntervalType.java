package seedu.duke.goal;

/**
 * Represents the different type of goal interval.
 */
public enum IntervalType {
    DAILY, WEEKLY, INVALID;

    /**
     * Gets the weight of the interval type for sorting goal list.
     *
     * @param intervalType the interval type of the goal.
     * @return the weight of the interval type for sorting goal list in integer.
     */
    public static int getIntervalTypeWeight(IntervalType intervalType) {
        switch (intervalType) {
        case DAILY:
            return 1;
        case WEEKLY:
            return 2;
        default:
            return 9999;
        }
    }

    /**
     * Parse a string that represents interval type in command into interval type.
     *
     * @param rawIntervalType a string that represents interval type in command.
     * @return parsed interval type.
     */
    public static IntervalType parseIntervalType(String rawIntervalType) {
        switch (rawIntervalType) {
        case "D":
            return DAILY;
        case "W":
            return WEEKLY;
        default:
            return INVALID;
        }
    }
}
