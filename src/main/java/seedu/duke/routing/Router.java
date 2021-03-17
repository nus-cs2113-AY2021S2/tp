package seedu.duke.routing;

import seedu.duke.Block;
import seedu.duke.exception.InvalidBlockException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Router {
    private Map nusMap;

    public Router() {
        this.nusMap = new Map();
    }

    public String execute(String from, String to) throws InvalidBlockException {
        resetMap();
        try {
            return printShortestDistance(from, to);
        } catch (NullPointerException e) {
            throw new InvalidBlockException();
        }
    }

    public void resetMap() {
        this.nusMap = new Map();
    }

    public String printShortestDistance(String from, String to) {
        Block start = nusMap.getBlock(from);
        Block destination = nusMap.getBlock(to);
        HashMap<Block, Block> predecessor = new HashMap<>();
        String route = "";
        if (!bfs(nusMap, predecessor, start, destination)) {
            route += "The blocks given have no connected pathways!";
        } else {
            LinkedList<Block> path = new LinkedList<>();
            Block crawl = destination;
            path.add(crawl);
            while (predecessor.containsKey(crawl)) {
                path.add(predecessor.get(crawl));
                crawl = predecessor.get(crawl);
            }
            route += "Route is :";
            for (int i = path.size() - 1; i >= 0; i--) {
                if (i > 0) {
                    route += path.get(i).getName() + "->";
                } else {
                    route += path.get(i).getName();
                }
            }
        }
        return route;
    }

    public static boolean bfs(Map nusMap, HashMap<Block, Block> predecessor, Block start, Block destination) {
        LinkedList<Block> queue = new LinkedList<>();
        queue.add(start);
        start.setAsVisited();
        while (!queue.isEmpty()) {
            Block currentBlock = queue.poll();
            ArrayList<Block> neighbours = nusMap.getBlock(currentBlock.getName()).getNeighbours();
            for (Block neighbour : neighbours) {
                if (!neighbour.isVisited()) {
                    neighbour.setAsVisited();
                    predecessor.put(neighbour, currentBlock);
                    queue.add(neighbour);
                    if (neighbour.isSameBlock(destination)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
