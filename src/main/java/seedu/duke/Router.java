package seedu.duke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Router {
    private Map nusMap = new Map();

    public Router(){
        setMap();
        setNeighbours();
    }


    public void execute() {
        Scanner in = new Scanner(System.in);
        System.out.println("STARTING BLOCK:");
        String from = in.nextLine();
        System.out.println("DESTINATION BLOCK:");
        String to = in.nextLine();
        printShortestDistance(from.toUpperCase(), to.toUpperCase());
    }

    public void setMap() {
        nusMap.addLocation(new Block("E1"));
        nusMap.addLocation(new Block("E1A"));
        nusMap.addLocation(new Block("E2"));
        nusMap.addLocation(new Block("E2A"));
        nusMap.addLocation(new Block("E3"));
        nusMap.addLocation(new Block("E3A"));
        nusMap.addLocation(new Block("E4"));
        nusMap.addLocation(new Block("E4A"));
        nusMap.addLocation(new Block("E5"));
        nusMap.addLocation(new Block("E6"));
        nusMap.addLocation(new Block("E7"));
        nusMap.addLocation(new Block("EA"));
        nusMap.addLocation(new Block("EW1"));
        nusMap.addLocation(new Block("EW1A"));
        nusMap.addLocation(new Block("EW2"));
        nusMap.addLocation(new Block("LT1"));
        nusMap.addLocation(new Block("LT2"));
        nusMap.addLocation(new Block("LT5"));
        nusMap.addLocation(new Block("LT6"));
        nusMap.addLocation(new Block("LT7"));
        nusMap.addLocation(new Block("LT7A"));
        nusMap.addLocation(new Block("IT"));
        nusMap.addLocation(new Block("T-LAB"));
        nusMap.addLocation(new Block("TECHNO EDGE"));
    }

    public void setNeighbours() {
        nusMap.addRelationship("EW1", "E1");
        nusMap.addRelationship("E1", "LT5");
        nusMap.addRelationship("E1", "E1A");
        nusMap.addRelationship("E1", "E2");
        nusMap.addRelationship("LT5", "TECHNO EDGE");
        nusMap.addRelationship("E1A", "EA");
        nusMap.addRelationship("EA", "EW1A");
        nusMap.addRelationship("EA", "LT7A");
        nusMap.addRelationship("EA", "LT7");
        nusMap.addRelationship("E2", "E1A");
        nusMap.addRelationship("E2", "EA");
        nusMap.addRelationship("E2", "E2A");
        nusMap.addRelationship("E2", "LT1");
        nusMap.addRelationship("E2", "LT2");
        nusMap.addRelationship("LT5", "E3");
        nusMap.addRelationship("E3", "LT6");
        nusMap.addRelationship("E2", "E3");
        nusMap.addRelationship("E3", "T-LAB");
        nusMap.addRelationship("E3", "E4");
        nusMap.addRelationship("E4", "E5");
        nusMap.addRelationship("E4", "E4A");
        nusMap.addRelationship("E5", "IT");
        nusMap.addRelationship("EA", "E3A");
        nusMap.addRelationship("E4A", "EW2");
        nusMap.addRelationship("EW2", "E6");
        nusMap.addRelationship("E6", "E7");
    }

    public void printShortestDistance(String from, String to) {
        Block start = nusMap.getLocation(from).getBlock();
        Block destination = nusMap.getLocation(to).getBlock();
        HashMap<Block, Block> predecessor = new HashMap<>();

        if (!BFS(nusMap, predecessor, start, destination)) {
            System.out.println("Given source and destination are not connected");
            return;
        } else {
            LinkedList<Block> path = new LinkedList<>();
            Block crawl = destination;
            path.add(crawl);
            while (predecessor.containsKey(crawl)) {
                path.add(predecessor.get(crawl));
                crawl = predecessor.get(crawl);
            }
            System.out.println("Path is ::");
            for (int i = path.size() - 1; i >= 0; i--) {
                if (i > 0) {
                    System.out.print(path.get(i).getName() + "->");
                } else {
                    System.out.print(path.get(i).getName());
                }
            }
            System.out.println("");
        }
    }

    public static boolean BFS(Map nusMap, HashMap<Block, Block> predecessor, Block start, Block destination) {
        LinkedList<Block> queue = new LinkedList<>();
        queue.add(start);
        start.setAsVisited();
        while (!queue.isEmpty()) {
            Block currentBlock = queue.poll();
            ArrayList<Block> neighbours = nusMap.getLocation(currentBlock.getName()).getNeighbours();
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
