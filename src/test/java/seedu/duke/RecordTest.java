package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    @Test
    void getRecords_addOneRecord_oneRecordInRecords() {
        Record history = new Record();
        history.addRecord("Start: EA; TO: E1");
        assertEquals(history.getRecords().size(), 1);
    }

    @Test
    void getRecords_clearHistory_noItemsLeftInRecords() {
        Record history = new Record();
        history.addRecord("Start: EA; TO: E1");
        history.addRecord("Start: E2; TO: E1");
        history.addRecord("Start: EA; TO: E4");
        history.addRecord("Start: E2; TO: E4");
        history.emptyRecords();
        assertEquals(history.getRecords().size(), 0);
    }
}