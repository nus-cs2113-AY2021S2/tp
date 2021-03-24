package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.InvalidBlockException;
import seedu.duke.routing.Router;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterTest {

    @Test
    void printShortestDistance_linkedBlocks_expectRoute() throws InvalidBlockException {
        Router map = new Router();
        String out = map.execute("E2","E7");
        assertEquals(out, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
    }

    @Test
    void printShortestDistance_unknownBlock_expectException() {
        Router map = new Router();
        assertThrows(InvalidBlockException.class, () -> {
            map.execute("AS2","E7");
        });
    }

    @Test
    void printShortestDistance_linkedBlocks_expectRouteAfterRepeatedCall() throws InvalidBlockException {
        Router map = new Router();
        String out1 = map.execute("E2", "E7");
        assertEquals(out1, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
        map.resetMap();
        String out2 = map.execute("E2","E7");
        assertEquals(out2, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
    }

    @Test
    void printShortestDistance_linkedBlocks_expectNoRoute() throws InvalidBlockException {
        Router map = new Router();
        String out = map.execute("AS1","EA");
        assertEquals(out, "The blocks given have no connected pathways!");
    }
}