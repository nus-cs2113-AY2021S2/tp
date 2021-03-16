package seedu.duke.routing;

import seedu.duke.History;
import seedu.duke.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Router {
    private Map nusMap = new Map();

    public Router() {
    }


/*    public void execute(History history) {
        Scanner in = new Scanner(System.in);
        System.out.println("STARTING BLOCK:");
        String from = in.nextLine();
        System.out.println("DESTINATION BLOCK:");
        String to = in.nextLine();
        try {
            System.out.println(printShortestDistance(from.toUpperCase(), to.toUpperCase()));
            String record = "START: " + from.toUpperCase() + "; TO: " + to.toUpperCase();
            history.addRecord(record);
        } catch (NullPointerException e) {
            System.out.println("Invalid block! Please enter the 'go' command to retry!");
        }
    }*/
    public String execute(String from, String to) {
        System.out.println(from);
        System.out.println(to);
        try {
            return printShortestDistance(from, to);
        } catch (NullPointerException e) {
            return "Invalid block! Please enter the 'go' command to retry!";
        }
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
