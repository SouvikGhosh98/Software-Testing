package org.example.OtherAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.OtherAlgorithms.CountInversions;
import org.junit.Test;

public class CountInversionsTest {

    @Test
    public void testCountInversions() {
        CountInversions ci = new CountInversions();

        // Test Case 1: General case
        int[] arr1 = {8, 4, 2, 1};
        assertEquals(6, ci.countInversions(arr1));

        // Test Case 2: Already sorted array
        int[] arr2 = {1, 2, 3, 4};
        assertEquals(0, ci.countInversions(arr2));

        // Test Case 3: Reverse sorted array
        int[] arr3 = {4, 3, 2, 1};
        assertEquals(6, ci.countInversions(arr3));

        // Test Case 4: Array with duplicates
        int[] arr4 = {2, 3, 3, 2};
        assertEquals(2, ci.countInversions(arr4));

        // Test Case 5: Single element
        int[] arr5 = {1};
        assertEquals(0, ci.countInversions(arr5));

        // Test Case 6: Empty array
        int[] arr6 = {};
        assertEquals(0, ci.countInversions(arr6));

        // Test Case 7: Large array
        int[] arr7 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertEquals(45, ci.countInversions(arr7));
    }
}