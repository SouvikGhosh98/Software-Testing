package org.example.BinarySearchAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.BinarySearchAlgorithms.BinarySearch;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void testBinarySearch() {
		BinarySearch bs = new BinarySearch();
		int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34};
		assertEquals(-1, bs.binarySearch(arr, -1));
		assertEquals(-1, bs.binarySearch(arr, 35));
		assertEquals(-1, bs.binarySearch(arr, 100));
		assertEquals(-1, bs.binarySearch(arr, -100));
		assertEquals(17, bs.binarySearch(arr, 17));
		assertEquals(34, bs.binarySearch(arr, 34));
		assertEquals(0, bs.binarySearch(arr, 0));
		assertEquals(5, bs.binarySearch(arr, 5));
		assertEquals(9, bs.binarySearch(arr, 9));
		assertEquals(26, bs.binarySearch(arr, 26));
		assertEquals(21, bs.binarySearch(arr, 21));
		assertEquals(30, bs.binarySearch(arr, 30));
	}

}