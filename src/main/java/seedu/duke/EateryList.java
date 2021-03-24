package seedu.duke;

import java.util.LinkedList;

public class EateryList {
    private Block[] eateries;

    public EateryList(Map nusMap, BlockAlias blockAlias, String from) {
        this.eateries = new Block[5];
        setRouteLengths(nusMap, blockAlias, from);
        setEateries(nusMap);
    }

    public Block[] getEateries() {
        return eateries;
    }

    public Block getSpecificEatery(int i) {
        return eateries[i];
    }

    public void setRouteLengths(Map nusMap, BlockAlias blockAlias, String from) {
        new Router().findShortestRoute(nusMap, new LinkedList<>(), blockAlias, from, "TECHNO EDGE CANTEEN");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), blockAlias, from, "CHEERS MINIMART");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), blockAlias, from, "ARISE & SHINE");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), blockAlias, from, "PLATYPUS FOOD BAR");
        new Router().findShortestRoute(nusMap, new LinkedList<>(), blockAlias, from, "SPINELLI COFFEE");
    }

    public void setEateries(Map nusMap) {
        eateries[0] = nusMap.getBlock("TECHNO EDGE CANTEEN");
        eateries[1] = nusMap.getBlock("CHEERS MINIMART");
        eateries[2] = nusMap.getBlock("ARISE & SHINE");
        eateries[3] = nusMap.getBlock("PLATYPUS FOOD BAR");
        eateries[4] = nusMap.getBlock("SPINELLI COFFEE");
    }

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
