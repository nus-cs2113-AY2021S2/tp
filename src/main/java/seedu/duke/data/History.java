//@@author Rye98

package seedu.duke.data;

import seedu.duke.exception.InvalidIndexException;

import java.util.LinkedList;

public class History {
    private LinkedList<String[]> history;
    private final int maximumNoOfHistory = 10;

    public History() {
        this.history = new LinkedList<>();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }

    public boolean isFull() {
        return history.size() == maximumNoOfHistory;
    }

    public int getHistorySize() {
        return history.size();
    }

    public void addHistory(String start, String destination) {
        if (isFull()) {
            history.remove();
        }
        history.add(new String[]{start, destination});
    }

    public String[] getSpecificEntry(int index) throws InvalidIndexException {
        try {
            return history.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidIndexException();
        }
    }

    public void clearHistory() {
        history.clear();
    }
}

