package seedu.duke.record;

import java.util.ArrayList;

/**
 * Maintains a list of records provided by the user, and handles operations relating to the list.
 */
public class RecordList {
    private ArrayList<Record> recordList;

    /**
     * Constructs an empty record list.
     */
    public RecordList() {
        this(new ArrayList<Record>());
    }

    /**
     * Constructs a record list with records loaded from the save file.
     * @param recordListData contains the list of records loaded from the save file.
     */
    public RecordList(ArrayList<Record> recordListData) {
        this.recordList = recordListData;
    }

    /**
     * Adds a record to the list.
     * @param recordToAdd record to add to the end of the list.
     */
    public void addRecord(Record recordToAdd) {
        recordList.add(recordToAdd);
    }

    /**
     * Get the record at the specified index.
     * @param recordIndex index of record to retrieve.
     * @return record at the specified index.
     */
    public Record getRecordAt(int recordIndex) {
        return recordList.get(recordIndex);
    }

    /**
     * Deletes the record at the specified index.
     * @param recordIndex index of record to delete.
     * @return the deleted record.
     */
    public Record deleteRecordAt(int recordIndex) {
        return recordList.remove(recordIndex);
    }

    /**
     * Deletes all records in the list.
     */
    public void deleteAllRecords() {
        recordList.clear();
    }

    /**
     * Indicates if the list is empty.
     * @return a boolean indicating if the list is empty.
     */
    public boolean isEmpty() {
        return recordList.isEmpty();
    }

    /**
     * Return the number of records that are currently stored in the list.
     * @return current total records count.
     */
    public int getRecordCount() {
        return recordList.size();
    }
}
