//@@author Rye98

package seedu.duke.data;

import seedu.duke.exception.InvalidBlockException;
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

    public void addHistory(String start, String destination) throws InvalidBlockException {
        if (!isValidBlock(start) | !isValidBlock(destination)) {
            throw new InvalidBlockException();
        }
        if (isFull()) {
            history.remove();
        }
        history.add(new String[]{start, destination});
    }

    public boolean isValidBlock(String block) {
        NusMap nusMap = new NusMap();
        return nusMap.getBlock(block) != null;
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

