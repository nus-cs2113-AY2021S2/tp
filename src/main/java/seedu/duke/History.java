package seedu.duke;

import seedu.duke.exception.RepeatEntryOutOfBoundException;

import java.util.ArrayList;

public class History {
    private static ArrayList<String> history;

    public History() {
        this.history = new ArrayList<>();
    }

    public ArrayList<String> getHistory() {
        assert history.size() != 0 : "There are no past searches made.";
        return history;
    }

    public int getTotalNoOfHistory() {
        return history.size();
    }

    public void addHistory(String recordDescription) {
        history.add(recordDescription);
    }

    public void addHistory(String from, String to) {
        String record = "START: " + from.toUpperCase() + "; TO: " + to.toUpperCase();
        history.add(record);
    }

    public void emptyHistory() {
        history.clear();
    }

    public String[] getSpecificEntry(int entryNumber) throws RepeatEntryOutOfBoundException {
        try {
            String[] pathDetails = history.get(entryNumber - 1).split(";");
            int startingVenueIndex = 7;
            String from = pathDetails[0].substring(startingVenueIndex);
            int destinationVenueIndex = 5;
            String to = pathDetails[1].substring(destinationVenueIndex);
            return new String[] {from, to};
        } catch (IndexOutOfBoundsException e) {
            throw new RepeatEntryOutOfBoundException();
        }
    }

    public String getHistoryAsString() {
        StringBuilder fullHistory = new StringBuilder();
        for (int i = 1; i - 1 < history.size(); i++) {
            fullHistory.append(i).append(". ").append(history.get(i - 1));
            fullHistory.append(System.lineSeparator());
        }
        return fullHistory.deleteCharAt(fullHistory.lastIndexOf(System.lineSeparator())).toString();
    }
}
