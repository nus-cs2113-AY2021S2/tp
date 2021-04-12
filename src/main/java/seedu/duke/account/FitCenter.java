package seedu.duke.account;

import seedu.duke.command.CommandRecordType;
import seedu.duke.common.Messages;
import seedu.duke.exception.ExceedTimeInOneDayException;
import seedu.duke.goal.GoalList;
import seedu.duke.goal.Goal;
import seedu.duke.goal.IntervalType;
import seedu.duke.goal.timemanager.TimeController;
import seedu.duke.record.RecordList;
import seedu.duke.record.RecordType;
import seedu.duke.record.Record;
import seedu.duke.record.Exercise;
import seedu.duke.record.Sleep;

import seedu.duke.ui.UI;


import java.time.LocalDate;

import static seedu.duke.command.CommandRecordType.EXERCISE;
import static seedu.duke.command.CommandRecordType.DIET;
import static seedu.duke.command.CommandRecordType.SLEEP;
import static seedu.duke.command.CommandRecordType.BODY_WEIGHT;
import static seedu.duke.goal.IntervalType.DAILY;
import static seedu.duke.goal.IntervalType.WEEKLY;

/**
 * Manages the fitness of a user through list of records.
 */
public class FitCenter {
    private final RecordList sleepRecordList = new RecordList(RecordType.SLEEP);
    private final RecordList exerciseRecordList = new RecordList(RecordType.EXERCISE);
    private final RecordList dietRecordList = new RecordList(RecordType.DIET);
    private final RecordList bodyRecordList = new RecordList(RecordType.BODYWEIGHT);
    private final GoalList exerciseGoalList = new GoalList();
    private final GoalList dietGoalList = new GoalList();
    private final GoalList sleepGoalList = new GoalList();
    private final GoalList bodyWeightGoalList = new GoalList();

    private RecordList getRecordListByType(CommandRecordType type) {
        switch (type) {
        case SLEEP:
            return sleepRecordList;
        case EXERCISE:
            return exerciseRecordList;
        case DIET:
            return dietRecordList;
        case BODY_WEIGHT:
            return bodyRecordList;
        default:
            return null;
        }
    }

    private GoalList getGoalListByType(CommandRecordType type) {
        switch (type) {
        case SLEEP:
            return sleepGoalList;
        case EXERCISE:
            return exerciseGoalList;
        case DIET:
            return dietGoalList;
        case BODY_WEIGHT:
            return bodyWeightGoalList;
        default:
            return null;
        }
    }

    /**
     * Resets the progress for goals of a given interval type (daily/weekly).
     *
     * @param intervalType the interval type of the goals (daily/weekly).
     */
    public void resetGoalProgress(IntervalType intervalType) {
        exerciseGoalList.initializeGoalProgress(intervalType);
        dietGoalList.initializeGoalProgress(intervalType);
        sleepGoalList.initializeGoalProgress(intervalType);
        bodyWeightGoalList.initializeGoalProgress(intervalType);
    }

    /**
     * Adds a given record to a list that stores the same type of records.
     *
     * @param type   the type of the record.
     * @param record the record to add.
     */
    public void addRecordToList(CommandRecordType type, Record record) throws ExceedTimeInOneDayException {
        RecordList list = getRecordListByType(type);
        double timeSpentDaily = 0;
        if (type == SLEEP || type == EXERCISE) {
            timeSpentDaily = exerciseRecordList.getDailyTime(record.getDate()) / 60.0
                    + sleepRecordList.getDailyTime(record.getDate());
            if (type == EXERCISE) {
                Exercise exercise = (Exercise) record;
                timeSpentDaily += exercise.getDuration() / 60.0;
            } else {
                Sleep sleep = (Sleep) record;
                timeSpentDaily += sleep.getDuration();
            }
        }
        if (list != null) {
            if (timeSpentDaily >= 24) {
                throw new ExceedTimeInOneDayException();
            }
            list.addRecord(record);
        }
    }

