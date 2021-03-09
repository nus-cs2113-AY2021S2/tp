package seedu.duke;// BFS algorithm in Java

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.AbstractMap;

/*adapted from https://www.geeksforgeeks.org/shortest-path-unweighted-graph/*/

public class routing {
    private static int v = 8;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(v);

    public routing(){
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

    }

    Map<String, Integer> blockToNumber = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Integer>("E0", 0),
            new AbstractMap.SimpleEntry<String, Integer>("E1", 1),
            new AbstractMap.SimpleEntry<String, Integer>("E2", 2),
            new AbstractMap.SimpleEntry<String, Integer>("E3", 3),
            new AbstractMap.SimpleEntry<String, Integer>("E4", 4),
            new AbstractMap.SimpleEntry<String, Integer>("E5", 5),
            new AbstractMap.SimpleEntry<String, Integer>("E6", 6),
            new AbstractMap.SimpleEntry<String, Integer>("E7", 7)
    );

    Map<Integer, String> numberToBlock = Map.ofEntries(
            new AbstractMap.SimpleEntry<Integer, String>(0, "E0"),
            new AbstractMap.SimpleEntry<Integer, String>(1, "E1"),
            new AbstractMap.SimpleEntry<Integer, String>(2, "E2"),
            new AbstractMap.SimpleEntry<Integer, String>(3, "E3"),
            new AbstractMap.SimpleEntry<Integer, String>(4, "E4"),
            new AbstractMap.SimpleEntry<Integer, String>(5, "E5"),
            new AbstractMap.SimpleEntry<Integer, String>(6, "E6"),
            new AbstractMap.SimpleEntry<Integer, String>(7, "E7")
    );



    private static void addEdge(String i, String j)
    {
        int block1 = Integer.getInteger(i);
        int block2 = Integer.getInteger(j);
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
        int s = blockToNumber.get(from);
        int dest = blockToNumber.get(to);
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
        System.out.println("Shortest path length is: " + dist[dest]);

        // Print path
        System.out.println("Path is ::");
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

}