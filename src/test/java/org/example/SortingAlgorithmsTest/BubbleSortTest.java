package org.example.SortingAlgorithmsTest;

import static org.junit.Assert.assertArrayEquals;

import org.example.SortingAlgorithms.BubbleSort;
import org.junit.Test;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        BubbleSort bs = new BubbleSort();
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};
        bs.bubbleSort(arr);
        assertArrayEquals(expected, arr);

        int[] arr2 = {3, 0, -2, 10, 7};
        int[] expected2 = {-2, 0, 3, 7, 10};
        bs.bubbleSort(arr2);
        assertArrayEquals(expected2, arr2);

        int[] arr3 = {1};
        int[] expected3 = {1};
        bs.bubbleSort(arr3);
        assertArrayEquals(expected3, arr3);

        int[] arr4 = {};
        int[] expected4 = {};
        bs.bubbleSort(arr4);
        assertArrayEquals(expected4, arr4);
    }
}