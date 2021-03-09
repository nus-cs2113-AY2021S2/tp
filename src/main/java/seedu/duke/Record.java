package seedu.duke;

import java.util.ArrayList;

public class Record {

    private ArrayList<String> records;

    public Record() {
        records = new ArrayList<String>();
    }

    public ArrayList<String> getRecords() {
        return records;
    }

    public void displayRecords() {
        /**
         * Lists out all the entries in records.
         */
        int i = 1;
        for (String record : records) {
            System.out.println(i + ". " + record);
            i++;
        }
    }

    public void addRecord(String recordDescription) {
        records.add(recordDescription);
    }
}
