package org.example.GraphAlgorithmsTest;

import org.example.GraphAlgorithms.ConnectNetwork;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConnectNetworkTest {

    private ConnectNetwork connectNetwork;

    @Before
    public void setUp() {
        connectNetwork = new ConnectNetwork();
    }

    @Test
    public void testMakeConnectedExample1() {
        int n = 6;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {3, 4}
        };
        assertEquals(-1, connectNetwork.makeConnected(n, connections));
    }

    @Test
    public void testMakeConnectedExample2() {
        int n = 6;
        int[][] connections = {
                {0,1},
                {0,2},
                {0,3},
                {1,2},
                {1,3}
        };
        assertEquals(2, connectNetwork.makeConnected(n, connections));
    }

    @Test
    public void testMakeConnectedExample3() {
        int n = 6;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {3, 4}
        };
        assertEquals(-1, connectNetwork.makeConnected(n, connections));
    }

    @Test
    public void testMakeConnectedNotEnoughCables() {
        int n = 4;
        int[][] connections = {
                {0, 1},
                {0, 2}
        };
        assertEquals(-1, connectNetwork.makeConnected(n, connections));
    }

    @Test
    public void testMakeConnectedAlreadyConnected() {
        int n = 4;
        int[][] connections = {
                {0, 1},
                {1, 2},
                {2, 3}
        };
        assertEquals(0, connectNetwork.makeConnected(n, connections));
    }

    @Test
    public void testMakeConnectedNoConnections() {
        int n = 5;
        int[][] connections = {};
        assertEquals(-1, connectNetwork.makeConnected(n, connections));
    }

    @Test
    public void testMakeConnectedSingleNode() {
        int n = 1;
        int[][] connections = {};
        assertEquals(0, connectNetwork.makeConnected(n, connections));
    }
}