    /**
     * Adds a given goal to a list that stores the same type of goals.
     *
     * @param type the type of the goal.
     * @param goal the goal to add.
     */
    public void addGoalToList(CommandRecordType type, Goal goal) {
        double progress;
        LocalDate currentDate = goal.getDaySet();
        GoalList list = getGoalListByType(type);
        if (list != null) {
            list.addGoal(goal);
        }
        switch (type) {
        case EXERCISE:
            progress = exerciseRecordList.getDailyProgress(currentDate);
            break;
        case DIET:
            progress = dietRecordList.getDailyProgress(currentDate);
            break;
        case BODY_WEIGHT:
            progress = bodyRecordList.getDailyProgress(currentDate);
            break;
        case SLEEP:
            progress = sleepRecordList.getDailyProgress(currentDate);
            break;
        default:
            return;
        }
        goal.setProgress(progress);
    }

    /**
     * Removes a record from a record list by index.
     *
     * @param type  the type of the record.
     * @param index the index of the record in the list.
     * @return a summary of the record removed.
     * @throws IndexOutOfBoundsException when the index input is out of range.
     */
    public String removeRecordFromList(CommandRecordType type, int index) throws IndexOutOfBoundsException {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.removeRecord(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Cancels a goal and remove it from a goal list by index.
     *
     * @param type  the type of the goal.
     * @param index the index of the goal in the goal list.
     * @return a summary of the goal canceled.
     * @throws IndexOutOfBoundsException when the index input is out of range.
     */
    public String cancelGoalFromList(CommandRecordType type, int index) throws IndexOutOfBoundsException {
        GoalList list = getGoalListByType(type);
        if (list != null) {
            return list.removeGoal(index);
        }
        return Messages.MESSAGE_CANT_CANCEL_GOAL;
    }

    /**
     * Gets a printable string of the list of record of a selected type.
     *
     * @param type the type of the record that the list stores.
     * @return a printable string of the list of record of a selected type.
     */
    public String getRecordListString(CommandRecordType type) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint();
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    /**
     * Gets a printable string of the list of record of a selected type on a specific date.
     *
     * @param type the type of the record that the list stores.
     * @param date the date of records.
     * @return a printable string of the list of record of a selected type on a specific date.
     */
    public String getRecordListString(CommandRecordType type, LocalDate date) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(date);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    /**
     * Gets a printable string of the list of record of a selected type filtered by optional parameters.
     *
     * @param type          the type of the record that the list stores.
     * @param optionalParam optional parameters that can filter the list of record.
     * @return a printable string of the list of record of a selected type filtered by optional parameters.
     */
    public String getRecordListString(CommandRecordType type, String optionalParam) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(optionalParam);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    /**
     * Gets a printable string of the list of record of a selected type on a specific date and
     * filtered by optional parameters.
     *
     * @param type          the type of the record that the list stores.
     * @param date          the date of records.
     * @param optionalParam optional parameters that can filter the list of record.
     * @return a printable string of the list of record of a selected type on a specific date and
     *     filtered by optional parameters.
     */
    public String getRecordListString(CommandRecordType type, LocalDate date, String optionalParam) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(date, optionalParam);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    /**
     * Gets a printable string of the list of goals of a selected type and can be filtered by a optional interval type.
     *
     * @param type                 the type of the goals.
     * @param optionalIntervalType an optional interval type that filter the list of goals.
     * @return a printable string of the list of goals of a selected type and can be filtered
     *     by a optional interval type.
     */
    public String getGoalListString(CommandRecordType type, IntervalType optionalIntervalType) {
        GoalList list = getGoalListByType(type);
        if (list != null) {
            return list.getGoalsToPrint(optionalIntervalType);
        }
        return Messages.MESSAGE_CANT_CHECK_GOAL;
    }

    private boolean isGoalAchieved(IntervalType intervalType) {
        int notAchievedCount = 0;
        if (dietGoalList.isNotEmpty()) {
            if (!dietGoalList.isGoalAchieved(intervalType)) {
                notAchievedCount++;
            }
        }
        if (exerciseGoalList.isNotEmpty()) {
            if (!exerciseGoalList.isGoalAchieved(intervalType)) {
                notAchievedCount++;
            }
        }
        if (sleepGoalList.isNotEmpty()) {
            if (!sleepGoalList.isGoalAchieved(intervalType)) {
                notAchievedCount++;
            }
        }
        if (bodyWeightGoalList.isNotEmpty()) {
            if (!bodyWeightGoalList.isGoalAchieved(intervalType)) {
                notAchievedCount++;
            }
        }
        return notAchievedCount == 0;
    }

    private boolean hasGoals() {
        return dietGoalList.isNotEmpty() || exerciseGoalList.isNotEmpty()
                || sleepGoalList.isNotEmpty() || bodyWeightGoalList.isNotEmpty();
    }

    private boolean hasGoals(IntervalType intervalType) {
        return dietGoalList.isNotEmpty(intervalType) || exerciseGoalList.isNotEmpty(intervalType)
                || sleepGoalList.isNotEmpty(intervalType) || bodyWeightGoalList.isNotEmpty(intervalType);
    }

    /**
     * Gets a printable string of unachieved list of goals when the app starts.
     *
     * @return a printable string of unachieved list of goals when the app starts.
     */
    public String getUnachievedGoalListStringAtLoading() {
        if (hasGoals()) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!isGoalAchieved(DAILY) || !isGoalAchieved(WEEKLY)) {
                stringBuilder.append(Messages.MESSAGE_UNACHIEVED_GOALS);
            }
            if (hasGoals(DAILY)) {
                if (isGoalAchieved(DAILY)) {
                    stringBuilder.append(Messages.MESSAGE_GOALS_DONE_TODAY);
                } else {
                    stringBuilder.append("Here are the unachieved daily goals:\n");
                    getUnachievedGoalsString(stringBuilder, DAILY);
                }
            }
            if (hasGoals(WEEKLY)) {
                if (isGoalAchieved(WEEKLY)) {
                    stringBuilder.append(Messages.MESSAGE_GOALS_DONE_THIS_WEEK);
                } else {
                    stringBuilder.append("Here are the unachieved weekly goals:\n");
                    getUnachievedGoalsString(stringBuilder, WEEKLY);
                }
            }
            return stringBuilder.toString();
        }
        return null;
    }

