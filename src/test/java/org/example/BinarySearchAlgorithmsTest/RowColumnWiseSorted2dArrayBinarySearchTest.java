package org.example.BinarySearchAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.BinarySearchAlgorithms.RowColumnWiseSorted2dArrayBinarySearch;
import org.junit.Test;

public class RowColumnWiseSorted2dArrayBinarySearchTest {
	@Test
	public void rowColumnSorted2dArrayBinarySearchTestMiddle() {
		Integer[][] arr1 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans1 = RowColumnWiseSorted2dArrayBinarySearch.search(arr1, 35);
		assertEquals(1, ans1[0]);
		assertEquals(2, ans1[1]);
		
		Integer[][] arr2 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans2 = RowColumnWiseSorted2dArrayBinarySearch.search(arr2, 48);
		assertEquals(2, ans2[0]);
		assertEquals(3, ans2[1]);
		
		Integer[][] arr3 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans3 = RowColumnWiseSorted2dArrayBinarySearch.search(arr3, 40);
		assertEquals(0, ans3[0]);
		assertEquals(3, ans3[1]);
		
		Integer[][] arr4 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans4 = RowColumnWiseSorted2dArrayBinarySearch.search(arr4, 20);
		assertEquals(0, ans4[0]);
		assertEquals(1, ans4[1]);
		
		Integer[][] arr5 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans5 = RowColumnWiseSorted2dArrayBinarySearch.search(arr5, 31);
		assertEquals(3, ans5[0]);
		assertEquals(1, ans5[1]);
		
		Integer[][] arr6 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans6 = RowColumnWiseSorted2dArrayBinarySearch.search(arr6, 51);
		assertEquals(3, ans6[0]);
		assertEquals(3, ans6[1]);
		
		Integer[][] arr7 = {
				{ 10, 20, 30, 40 },
				{ 15, 25, 35, 45 },
				{ 18, 28, 38, 48 },
				{ 21, 31, 41, 51 },
		};
		int[] ans7 = RowColumnWiseSorted2dArrayBinarySearch.search(arr7, 101);
		assertEquals(-1, ans7[0]);
		assertEquals(-1, ans7[1]);
	}
}