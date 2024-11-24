package org.example.GraphAlgorithmsTest;

import static org.junit.Assert.*;

import org.example.GraphAlgorithms.ConnectedComponent;
import org.junit.Before;
import org.junit.Test;

public class ConnectedComponentTest {
    private ConnectedComponent graph;

    @Before
    public void setUp() {
        graph = new ConnectedComponent(6); // Initialize a graph with 6 vertices
    }

    @Test
    public void testMultipleStronglyConnectedComponents() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 3);

        assertEquals(2, graph.countStronglyConnectedComponents());
    }

    @Test
    public void testDisconnectedGraph() {
        // No edges in the graph
        assertEquals(6, graph.countStronglyConnectedComponents());
    }

    @Test
    public void testComplexGraph() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0); // SCC 1
        graph.addEdge(3, 4); // SCC 2
        graph.addEdge(4, 5); // SCC 3

        graph.addEdge(5, 3); // Merge nodes into SCC 2
        graph.addEdge(2, 3); // Connection between SCC 1 and SCC 2

        assertEquals(2, graph.countStronglyConnectedComponents());
    }
}