    private void getUnachievedGoalsString(StringBuilder stringBuilder, IntervalType intervalType) {
        if (dietGoalList.isNotEmpty() && !dietGoalList.isGoalAchieved(intervalType)) {
            stringBuilder.append("Diet Goals\n");
            stringBuilder.append(getGoalListString(DIET, intervalType));
        }
        if (exerciseGoalList.isNotEmpty() && !exerciseGoalList.isGoalAchieved(intervalType)) {
            stringBuilder.append("Exercise Goals\n");
            stringBuilder.append(getGoalListString(EXERCISE, intervalType));
        }
        if (sleepGoalList.isNotEmpty() && !sleepGoalList.isGoalAchieved(intervalType)) {
            stringBuilder.append("Sleep Goals\n");
            stringBuilder.append(getGoalListString(SLEEP, intervalType));
        }
        if (bodyWeightGoalList.isNotEmpty() && !bodyWeightGoalList.isGoalAchieved(intervalType)) {
            stringBuilder.append("Body Weight Goals\n");
            stringBuilder.append(getGoalListString(BODY_WEIGHT, intervalType));
        }
    }

    /**
     * Gets a string of record lists in a format that can be stored into a text file.
     *
     * @return a string of record lists in a format that can be stored into a text file.
     */
    public String getRecordListForStore() {
        return exerciseRecordList.getRecordToStore()
                + dietRecordList.getRecordToStore()
                + sleepRecordList.getRecordToStore()
                + bodyRecordList.getRecordToStore();
    }

    /**
     * Gets a string of goal lists in a format that can be stored into a text file.
     *
     * @return a string of goal lists in a format that can be stored into a text file.
     */
    public String getGoalListForStore() {
        return exerciseGoalList.getGoalToStore()
                + dietGoalList.getGoalToStore()
                + sleepGoalList.getGoalToStore()
                + bodyWeightGoalList.getGoalToStore();
    }

