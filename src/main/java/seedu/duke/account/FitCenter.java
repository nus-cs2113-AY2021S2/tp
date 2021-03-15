package seedu.duke.account;

import seedu.duke.record.Record;
import seedu.duke.record.RecordList;
import seedu.duke.record.RecordType;

import java.time.LocalDate;

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

    public void addRecordToList(RecordType type, Record record) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.addRecord(record);
        }
    }

    public void removeRecordFromList(RecordType type, int index) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.removeRecord(index);
        }
    }

    public void printRecordList(RecordType type) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.printRecords();
        }
    }

    public void printRecordList(RecordType type, LocalDate date) {
        RecordList list = getRecordListByType(type);
        if (list != null) {
            list.printRecords(date);
        }
    }
}
