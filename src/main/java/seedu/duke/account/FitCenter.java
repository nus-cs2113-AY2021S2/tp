package seedu.duke.account;

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


    private RecordList getRecordListByType(RecordType type) {
        switch (type) {
        case SLEEP:
            return sleepRecordList;
        case EXERCISE:
            return exerciseRecordList;
        case DIET:
            return dietRecordList;
        case BODYWEIGHT:
            return bodyRecordList;
        default:
            return null;
        }
    }

    /**
     * Adds a given record to a list that stores the same type of records.
     *
     * @param record the record to add.
     */
    public void addRecordToList(Record record) {
        RecordType type = record.getType();
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.addRecord(record);
        }
    }

    /**
     * Removes a given record from a list that stores the same type of records.
     * Returns the summary of the deleted record.
     *
     * @param type  the type of the record.
     * @param index the index of the record in the list.
     */
    public String removeRecordFromList(RecordType type, int index) throws IndexOutOfBoundsException {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            return list.removeRecord(index);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Prints the list of record of a selected type.
     *
     * @param type the type of the record that the list stores.
     */
    public void printRecordList(RecordType type) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.printRecords();
        }
    }

    /**
     * Prints the list of record of a selected type on a specific date.
     *
     * @param type the type of the record that the list stores.
     * @param date the date of records.
     */
    public void printRecordList(RecordType type, LocalDate date) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.printRecords(date);
        }
    }
}
