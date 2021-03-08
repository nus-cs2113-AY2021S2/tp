package seedu.duke.record;

import java.util.ArrayList;

public class RecordHandler {
    private ArrayList<Record> recordList;

    public RecordHandler(ArrayList<Record> recordList) {
        this.recordList = recordList;
    }

    public void addRecord(Record recordToAdd) {
        recordList.add(recordToAdd);
    }

    public Record getRecordAt(int recordIndex) {
        return recordList.get(recordIndex);
    }

    public Record deleteRecordAt(int recordIndex) {
        return recordList.remove(recordIndex);
    }

    public void deleteAllRecords() {
        recordList.clear();
    }

    public int indexOfRecord(Record record) {
        return recordList.indexOf(record);
    }

    public boolean isEmpty() {
        return recordList.isEmpty();
    }

    public int getRecordCount() {
        return recordList.size();
    }
}
