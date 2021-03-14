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

    public String[] getSpecificEntry(int entryNumber) {
        String[] pathDetails = records.get(entryNumber - 1).split(";");
        int startingVenueIndex = 7;
        String from = pathDetails[0].substring(startingVenueIndex);
        int destinationVenueIndex = 5;
        String to = pathDetails[1].substring(destinationVenueIndex);
        return new String[] {from, to};
    }
}
