package seedu.duke.record;

import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class RecordList {
    private ArrayList<Record> recordList;

    public RecordList() {
        recordList = new ArrayList<>();
    }

    public RecordList(ArrayList<Record> recordList) {
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

    public void listExpenses(Ui ui) {
        ui.printMessage("List expenses!");
    }

    public void listLoans(Ui ui) {
        ui.printMessage("List loans!");
    }

    public void listSavings(Ui ui) {
        ui.printMessage("List savings!");
    }
}
