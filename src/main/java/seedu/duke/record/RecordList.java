package seedu.duke.record;

import seedu.duke.common.Messages;
import seedu.duke.goal.timemanager.TimeController;
import seedu.duke.record.comparator.RecordDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;

import static seedu.duke.record.RecordType.EXERCISE;
import static seedu.duke.record.RecordType.SLEEP;


/**
 * Represents the list that contains all records of one type.
 */
public class RecordList {
    private final ArrayList<Record> records = new ArrayList<>();
    private final RecordType type;
    private int lengthOfIndex;
    private String separatorBetweenIndexAndContent;

    public RecordList(RecordType type) {
        this.type = type;
    }

    /**
     * Adds a record to the current list.
     *
     * @param newRecord the new record to add.
     */
    public void addRecord(Record newRecord) {
        records.add(newRecord);
        records.sort(new RecordDateComparator());
    }

    /**
     * Removes a record from the current list by index.
     * Return the summary of the deleted record.
     *
     * @param index the index of the record.
     */
    public String removeRecord(int index) {
        Record recordToRemove = records.get(index);
        String recordSummary = recordToRemove.getRecordSummary();
        records.remove(index);
        return recordSummary;
    }

    /**
     * Gets all records in a string.
     *
     * @return a string of all records.
     */
    public String getRecordsToPrint() {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            int i = 1;
            for (Record record : records) {
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                recordStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(record.getRecordData())
                        .append("\n");
                i++;
            }
            return recordStringBuilder.toString();
        }
    }

    /**
     * Gets all records with a given date in a string.
     *
     * @param date the date of the record.
     * @return a string of all records with a given date.
     */
    public String getRecordsToPrint(LocalDate date) {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            int i = 1;
            for (Record record : records) {
                if (record.getDate().isEqual(date)) {
                    lengthOfIndex = ("" + i).length();
                    switch (lengthOfIndex) {
                    case 1:
                        separatorBetweenIndexAndContent = "    ";
                        break;
                    case 2:
                        separatorBetweenIndexAndContent = "   ";
                        break;
                    case 3:
                        separatorBetweenIndexAndContent = "   ";
                        break;
                    default:
                        separatorBetweenIndexAndContent = " ";
                        break;
                    }
                    recordStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(record.getRecordData())
                            .append("\n");
                    i++;
                }
            }
            boolean hasRecord = recordStringBuilder.length() != 0;
            if (!hasRecord) {
                recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
            }
            return recordStringBuilder.toString();
        }
    }

    /**
     * Gets all records that match the pattern in the given parameter.
     *
     * @param optionalParam an optional parameter for filtering the records.
     * @return a string of all records that match the pattern in the given parameter.
     */
    public String getRecordsToPrint(String optionalParam) {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            if (type.equals(RecordType.EXERCISE)) {
                return getExerciseRecordString(optionalParam, recordStringBuilder);
            } else if (type.equals(RecordType.DIET)) {
                return getDietRecordString(optionalParam, recordStringBuilder);
            } else {
                return Messages.MESSAGE_CANT_VIEW_LIST;
            }
        }
    }

    /**
     * Gets all records that match the pattern in the given parameter on a given date.
     *
     * @param date          the date of the record.
     * @param optionalParam an optional parameter for filtering the records.
     * @return a string of all records that match the pattern in the given parameter on a given date.
     */
    public String getRecordsToPrint(LocalDate date, String optionalParam) {
        if (records.isEmpty()) {
            return Messages.MESSAGE_NO_RECORD;
        } else {
            StringBuilder recordStringBuilder = new StringBuilder();
            if (type.equals(RecordType.EXERCISE)) {
                return getExerciseRecordString(date, optionalParam, recordStringBuilder);
            } else if (type.equals(RecordType.DIET)) {
                return getDietRecordString(date, optionalParam, recordStringBuilder);
            } else {
                return Messages.MESSAGE_CANT_VIEW_LIST;
            }
        }
    }

    public double getDailyTime(LocalDate recordDate) {
        if (type == SLEEP) {
            return getDailySleepTime(recordDate);
        }
        if (type == EXERCISE) {
            return getDailyExerciseTime(recordDate);
        }
        return 0;
    }

    /**
     * Calculates progress based on all records on a specified date.
     *
     * @param currentDate the specified date.
     * @return the cumulative value or latest value.
     */
    public double getDailyProgress(LocalDate currentDate) {
        switch (type) {
        case EXERCISE:
            return getExerciseProgress(currentDate);
        case DIET:
            return getDietProgress(currentDate);
        case SLEEP:
            return getSleepProgress(currentDate);
        case BODYWEIGHT:
            return getBodyWeightProgress();
        default:
            return 0;
        }
    }

    /**
     * Calculates progress based on all records in a specified week.
     *
     * @param currentWeekOfYear the specified week.
     * @return the cumulative value or latest value.
     */
    public double getWeeklyProgress(int currentWeekOfYear) {
        switch (type) {
        case EXERCISE:
            return getExerciseProgress(currentWeekOfYear);
        case DIET:
            return getDietProgress(currentWeekOfYear);
        case SLEEP:
            return getSleepProgress(currentWeekOfYear);
        case BODYWEIGHT:
            return getBodyWeightProgress();
        default:
            return 0;
        }
    }

    private double getDailyExerciseTime(LocalDate recordDate) {
        double dailyExerciseTime = 0;
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            if (exercise.getDate().isEqual(recordDate)) {
                dailyExerciseTime += exercise.getDuration();
            }
        }
        return dailyExerciseTime;
    }

    private double getDailySleepTime(LocalDate recordDate) {
        double dailySleepTime = 0;
        for (Record record : records) {
            Sleep sleep = (Sleep) record;
            if (sleep.getDate().isEqual(recordDate)) {
                dailySleepTime += sleep.getDuration();
            }
        }
        return dailySleepTime;
    }

    private double getDietProgress(LocalDate currentDate) {
        double totalCalories = 0;
        for (Record record : records) {
            Diet diet = (Diet) record;
            if (diet.getDate().isEqual(currentDate)) {
                totalCalories += diet.getCalorie();
            }
        }
        return totalCalories;
    }

    private double getDietProgress(int weekOfYear) {
        double totalCalories = 0;
        for (Record record : records) {
            Diet diet = (Diet) record;
            if (TimeController.isDateInWeek(diet.getDate(), weekOfYear)) {
                totalCalories += diet.getCalorie();
            }
        }
        return totalCalories;
    }

    private double getExerciseProgress(LocalDate currentDate) {
        double totalCalories = 0;
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            if (exercise.getDate().isEqual(currentDate)) {
                totalCalories += exercise.getCalories();
            }
        }
        return totalCalories;
    }

    private double getExerciseProgress(int weekOfYear) {
        double totalCalories = 0;
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            if (TimeController.isDateInWeek(exercise.getDate(), weekOfYear)) {
                totalCalories += exercise.getCalories();
            }
        }
        return totalCalories;
    }

    private double getSleepProgress(LocalDate currentDate) {
        double totalHours = 0;
        for (Record record : records) {
            Sleep sleep = (Sleep) record;
            if (sleep.getDate().isEqual(currentDate)) {
                totalHours += sleep.getDuration();
            }
        }
        return totalHours;
    }

    private double getSleepProgress(int weekOfYear) {
        double totalHours = 0;
        for (Record record : records) {
            Sleep sleep = (Sleep) record;
            if (TimeController.isDateInWeek(sleep.getDate(), weekOfYear)) {
                totalHours += sleep.getDuration();
            }
        }
        return totalHours;
    }

    private double getBodyWeightProgress() {
        if (records.size() == 0) {
            return -1;
        }
        BodyWeight latestBodyWeightRecord = (BodyWeight) records.get(records.size() - 1);
        return latestBodyWeightRecord.getWeight();
    }

    private FoodCategory parseStringToFoodCategory(String optionalParam) throws IllegalArgumentException {
        return FoodCategory.valueOf(optionalParam.toUpperCase());
    }

    private WorkoutCategory parseStringToWorkoutCategory(String optionalParam) throws IllegalArgumentException {
        return WorkoutCategory.valueOf(optionalParam.toUpperCase());
    }

    private String getDietRecordString(String optionalParam, StringBuilder recordStringBuilder) {
        int i = 1;
        for (Record record : records) {
            Diet diet = (Diet) record;
            FoodCategory paramCategory = getFoodCategory(optionalParam);
            if (diet.getFoodCategory().equals(paramCategory)) {
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                recordStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(record.getRecordData())
                        .append("\n");
                i++;
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private String getDietRecordString(LocalDate date, String optionalParam, StringBuilder recordStringBuilder) {
        int i = 1;
        for (Record record : records) {
            Diet diet = (Diet) record;
            FoodCategory paramCategory = getFoodCategory(optionalParam);
            if (diet.getDate().isEqual(date) && diet.getFoodCategory().equals(paramCategory)) {
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                recordStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(record.getRecordData())
                        .append("\n");
                i++;
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private String getExerciseRecordString(String optionalParam, StringBuilder recordStringBuilder) {
        int i = 1;
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            WorkoutCategory paramCategory = getWorkOutCategory(optionalParam);
            if (exercise.getWorkoutCategory().equals(paramCategory)) {
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                recordStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(record.getRecordData())
                        .append("\n");
                i++;
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private String getExerciseRecordString(LocalDate date, String optionalParam, StringBuilder recordStringBuilder) {
        int i = 1;
        for (Record record : records) {
            Exercise exercise = (Exercise) record;
            WorkoutCategory paramCategory = getWorkOutCategory(optionalParam);
            if (exercise.getDate().isEqual(date) && exercise.getWorkoutCategory().equals(paramCategory)) {
                lengthOfIndex = ("" + i).length();
                switch (lengthOfIndex) {
                case 1:
                    separatorBetweenIndexAndContent = "    ";
                    break;
                case 2:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                case 3:
                    separatorBetweenIndexAndContent = "   ";
                    break;
                default:
                    separatorBetweenIndexAndContent = " ";
                    break;
                }
                recordStringBuilder.append(i).append(separatorBetweenIndexAndContent).append(record.getRecordData())
                        .append("\n");
                i++;
            }
        }
        boolean hasRecord = recordStringBuilder.length() != 0;
        if (!hasRecord) {
            recordStringBuilder.append(Messages.MESSAGE_NO_RECORD);
        }
        return recordStringBuilder.toString();
    }

    private FoodCategory getFoodCategory(String optionalParam) {
        FoodCategory paramCategory;
        try {
            paramCategory = parseStringToFoodCategory(optionalParam);
        } catch (IllegalArgumentException e) {
            paramCategory = FoodCategory.INVALID;
        }
        return paramCategory;
    }

    private WorkoutCategory getWorkOutCategory(String optionalParam) {
        WorkoutCategory paramCategory;
        try {
            paramCategory = parseStringToWorkoutCategory(optionalParam);
        } catch (IllegalArgumentException e) {
            paramCategory = WorkoutCategory.INVALID;
        }
        return paramCategory;
    }

    public String getRecordToStore() {
        StringBuilder recordStringBuilder = new StringBuilder();
        for (Record record : records) {
            recordStringBuilder.append(record.getRecordDataToStore()).append("\n");
        }
        return recordStringBuilder.toString();
    }
}
