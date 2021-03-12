package seedu.duke.record;

import java.util.ArrayList;

public class RecordList {
    private ArrayList<Record> recordList;

    public RecordList() {
        this(new ArrayList<Record>());
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

    public boolean isEmpty() {
        return recordList.isEmpty();
    }

    public int getRecordCount() {
        return recordList.size();
    }
<<<<<<< HEAD

    public void listExpenses(Ui ui) {
        ui.printMessage("List expenses!");
        for (Record r : recordList) {
            System.out.println(r.getDescription());
        }
    }

    public void listLoans(Ui ui) {
        ui.printMessage("List loans!");
    }

    public void listSavings(Ui ui) {
        ui.printMessage("List savings!");
    }
=======
>>>>>>> master
}
