package seedu.duke;

import java.util.ArrayList;

public class History {
    private static ArrayList<String> history = new ArrayList();

    public History() {
    }

    public ArrayList<String> getRecords() {
        return history;
    }

    public void displayRecords() {
        System.out.println("Number of records in your history: " + history.size());
        for (int i = 1; i - 1 < history.size(); i++) {
            System.out.println(i + ". " + history.get(i - 1));
        }
    }

    public void addRecord(String recordDescription) {
        history.add(recordDescription);
    }
    public void addRecord(String from, String to) {
        String record = "START: " + from.toUpperCase() + "; TO: " + to.toUpperCase();
        history.add(record);
    }

    public void emptyRecords() {
        history.clear();
        System.out.println("Your history has been cleared.");
    }

    public String[] getSpecificEntry(int entryNumber) {
        String[] pathDetails = history.get(entryNumber - 1).split(";");
        int startingVenueIndex = 7;
        String from = pathDetails[0].substring(startingVenueIndex);
        int destinationVenueIndex = 5;
        String to = pathDetails[1].substring(destinationVenueIndex);
        return new String[] {from, to};
    }
}
