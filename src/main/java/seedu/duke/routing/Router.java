package seedu.duke.routing;

import seedu.duke.Block;
import seedu.duke.exception.InvalidBlockException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Router {

    public LinkedList<Block> execute(Map nusMap, String from, String to) throws InvalidBlockException {
        assert from != null : "From block cannot be null";
        assert to != null : "Destination block cannot be null";
        nusMap.resetVisitedFlag();
        try {
            return findShortestRoute(nusMap, from, to);
        } catch (NullPointerException e) {
            throw new InvalidBlockException();
        }
    }

    public LinkedList<Block> findShortestRoute(Map nusMap, String from, String to) {
        assert from != null : "From block cannot be null";
        assert to != null : "Destination block cannot be null";
        Block start = nusMap.getBlock(from);
        Block destination = nusMap.getBlock(to);
        HashMap<Block, Block> predecessor = new HashMap<>();
        bfs(nusMap, predecessor, start, destination);
        LinkedList<Block> path = new LinkedList<>();
        Block crawl = destination;
        path.add(crawl);
        while (predecessor.containsKey(crawl)) {
            path.add(predecessor.get(crawl));
            crawl = predecessor.get(crawl);
        }
        nusMap.getBlock(to).setDistanceFromStart(path.size());
        return path;
    }

    public static void bfs(Map nusMap, HashMap<Block, Block> predecessor, Block start, Block destination) {
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
                        break;
                    }
                }
            }
        }
    }

    public String getRouteAsString(LinkedList<Block> route) {
        String routeAsString = "";
        routeAsString += "Route is :";
        for (int i = route.size() - 1; i >= 0; i--) {
            if (i > 0) {
                routeAsString += route.get(i).getName() + "->";
            } else {
                routeAsString += route.get(i).getName();
            }
        }
        return routeAsString;
    }
}