package org.example.SortingAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import org.example.SortingAlgorithms.HeapSort;
import org.junit.Test;

public class HeapSortTest {

    @Test
    public void testHeapSort() {
        HeapSort hs = new HeapSort();
        int[] arr = {4, 10, 3, 5, 1};
        int[] expected = {1, 3, 4, 5, 10};
        hs.heapSort(arr);
        assertArrayEquals(expected, arr);

        int[] arr2 = {7, -5, 2, 0, 6};
        int[] expected2 = {-5, 0, 2, 6, 7};
        hs.heapSort(arr2);
        assertArrayEquals(expected2, arr2);

        int[] arr3 = {1};
        int[] expected3 = {1};
        hs.heapSort(arr3);
        assertArrayEquals(expected3, arr3);

        int[] arr4 = {};
        int[] expected4 = {};
        hs.heapSort(arr4);
        assertArrayEquals(expected4, arr4);
    }
}