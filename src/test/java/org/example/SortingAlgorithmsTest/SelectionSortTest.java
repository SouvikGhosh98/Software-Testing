package org.example.SortingAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import org.example.SortingAlgorithms.SelectionSort;
import org.junit.Test;

public class SelectionSortTest {

    @Test
    public void testSelectionSort() {
        SelectionSort ss = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};
        int[] expected = {11, 12, 22, 25, 64};
        ss.selectionSort(arr);
        assertArrayEquals(expected, arr);

        int[] arr2 = {3, 2, 1};
        int[] expected2 = {1, 2, 3};
        ss.selectionSort(arr2);
        assertArrayEquals(expected2, arr2);

        int[] arr3 = {1};
        int[] expected3 = {1};
        ss.selectionSort(arr3);
        assertArrayEquals(expected3, arr3);

        int[] arr4 = {};
        int[] expected4 = {};
        ss.selectionSort(arr4);
        assertArrayEquals(expected4, arr4);
    }
}