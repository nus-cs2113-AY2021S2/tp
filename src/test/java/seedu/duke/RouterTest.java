package seedu.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouterTest {

    @Test
    void printShortestDistance_linkedBlocks_expectRoute() {
        Router map = new Router();
        String out = map.printShortestDistance("E2","E7");
        assertEquals(out, "Path is ::E2->E3->E4->E4A->EW2->E6->E7");
    }

    @Test
    void printShortestDistance_unknownBlock_expectException() {
        Router map = new Router();
        assertThrows(NullPointerException.class, () -> {
            map.printShortestDistance("AS2","E7");
        });
    }

    @Test
    void printShortestDistance_linkedBlocks_expectNoRoute() {
        Router map = new Router();
        String out = map.printShortestDistance("AS1","EA");
        assertEquals(out, "The blocks given have no connected pathways!");
    }
}