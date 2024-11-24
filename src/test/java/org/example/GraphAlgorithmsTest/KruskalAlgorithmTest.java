package org.example.GraphAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.example.GraphAlgorithms.KruskalAlgorithm;
import org.junit.Before;
import org.junit.Test;

public class KruskalAlgorithmTest {
    private KruskalAlgorithm kruskal;

    @Before
    public void setUp() {
        kruskal = new KruskalAlgorithm(4); // Example graph with 4 vertices
    }

    @Test
    public void testKruskalMST() {
        // Add edges: (source, destination, weight)
        kruskal.addEdge(0, 1, 10);
        kruskal.addEdge(0, 2, 6);
        kruskal.addEdge(0, 3, 5);
        kruskal.addEdge(1, 3, 15);
        kruskal.addEdge(2, 3, 4);

        // Run Kruskal's algorithm
        List<KruskalAlgorithm.Edge> mst = kruskal.kruskalMST();

        // Verify MST edges and their weights
        assertEquals(3, mst.size()); // MST should have V-1 edges
        assertEquals(4, mst.get(0).weight); // Edge (2, 3)
        assertEquals(5, mst.get(1).weight); // Edge (0, 3)
    }

    @Test
    public void testDisconnectedGraph() {
        KruskalAlgorithm disconnectedGraph = new KruskalAlgorithm(5);
        disconnectedGraph.addEdge(0, 1, 2);
        disconnectedGraph.addEdge(3, 4, 3);

        // Run Kruskal's algorithm
        List<KruskalAlgorithm.Edge> mst = disconnectedGraph.kruskalMST();

        // Verify the MST
        assertEquals(2, mst.size()); // Two disjoint trees, one edge per component
        assertEquals(2, mst.get(0).weight); // Edge (0, 1)
        assertEquals(3, mst.get(1).weight); // Edge (3, 4)
    }

    @Test
    public void testSingleVertexGraph() {
        KruskalAlgorithm singleVertexGraph = new KruskalAlgorithm(1);

        // Run Kruskal's algorithm
        List<KruskalAlgorithm.Edge> mst = singleVertexGraph.kruskalMST();

        // Verify the MST
        assertEquals(0, mst.size()); // No edges in a single vertex graph
    }

    @Test
    public void testNoEdgesGraph() {
        KruskalAlgorithm noEdgesGraph = new KruskalAlgorithm(4);

        // Run Kruskal's algorithm
        List<KruskalAlgorithm.Edge> mst = noEdgesGraph.kruskalMST();

        // Verify the MST
        assertEquals(0, mst.size()); // No edges, no MST
    }
}