package org.example.GraphAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import java.util.*;

import org.example.GraphAlgorithms.DijkstraAlgorithm;
import org.example.GraphAlgorithms.Edge;
import org.junit.Test;

public class DijkstraAlgorithmTest {

    @Test
    public void testDijkstra() {
        DijkstraAlgorithm da = new DijkstraAlgorithm();

        // Test Case 1: Simple graph
        int V1 = 5;
        List<List<Edge>> graph1 = new ArrayList<>();
        for (int i = 0; i < V1; i++) graph1.add(new ArrayList<>());
        graph1.get(0).add(new Edge(1, 10));
        graph1.get(0).add(new Edge(4, 5));
        graph1.get(1).add(new Edge(2, 1));
        graph1.get(1).add(new Edge(4, 2));
        graph1.get(2).add(new Edge(3, 4));
        graph1.get(3).add(new Edge(0, 7));
        graph1.get(4).add(new Edge(1, 3));
        graph1.get(4).add(new Edge(2, 9));
        graph1.get(4).add(new Edge(3, 2));
        int[] expected1 = {0, 8, 9, 7, 5};
        assertArrayEquals(expected1, da.dijkstra(V1, graph1, 0));

        // Test Case 2: Disconnected graph
        int V2 = 4;
        List<List<Edge>> graph2 = new ArrayList<>();
        for (int i = 0; i < V2; i++) graph2.add(new ArrayList<>());
        graph2.get(0).add(new Edge(1, 4));
        graph2.get(1).add(new Edge(2, 6));
        int[] expected2 = {0, 4, 10, Integer.MAX_VALUE};
        assertArrayEquals(expected2, da.dijkstra(V2, graph2, 0));

        // Test Case 3: Single vertex graph
        int V3 = 1;
        List<List<Edge>> graph3 = new ArrayList<>();
        graph3.add(new ArrayList<>());
        int[] expected3 = {0};
        assertArrayEquals(expected3, da.dijkstra(V3, graph3, 0));

        // Test Case 4: Large graph
        int V5 = 6;
        List<List<Edge>> graph5 = new ArrayList<>();
        for (int i = 0; i < V5; i++) graph5.add(new ArrayList<>());
        graph5.get(0).add(new Edge(1, 1));
        graph5.get(1).add(new Edge(2, 2));
        graph5.get(2).add(new Edge(3, 3));
        graph5.get(3).add(new Edge(4, 4));
        graph5.get(4).add(new Edge(5, 5));
        int[] expected5 = {0, 1, 3, 6, 10, 15};
        assertArrayEquals(expected5, da.dijkstra(V5, graph5, 0));
    }
}