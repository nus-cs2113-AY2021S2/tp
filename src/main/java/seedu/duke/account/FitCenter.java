package seedu.duke.account;

import seedu.duke.command.CommandRecordType;
import seedu.duke.common.Messages;
import seedu.duke.goal.GoalList;
import seedu.duke.goal.Goal;
import seedu.duke.goal.PeriodType;
import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.record.RecordType;


import java.time.LocalDate;

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
     * Adds a given record to a list that stores the same type of records.
     *
     * @param type   the type of the record.
     * @param record the record to add.
     */
    public void addRecordToList(CommandRecordType type, Record record) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
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
        GoalList list = getGoalListByType(type);
        if (list != null) {
            list.addGoal(goal);
        }
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

    public String cancelGoalFromList(CommandRecordType type, int index) throws IndexOutOfBoundsException {
        GoalList list = getGoalListByType(type);
        if (list != null) {
            return list.removeGoal(index);
        }
        return Messages.MESSAGE_CANT_CANCEL_GOAL;
    }

    /**
     * Prints the list of record of a selected type.
     *
     * @param type the type of the record that the list stores.
     */
    public String getRecordListString(CommandRecordType type) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint();
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    /**
     * Prints the list of record of a selected type on a specific date.
     *
     * @param type the type of the record that the list stores.
     * @param date the date of records.
     */
    public String getRecordListString(CommandRecordType type, LocalDate date) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(date);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    public String getRecordListString(CommandRecordType type, String optionalParam) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(optionalParam);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    public String getRecordListString(CommandRecordType type, LocalDate date, String optionalParam) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.getRecordsToPrint(date, optionalParam);
        }
        return Messages.MESSAGE_CANT_VIEW_LIST;
    }

    public String getGoalListString(CommandRecordType type, PeriodType optionalPeriodType) {
        GoalList list = getGoalListByType(type);
        if (list != null) {
            return list.getGoalsToPrint(optionalPeriodType);
        }
        return Messages.MESSAGE_CANT_CHECK_GOAL;
    }

    public String getRecordListForStore() {
        return exerciseRecordList.getRecordToStore()
                + dietRecordList.getRecordToStore()
                + sleepRecordList.getRecordToStore()
                + bodyRecordList.getRecordToStore();
    }

    public String getGoalListForStore() {
        return exerciseGoalList.getGoalToStore()
                + dietGoalList.getGoalToStore()
                + sleepGoalList.getGoalToStore()
                + bodyWeightGoalList.getGoalToStore();
    }

    public double getProgress(CommandRecordType type, LocalDate currentDate) {
        switch (type) {
        case EXERCISE:
            return exerciseRecordList.getProgress(currentDate);
        case DIET:
            return dietRecordList.getProgress(currentDate);
        case SLEEP:
            return sleepRecordList.getProgress(currentDate);
        default:
            return 0;
        }
    }
}
