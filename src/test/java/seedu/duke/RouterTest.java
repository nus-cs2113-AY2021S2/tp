package seedu.duke;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.InvalidBlockException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterTest {

    @Test
    void printShortestDistance_linkedBlocks_expectRoute() throws InvalidBlockException {
<<<<<<< HEAD
        Map nusMap = new Map();
        String out = new Router().execute(nusMap, "E2","E7");
=======
        BlockAlias blockAlias = new BlockAlias();
        Router map = new Router(blockAlias);
        String out = map.execute("E2","E7");
>>>>>>> 0cdea5e12cd6ca39621c809264486a14d423191e
        assertEquals(out, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
    }

    @Test
    void printShortestDistance_unknownBlock_expectException() {
<<<<<<< HEAD
        Map nusMap = new Map();
=======
        BlockAlias blockAlias = new BlockAlias();
        Router map = new Router(blockAlias);
>>>>>>> 0cdea5e12cd6ca39621c809264486a14d423191e
        assertThrows(InvalidBlockException.class, () -> {
            new Router().execute(nusMap, "AS2","E7");
        });
    }

    @Test
    void printShortestDistance_linkedBlocks_expectRouteAfterRepeatedCall() throws InvalidBlockException {
<<<<<<< HEAD
        Map nusMap = new Map();
        String out1 = new Router().execute(nusMap,"E2", "E7");
=======
        BlockAlias blockAlias = new BlockAlias();
        Router map = new Router(blockAlias);
        String out1 = map.execute("E2", "E7");
>>>>>>> 0cdea5e12cd6ca39621c809264486a14d423191e
        assertEquals(out1, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
        nusMap.resetVisitedFlag();
        String out2 = new Router().execute(nusMap,"E2", "E7");
        assertEquals(out2, "Route is :E2->E3->E4->E4A->EW2->E6->E7");
    }
<<<<<<< HEAD
=======

    @Test
    void printShortestDistance_linkedBlocks_expectNoRoute() throws InvalidBlockException {
        BlockAlias blockAlias = new BlockAlias();
        Router map = new Router(blockAlias);
        String out = map.execute("AS1","EA");
        assertEquals(out, "The blocks given have no connected pathways!");
    }
>>>>>>> 0cdea5e12cd6ca39621c809264486a14d423191e
}