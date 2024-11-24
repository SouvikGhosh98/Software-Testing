package org.example.SortingAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import org.example.SortingAlgorithms.QuickSort;
import org.junit.Test;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        QuickSort qs = new QuickSort();
        int[] arr = {10, 7, 8, 9, 1, 5};
        int[] expected = {1, 5, 7, 8, 9, 10};
        qs.quickSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);

        int[] arr2 = {4, -3, 0, 2, 1};
        int[] expected2 = {-3, 0, 1, 2, 4};
        qs.quickSort(arr2, 0, arr2.length - 1);
        assertArrayEquals(expected2, arr2);

        int[] arr3 = {3};
        int[] expected3 = {3};
        qs.quickSort(arr3, 0, arr3.length - 1);
        assertArrayEquals(expected3, arr3);

        int[] arr4 = {};
        int[] expected4 = {};
        qs.quickSort(arr4, 0, arr4.length - 1);
        assertArrayEquals(expected4, arr4);
    }
}