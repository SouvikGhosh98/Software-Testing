package org.example.GraphAlgorithmsTest;

import org.example.GraphAlgorithms.LargeIsland;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LargeIslandTest {

    private LargeIsland largeIsland;

    @Before
    public void setUp() {
        largeIsland = new LargeIsland();
    }

    @Test
    public void testLargestIslandExample1() {
        int[][] grid = {
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {1, 1, 1, 0},
                {0, 0, 0, 1}
        };
        assertEquals(8, largeIsland.largestIsland(grid));
    }

    @Test
    public void testLargestIslandExample2() {
        int[][] grid = {
                {1, 1},
                {1, 0}
        };
        assertEquals(4, largeIsland.largestIsland(grid));
    }

    @Test
    public void testLargestIslandExample3() {
        int[][] grid = {
                {1, 0, 1},
                {1, 1, 1},
                {0, 1, 1}
        };
        assertEquals(8, largeIsland.largestIsland(grid));
    }

    @Test
    public void testLargestIslandExample4() {
        int[][] grid = {
                {0, 0},
                {0, 0}
        };
        assertEquals(1, largeIsland.largestIsland(grid));
    }

    @Test
    public void testLargestIslandExample5() {
        int[][] grid = {
                {1, 1},
                {0, 1}
        };
        assertEquals(4, largeIsland.largestIsland(grid));
    }

    @Test
    public void testLargestIslandWithSingleCell() {
        int[][] grid = {{1}};
        assertEquals(1, largeIsland.largestIsland(grid));
    }
}