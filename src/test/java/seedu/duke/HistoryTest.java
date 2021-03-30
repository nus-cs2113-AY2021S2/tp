package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.data.History;
import seedu.duke.exception.InvalidBlockException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoryTest {
    @Test
    void getHistory_addOneHistory_oneHistoryInHistory() throws InvalidBlockException {
        History history = new History();
        history.addHistory("EA", "E1");
        assertEquals(history.getHistorySize(), 1);
    }

    @Test
    void getHistory_clearHistory_noItemsLeftInHistory() throws InvalidBlockException {
        History history = new History();
        history.addHistory("EA", "E1");
        history.addHistory("E2", "E1");
        history.addHistory("EA", "E4");
        history.addHistory("E2", "E4");
        history.clearHistory();
        assertEquals(history.getHistorySize(), 0);
    }
}
