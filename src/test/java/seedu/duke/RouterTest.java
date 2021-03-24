package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.InvalidBlockException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterTest {

    @Test
    void printShortestDistance_linkedBlocks_expectRoute() throws InvalidBlockException {
        Map nusMap = new Map();
        String out = new Router().execute(nusMap, "E2","E7");
        assertEquals(out, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
    }

    @Test
    void printShortestDistance_unknownBlock_expectException() {
        Map nusMap = new Map();
        assertThrows(InvalidBlockException.class, () -> {
            new Router().execute(nusMap, "AS2","E7");
        });
    }

    @Test
    void printShortestDistance_linkedBlocks_expectRouteAfterRepeatedCall() throws InvalidBlockException {
        Map nusMap = new Map();
        String out1 = new Router().execute(nusMap,"E2", "E7");
        assertEquals(out1, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
        nusMap.resetVisitedFlag();
        String out2 = new Router().execute(nusMap,"E2", "E7");
        assertEquals(out2, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
    }
}