    private void initDailyProgressAtLoading(LocalDate currentDate) {
        dietGoalList.updateProgress(DAILY, dietRecordList.getDailyProgress(currentDate));
        exerciseGoalList.updateProgress(DAILY, exerciseRecordList.getDailyProgress(currentDate));
        sleepGoalList.updateProgress(DAILY, sleepRecordList.getDailyProgress(currentDate));
        bodyWeightGoalList.updateProgress(DAILY, bodyRecordList.getDailyProgress(currentDate));
    }

    private void initWeeklyProgressAtLoading(int weekOfYear) {
        dietGoalList.updateProgress(WEEKLY, dietRecordList.getWeeklyProgress(weekOfYear));
        exerciseGoalList.updateProgress(WEEKLY, exerciseRecordList.getWeeklyProgress(weekOfYear));
        sleepGoalList.updateProgress(WEEKLY, sleepRecordList.getWeeklyProgress(weekOfYear));
        bodyWeightGoalList.updateProgress(WEEKLY, bodyRecordList.getWeeklyProgress(weekOfYear));
    }

    /**
     * Initialize the progress of goals read from files when the app starts.
     *
     * @param currentDate the date when the app runs.
     * @param weekOfYear  the week of year when the app runs.
     */
    public void initProgressAtLoading(LocalDate currentDate, int weekOfYear) {
        initDailyProgressAtLoading(currentDate);
        initWeeklyProgressAtLoading(weekOfYear);
    }

    private void updateDailyProgressAtAdding(Record record, LocalDate currentDate) {
        if (!record.getDate().isEqual(currentDate)) {
            return;
        }
        RecordType type = record.getType();
        switch (type) {
        case EXERCISE:
            exerciseGoalList.updateProgress(DAILY, exerciseRecordList.getDailyProgress(currentDate));
            break;
        case DIET:
            dietGoalList.updateProgress(DAILY, dietRecordList.getDailyProgress(currentDate));
            break;
        case SLEEP:
            sleepGoalList.updateProgress(DAILY, sleepRecordList.getDailyProgress(currentDate));
            break;
        case BODYWEIGHT:
            bodyWeightGoalList.updateProgress(DAILY, bodyRecordList.getDailyProgress(currentDate));
            break;
        default:
        }
    }

    private void updateWeeklyProgressAtAdding(Record record, int currentWeekOfYear) {
        if (!TimeController.isDateInWeek(record.getDate(), currentWeekOfYear)) {
            return;
        }
        RecordType type = record.getType();
        switch (type) {
        case EXERCISE:
            exerciseGoalList.updateProgress(WEEKLY, exerciseRecordList.getWeeklyProgress(currentWeekOfYear));
            break;
        case DIET:
            dietGoalList.updateProgress(WEEKLY, dietRecordList.getWeeklyProgress(currentWeekOfYear));
            break;
        case SLEEP:
            sleepGoalList.updateProgress(WEEKLY, sleepRecordList.getWeeklyProgress(currentWeekOfYear));
            break;
        case BODYWEIGHT:
            bodyWeightGoalList.updateProgress(WEEKLY, bodyRecordList.getWeeklyProgress(currentWeekOfYear));
            break;
        default:
        }
    }

    /**
     * Updates corresponding progress of goals when new records are added.
     *
     * @param record            the records to be added.
     * @param currentDate       the date when the app runs.
     * @param currentWeekOfYear the week of year when the app runs.
     */
    public void updateProgressAtAdding(Record record, LocalDate currentDate, int currentWeekOfYear) {
        updateDailyProgressAtAdding(record, currentDate);
        updateWeeklyProgressAtAdding(record, currentWeekOfYear);
    }

    /**
     * Prints the progress of goals when the app starts.
     */
    public void showGoalProgress() {
        String progressMessage = getUnachievedGoalListStringAtLoading();
        if (progressMessage != null) {
            UI.printMessage(getUnachievedGoalListStringAtLoading());
        }
    }
}
