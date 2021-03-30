package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.data.NusMap;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.router.Router;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterTest {

    @Test
    void printShortestDistance_linkedBlocks_expectRoute() throws InvalidBlockException {
        NusMap nusMap = new NusMap();
        String out = new Router().execute(nusMap, "E2","E7");
        assertEquals(out, "Route: E2 -> E3 -> E4 -> E4A -> EW2 -> E6 -> E7");
    }

    @Test
    void printShortestDistance_unknownBlock_expectException() {
        NusMap nusMap = new NusMap();
        assertThrows(InvalidBlockException.class, () -> {
            new Router().execute(nusMap, "AS2","E7");
        });
    }

    @Test
    void printShortestDistance_linkedBlocks_expectRouteAfterRepeatedCall() throws InvalidBlockException {
        NusMap nusMap = new NusMap();
        String out1 = new Router().execute(nusMap, "E2","E7");
        assertEquals(out1, "Route: E2 -> E3 -> E4 -> E4A -> EW2 -> E6 -> E7");
        nusMap.resetVisitedFlag();
        String out2 = new Router().execute(nusMap, "E2", "E7");
        assertEquals(out2, "Route: E2 -> E3 -> E4 -> E4A -> EW2 -> E6 -> E7");
    }
}