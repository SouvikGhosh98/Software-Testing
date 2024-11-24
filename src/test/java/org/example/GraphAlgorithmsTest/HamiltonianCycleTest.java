package org.example.GraphAlgorithmsTest;

import org.example.GraphAlgorithms.HamiltonianCycle;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamiltonianCycleTest {
    @Test
    public void testHamiltonianCycle() {
    	HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();
        int[] ans1 = { 0, 1, 2, 4, 3, 0 };
        int[][] arr1 = {
            { 0, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1 },
            { 0, 1, 0, 0, 1 },
            { 1, 1, 0, 0, 1 },
            { 0, 1, 1, 1, 0 },
        };
        assertArrayEquals(ans1, hamiltonianCycle.findHamiltonianCycle(arr1));
        
        int[] ans2 = { -1, -1, -1, -1, -1, -1 };
        int[][] arr2 = {
            { 0, 1, 0, 1, 0 },
            { 1, 0, 1, 1, 1 },
            { 0, 1, 0, 0, 1 },
            { 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 0 },
        };
        assertArrayEquals(ans2, hamiltonianCycle.findHamiltonianCycle(arr2));
    }
}