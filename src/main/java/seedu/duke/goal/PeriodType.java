package seedu.duke.goal;

/**
 * Represents the different type of period.
 */
public enum PeriodType {
    DAILY, WEEKLY, INVALID;

    /**
     * Gets the weight of the period type for sorting goal list.
     *
     * @param periodType the period type of the goal.
     * @return the weight of the period type for sorting goal list in integer.
     */
    public static int getPeriodTypeWeight(PeriodType periodType) {
        switch (periodType) {
        case DAILY:
            return 1;
        case WEEKLY:
            return 2;
        default:
            return 9999;
        }
    }

    /**
     * Parse a string that represents period type in command into period type.
     *
     * @param rawPeriodType a string that represents period type in command.
     * @return parsed period type.
     */
    public static PeriodType parsePeriodType(String rawPeriodType) {
        switch (rawPeriodType) {
        case "D":
            return DAILY;
        case "W":
            return WEEKLY;
        default:
            return INVALID;
        }
    }
}
