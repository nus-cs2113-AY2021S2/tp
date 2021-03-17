package seedu.duke.record;

import seedu.duke.common.Messages;
import seedu.duke.record.comparator.RecordDateComparator;
import seedu.duke.ui.UI;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents the list that contains all records of one type.
 */
public class RecordList {
    private final ArrayList<Record> records = new ArrayList<>();
    private RecordType type;

    /**
     * Initializes the record list object with a given record type.
     *
     * @param type the type of record that this list contains.
     */
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
     * Prints the list of records.
     */
    public void printRecords() {
        if (records.isEmpty()) {
            UI.printMessage(Messages.MESSAGE_NO_RECORD
                    + Messages.MESSAGE_SEE_HELP);
        } else {
            UI.printDivider();
            for (Record record : records) {
                System.out.println(record.getRecordSummary());
            }
            UI.printDivider();
        }
    }

    /**
     * Prints the list of records on a specific date.
     *
     * @param date the date of records.
     */
    public void printRecords(LocalDate date) {
        if (records.isEmpty()) {
            UI.printMessage(Messages.MESSAGE_NO_RECORD
                    + Messages.MESSAGE_SEE_HELP);
        } else {
            UI.printDivider();
            for (Record record : records) {
                if (record.getDate().isEqual(date)) {
                    System.out.println(record.getRecordSummary());
                }
            }
            UI.printDivider();
        }
    }
}
