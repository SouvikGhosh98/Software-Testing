package org.example.GraphAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConnectedComponent {
    private final int vertices;
    private final List<List<Integer>> adjacencyList;

    // Constructor to initialize the directed graph
    public ConnectedComponent (int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add a directed edge from src to dest
    public void addEdge(int src, int dest) {
        adjacencyList.get(src).add(dest);
    }

    // Helper method to perform DFS and fill the stack
    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(node);
    }

    // Helper method to perform DFS on the transposed graph
    private void dfsOnTranspose(int node, boolean[] visited, List<List<Integer>> transposedGraph) {
        visited[node] = true;
        for (int neighbor : transposedGraph.get(node)) {
            if (!visited[neighbor]) {
                dfsOnTranspose(neighbor, visited, transposedGraph);
            }
        }
    }

    // Method to transpose the graph
    private List<List<Integer>> getTranspose() {
        List<List<Integer>> transposedGraph = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            transposedGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < vertices; i++) {
            for (int neighbor : adjacencyList.get(i)) {
                transposedGraph.get(neighbor).add(i);
            }
        }
        return transposedGraph;
    }

    // Method to count the number of strongly connected components
    public int countStronglyConnectedComponents() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        // Step 1: Perform a DFS to fill the stack
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Step 2: Transpose the graph
        List<List<Integer>> transposedGraph = getTranspose();

        // Step 3: Perform DFS on the transposed graph
        visited = new boolean[vertices];
        int components = 0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                components++;
                dfsOnTranspose(node, visited, transposedGraph);
            }
        }
        return components;
    }
}