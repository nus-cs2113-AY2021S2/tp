package seedu.duke;

import java.util.ArrayList;

public class Record {

    private static ArrayList<String> records = new ArrayList();

    public Record() {
    }

    public ArrayList<String> getRecords() {
        return records;
    }

    public void displayRecords() {
        System.out.println("Number of records in your history: " + records.size());
        for (int i = 1; i - 1 < records.size(); i++) {
            System.out.println(i + ". " + records.get(i - 1));
        }
    }

    public void addRecord(String recordDescription) {
        records.add(recordDescription);
    }

    public void emptyRecords() {
        records.clear();
        System.out.println("Your history has been cleared.");
    }
}
