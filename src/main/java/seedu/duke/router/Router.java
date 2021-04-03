//@@author SimBowen

package seedu.duke.router;

import seedu.duke.data.Block;
import seedu.duke.data.NusMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Router {

    public String execute(NusMap nusMap, String from, String to) {
        assert from != null : "From block cannot be null";
        assert to != null : "Destination block cannot be null";
        LinkedList<Block> route = new LinkedList<>();
        findShortestRoute(nusMap, route, from, to);
        return getRouteAsString(route);
    }

    public void findShortestRoute(NusMap nusMap, LinkedList<Block> route, String from, String to) {
        nusMap.resetVisitedFlag();
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

    public static void bfs(NusMap nusMap, HashMap<Block, Block> predecessor, Block start, Block destination) {
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
        StringBuilder routeAsString = new StringBuilder();
        routeAsString.append("Route: ");
        for (int i = route.size() - 1; i >= 0; i--) {
            if (i > 0) {
                routeAsString.append(route.get(i).getName()).append(" -> ");
            } else {
                routeAsString.append(route.get(i).getName());
            }
        }
        return routeAsString.toString();
    }
}