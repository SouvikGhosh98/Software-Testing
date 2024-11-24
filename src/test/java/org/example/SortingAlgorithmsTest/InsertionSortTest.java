package org.example.SortingAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import org.example.SortingAlgorithms.InsertionSort;
import org.junit.Test;

public class InsertionSortTest {

    @Test
    public void testInsertionSort() {
        InsertionSort is = new InsertionSort();
        int[] arr = {12, 11, 13, 5, 6};
        int[] expected = {5, 6, 11, 12, 13};
        is.insertionSort(arr);
        assertArrayEquals(expected, arr);

        int[] arr2 = {3, -1, 0, 2};
        int[] expected2 = {-1, 0, 2, 3};
        is.insertionSort(arr2);
        assertArrayEquals(expected2, arr2);

        int[] arr3 = {1};
        int[] expected3 = {1};
        is.insertionSort(arr3);
        assertArrayEquals(expected3, arr3);

        int[] arr4 = {};
        int[] expected4 = {};
        is.insertionSort(arr4);
        assertArrayEquals(expected4, arr4);
    }
}