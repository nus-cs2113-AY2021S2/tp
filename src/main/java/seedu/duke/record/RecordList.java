package seedu.duke.record;

import seedu.duke.common.Messages;
import seedu.duke.record.comparator.RecordDateComparator;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents the list that contains all records of one type.
 */
public class RecordList {
    private final ArrayList<Record> records = new ArrayList<>();
    private RecordType type;

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
     *
     * @param index the index of the record.
     */
    public void removeRecord(int index) {
        records.remove(index);
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
            for (Record record : records) {
                recordStringBuilder.append(record.getRecordSummary()).append("\n");
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
            for (Record record : records) {
                if (record.getDate().isEqual(date)) {
                    recordStringBuilder.append(record.getRecordSummary()).append("\n");
                }
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
//                for (Exercise record : records) {
//                    if (record.getWorkOut().equals(optionalParam)) {
//                        recordStringBuilder.append(record.getRecordSummary()).append("\n");
//                    }
//                }
                return recordStringBuilder.toString();
            } else if (type.equals(RecordType.DIET)) {
//                for (Diet record : records) {
//                    if (record.getFood().equals(optionalParam)) {
//                        recordStringBuilder.append(record.getRecordSummary()).append("\n");
//                    }
//                }
                return recordStringBuilder.toString();
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
//                for (Exercise record : records) {
//                    if (record.getDate().isEqual(date) && record.getWorkOut().equals(optionalParam)) {
//                        recordStringBuilder.append(record.getRecordSummary()).append("\n");
//                    }
//                }
                return recordStringBuilder.toString();
            } else if (type.equals(RecordType.DIET)) {
//                for (Diet record : records) {
//                    if (record.getDate().isEqual(date) && record.getFood().equals(optionalParam)) {
//                        recordStringBuilder.append(record.getRecordSummary()).append("\n");
//                    }
//                }
                return recordStringBuilder.toString();
            } else {
                return Messages.MESSAGE_CANT_VIEW_LIST;
            }
        }
    }
}
