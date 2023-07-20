package DSA.GRAPH;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GRAPH {
    static int[][] adjacencyMatrix;
    static int numberOfNodes;
    static Map<Integer, ArrayList<Integer>> map = new HashMap<>();

    public static void addedge(int u, int v, boolean direction) {
        if (!map.containsKey(u)) {
            map.put(u, new ArrayList<>());
        }
        map.get(u).add(v);

        if (!direction) {
            if (!map.containsKey(v)) {
                map.put(v, new ArrayList<>());
            }
            map.get(v).add(u);
        }
    }
    public static void addedge1(int u, int v, boolean direction) {
        adjacencyMatrix[u][v] = 1;
        if (!direction) {
            adjacencyMatrix[v][u] = 1;
        }
    }

    public static void printgraph() {
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            int u = entry.getKey();
            ArrayList<Integer> neighbors = entry.getValue();
            System.out.print(u + ": ");
            for (int v : neighbors) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }
    public static void printgraph1() {
        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= numberOfNodes; i++) {
            for (int j = 1; j <= numberOfNodes; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        numberOfNodes = sc.nextInt();
        adjacencyMatrix = new int[numberOfNodes + 1][numberOfNodes + 1];
        int m;
        System.out.println("Enter the number of edges:");
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u, v;
            System.out.println("Enter edge " + (i + 1) + ":");
            u = sc.nextInt();
            v = sc.nextInt();
           // addedge(u, v, false);
            addedge1(u,v,false);
        }
        System.out.println("Graph:");
       // printgraph();
        printgraph1();
    }
}

