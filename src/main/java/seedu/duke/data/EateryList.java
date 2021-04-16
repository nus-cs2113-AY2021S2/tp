package seedu.duke.data;

import seedu.duke.exception.InvalidIndexException;
import seedu.duke.router.Router;

import java.util.LinkedList;

/**
 * Represents a list of eateries in {@link NusMap}.
 */
public class EateryList {
    private Block[] eateries;

    public EateryList(NusMap nusMap, String from) {
        this.eateries = new Block[7];
        setRouteLengths(nusMap, from);
        setEateries(nusMap);
    }

    /** Returns the list of eateries. */
    public Block[] getEateries() {
        return eateries;
    }

    /**
     * Returns a eatery at specific index.
     *
     * @param index eatery index to be returned
     * @return the eatery at specific index
     * @throws InvalidIndexException if the index is greater than 7 or smaller than 0
     */
    public Block getSpecificEatery(int index) throws InvalidIndexException {
        if (index > 7 || index < 0) {
            throw new InvalidIndexException();
        } else {
            return eateries[index];
        }
    }

    /** Sets the distance from Starting block to a particular eatery. */
    public void setRouteLengths(NusMap nusMap, String from) {
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "TECHNO EDGE CANTEEN");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "CHEERS MINIMART");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "ARISE & SHINE");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "PLATYPUS FOOD BAR");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "SPINELLI COFFEE");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "MAXX COFFEE");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), from, "STARBUCKS");

    }

    /** Sets the eatery list. */
    public void setEateries(NusMap nusMap) {
        eateries[0] = nusMap.getBlock("TECHNO EDGE CANTEEN");
        eateries[1] = nusMap.getBlock("CHEERS MINIMART");
        eateries[2] = nusMap.getBlock("ARISE & SHINE");
        eateries[3] = nusMap.getBlock("PLATYPUS FOOD BAR");
        eateries[4] = nusMap.getBlock("SPINELLI COFFEE");
        eateries[5] = nusMap.getBlock("MAXX COFFEE");
        eateries[6] = nusMap.getBlock("STARBUCKS");
    }

    /**
     * Sorts the eatery list using the {@link Block#getDistanceFromStart()} values.
     */
    public void sortEateriesByDistance() {
        for (int i = 0; i < eateries.length - 1; i++) {
            for (int j = 0; j < eateries.length - 1 - i; j++) {
                if (eateries[j].getDistanceFromStart() > eateries[j + 1].getDistanceFromStart()) {
                    Block temp = eateries[j];
                    eateries[j] = eateries[j + 1];
                    eateries[j + 1] = temp;
                }
            }
        }
    }
}
