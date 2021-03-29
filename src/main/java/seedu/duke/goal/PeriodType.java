package seedu.duke.goal;

public enum PeriodType {
    DAILY, WEEKLY, INVALID;

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

    public static PeriodType parsePeriodType(String rawPeriodType) {
        switch (rawPeriodType){
        case "D":
            return DAILY;
        case "W":
            return WEEKLY;
        default:
            return INVALID;
        }
    }
}
