package org.example.SortingAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import org.example.SortingAlgorithms.MergeSort;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        MergeSort ms = new MergeSort();
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};
        ms.mergeSort(arr, 0, arr.length - 1);
        assertArrayEquals(expected, arr);

        int[] arr2 = {4, 3, 2, 1};
        int[] expected2 = {1, 2, 3, 4};
        ms.mergeSort(arr2, 0, arr2.length - 1);
        assertArrayEquals(expected2, arr2);

        int[] arr3 = {3};
        int[] expected3 = {3};
        ms.mergeSort(arr3, 0, arr3.length - 1);
        assertArrayEquals(expected3, arr3);

        int[] arr4 = {};
        int[] expected4 = {};
        ms.mergeSort(arr4, 0, arr4.length - 1);
        assertArrayEquals(expected4, arr4);
    }
}