package seedu.duke;// BFS algorithm in Java

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.AbstractMap;

/*adapted from https://www.geeksforgeeks.org/shortest-path-unweighted-graph/*/

public class Routing {
    private static int v = 24;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);

    public Routing(){
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        addEdge("EW1","E1");
        addEdge("E1","LT5");
        addEdge("E1","E1A");
        addEdge("E1","E2");
        addEdge("LT5","TECHNO EDGE");
        addEdge("E1A","EA");
        addEdge("EA","EW1A");
        addEdge("EA","LT7A");
        addEdge("EA","LT7");
        addEdge("E2","E1A");
        addEdge("E2","EA");
        addEdge("E2","E2A");
        addEdge("E2","LT1");
        addEdge("E2","LT2");
        addEdge("LT5","E3");
        addEdge("E3","LT6");
        addEdge("E2","E3");
        addEdge("E3","T-LAB");
        addEdge("E3","E4");
        addEdge("E4","E5");
        addEdge("E4","E4A");
        addEdge("E5","IT");
        addEdge("EW1","E1");
        addEdge("EA","E3A");
        addEdge("E4A","EW2");
        addEdge("EW2","E6");
        addEdge("E6","E7");

    }

    Map<String, Integer> blockToNumber = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Integer>("EW1", 0),
            new AbstractMap.SimpleEntry<String, Integer>("E1", 1),
            new AbstractMap.SimpleEntry<String, Integer>("E1A", 2),
            new AbstractMap.SimpleEntry<String, Integer>("EW1A", 3),
            new AbstractMap.SimpleEntry<String, Integer>("E2", 4),
            new AbstractMap.SimpleEntry<String, Integer>("E2A", 5),
            new AbstractMap.SimpleEntry<String, Integer>("EW2", 6),
            new AbstractMap.SimpleEntry<String, Integer>("E3", 7),
            new AbstractMap.SimpleEntry<String, Integer>("E3A", 8),
            new AbstractMap.SimpleEntry<String, Integer>("E4", 9),
            new AbstractMap.SimpleEntry<String, Integer>("E4A", 10),
            new AbstractMap.SimpleEntry<String, Integer>("E5", 11),
            new AbstractMap.SimpleEntry<String, Integer>("E6", 12),
            new AbstractMap.SimpleEntry<String, Integer>("E7", 13),
            new AbstractMap.SimpleEntry<String, Integer>("EA", 14),
            new AbstractMap.SimpleEntry<String, Integer>("LT1", 15),
            new AbstractMap.SimpleEntry<String, Integer>("LT2", 16),
            new AbstractMap.SimpleEntry<String, Integer>("LT5", 17),
            new AbstractMap.SimpleEntry<String, Integer>("LT6", 18),
            new AbstractMap.SimpleEntry<String, Integer>("LT7A", 19),
            new AbstractMap.SimpleEntry<String, Integer>("LT7", 20),
            new AbstractMap.SimpleEntry<String, Integer>("IT", 21),
            new AbstractMap.SimpleEntry<String, Integer>("T-LAB", 22),
            new AbstractMap.SimpleEntry<String, Integer>("TECHNO EDGE", 23)
    );

    Map<Integer, String> numberToBlock = Map.ofEntries(
            new AbstractMap.SimpleEntry<Integer, String>(0,"EW1"),
            new AbstractMap.SimpleEntry<Integer, String>(1,"E1"),
            new AbstractMap.SimpleEntry<Integer, String>(2,"E1A"),
            new AbstractMap.SimpleEntry<Integer, String>(3,"EW1A"),
            new AbstractMap.SimpleEntry<Integer, String>(4,"E2"),
            new AbstractMap.SimpleEntry<Integer, String>(5,"E2A"),
            new AbstractMap.SimpleEntry<Integer, String>(6,"EW2"),
            new AbstractMap.SimpleEntry<Integer, String>(7,"E3"),
            new AbstractMap.SimpleEntry<Integer, String>(8,"E3A"),
            new AbstractMap.SimpleEntry<Integer, String>(9,"E4"),
            new AbstractMap.SimpleEntry<Integer, String>(10,"E4A"),
            new AbstractMap.SimpleEntry<Integer, String>(11,"E5"),
            new AbstractMap.SimpleEntry<Integer, String>(12,"E6"),
            new AbstractMap.SimpleEntry<Integer, String>(13,"E7"),
            new AbstractMap.SimpleEntry<Integer, String>(14,"EA"),
            new AbstractMap.SimpleEntry<Integer, String>(15,"LT1"),
            new AbstractMap.SimpleEntry<Integer, String>(16,"LT2"),
            new AbstractMap.SimpleEntry<Integer, String>(17,"LT5"),
            new AbstractMap.SimpleEntry<Integer, String>(18,"LT6"),
            new AbstractMap.SimpleEntry<Integer, String>(19,"LT7A"),
            new AbstractMap.SimpleEntry<Integer, String>(20,"LT7"),
            new AbstractMap.SimpleEntry<Integer, String>(21,"IT"),
            new AbstractMap.SimpleEntry<Integer, String>(22,"T-LAB"),
            new AbstractMap.SimpleEntry<Integer, String>(23,"TECHNO EDGE")
    );



    private void addEdge(String i, String j)
    {
        int block1 = blockToNumber.get(i);
        int block2 = blockToNumber.get(j);
        adj.get(block1).add(block2);
        adj.get(block2).add(block1);
    }

    // function to print the shortest distance and path
    // between source vertex and destination vertex
    public void printShortestDistance(String from, String to)
    {
        // predecessor[i] array stores predecessor of
        // i and distance array stores distance of i
        // from s
        int s = blockToNumber.get(from.toUpperCase());
        int dest = blockToNumber.get(to.toUpperCase());
        int[] pred = new int[v];
        int[] dist = new int[v];

        if (!BFS(adj, s, dest, v, pred, dist)) {
            System.out.println("Given source and destination" +
                    "are not connected");
            return;
        }

        // LinkedList to store path
        LinkedList<Integer> path = new LinkedList<Integer>();
        int crawl = dest;
        path.add(crawl);
        while (pred[crawl] != -1) {
            path.add(pred[crawl]);
            crawl = pred[crawl];
        }

        // Print distance
        //System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.println("Path is :");
        for (int i = path.size() - 1; i >= 0; i--) {
            if(i > 0) {
                System.out.print(numberToBlock.get(path.get(i)) + "->");
            } else {
                System.out.print(numberToBlock.get(path.get(i)));
            }
        }
    }

    // a modified version of BFS that stores predecessor
    // of each vertex in array pred
    // and its distance from source in array dist
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src,
                               int dest, int v, int[] pred, int[] dist)
    {
        // a queue to maintain queue of vertices whose
        // adjacency list is to be scanned as per normal
        // BFS algorithm using LinkedList of Integer type
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // boolean array visited[] which stores the
        // information whether ith vertex is reached
        // at least once in the Breadth first search
        boolean[] visited = new boolean[v];

        // initially all vertices are unvisited
        // so v[i] for all i is false
        // and as no path is yet constructed
        // dist[i] for all i set to infinity
        for (int i = 0; i < v; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }

        // now source is first to be visited and
        // distance from source to itself should be 0
        visited[src] = true;
        dist[src] = 0;
        queue.add(src);

        // bfs Algorithm
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int i = 0; i < adj.get(u).size(); i++) {
                if (!visited[adj.get(u).get(i)]) {
                    visited[adj.get(u).get(i)] = true;
                    dist[adj.get(u).get(i)] = dist[u] + 1;
                    pred[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    // stopping condition (when we find
                    // our destination)
                    if (adj.get(u).get(i) == dest)
                        return true;
                }
            }
        }
        return false;
    }

    public void executeRouting() {
        Scanner in = new Scanner(System.in);
        System.out.println("STARTING BLOCK:");
        String from = in.nextLine();
        System.out.println("DESTINATION BLOCK:");
        String to = in.nextLine();
        printShortestDistance(from,to);
        System.out.println("");
    }
}