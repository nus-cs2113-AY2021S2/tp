package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.InvalidBlockException;

public class GoCommandTest {

    @Test
    public void goCommandTest() throws InvalidBlockException {
        RouterTest routerTest = new RouterTest();
        routerTest.printShortestDistance_linkedBlocks_expectRoute();
        routerTest.printShortestDistance_unknownBlock_expectException();
        routerTest.printShortestDistance_linkedBlocks_expectRouteAfterRepeatedCall();

        HistoryTest historyTest = new HistoryTest();
        historyTest.getHistory_addOneHistory_oneHistoryInHistory();
    }
}
