package seedu.duke;

import seedu.duke.exception.InvalidBlockException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Router {

    public String execute(Map nusMap, BlockAlias blockAlias, String from, String to) throws InvalidBlockException {
        assert from != null : "From block cannot be null";
        assert to != null : "Destination block cannot be null";
        try {
            LinkedList<Block> route = new LinkedList<>();
            findShortestRoute(nusMap, route, blockAlias, from, to);
            return getRouteAsString(route);
        } catch (NullPointerException e) {
            throw new InvalidBlockException();
        }
    }

    public void findShortestRoute(Map nusMap, LinkedList<Block> route, BlockAlias blockAlias, String from, String to) {
        nusMap.resetVisitedFlag();
        assert from != null : "From block cannot be null";
        assert to != null : "Destination block cannot be null";

        if (blockAlias.getAliasHashMap().containsKey(from)) {
            from = blockAlias.getAliasHashMap().get(from);
        }
        if (blockAlias.getAliasHashMap().containsKey(to)) {
            to = blockAlias.getAliasHashMap().get(to);
        }

        Block start = nusMap.getBlock(from);
        Block destination = nusMap.getBlock(to);
        HashMap<Block, Block> predecessor = new HashMap<>();
        bfs(nusMap, predecessor, start, destination);
        Block crawl = destination;
        route.add(crawl);
        while (predecessor.containsKey(crawl)) {
            route.add(predecessor.get(crawl));
            crawl = predecessor.get(crawl);
        }
        nusMap.getBlock(to).setDistanceFromStart(route.size());
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
}