package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {
    @Test
    void getHistory_addOneHistory_oneHistoryInHistory() {
        History history = new History();
        history.addRecord("Start: EA; TO: E1");
        assertEquals(history.getRecords().size(), 1);
    }

    @Test
    void getHistory_clearHistory_noItemsLeftInHistory() {
        History history = new History();
        history.addRecord("Start: EA; TO: E1");
        history.addRecord("Start: E2; TO: E1");
        history.addRecord("Start: EA; TO: E4");
        history.addRecord("Start: E2; TO: E4");
        history.emptyRecords();
        assertEquals(history.getRecords().size(), 0);
    }
}
