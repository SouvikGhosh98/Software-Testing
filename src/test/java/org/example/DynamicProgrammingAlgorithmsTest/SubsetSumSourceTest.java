package org.example.DynamicProgrammingAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.DynamicProgrammingAlgorithms.SubsetSumSource;
import org.junit.Test;

public class SubsetSumSourceTest {

	@Test
	public void testSubsetSum() {
		SubsetSumSource sss = new SubsetSumSource();
		
		// Test 1
		int arr1[] = {1,2,3}; 
		int sumToCheck1 = 7;
		assertEquals(false, sss.subsetSum(arr1, sumToCheck1)); 
		
		// Test 2
		int arr2[] = {1,2,3}; 
		int sumToCheck2 = 5;
		assertEquals(true, sss.subsetSum(arr2, sumToCheck2)); 
		
		// Test 3
		int arr3[] = {}; 
		int sumToCheck3 = 10;
		assertEquals(false, sss.subsetSum(arr3, sumToCheck3)); 
		
		// Test 4
		int arr4[] = {};
		int sumToCheck4 = 0;
		assertEquals(true, sss.subsetSum(arr4, sumToCheck4));
		
		// Test 5
		int arr5[] = {1,2,3};
		int sumToCheck5 = 0;
		assertEquals(true, sss.subsetSum(arr5, sumToCheck5)); 
		
		// Test 6
		int arr6[] = {100, 200, 300, 400, 500, 600}; 
		int sumToCheck6 = 2101;
		assertEquals(false, sss.subsetSum(arr6, sumToCheck6));
		
		/* We found a bug - uncommenting below test fails the mutation process
		* // Test 7
		* int arr7[] = {-1,-2,-100};
		* int sumToCheck7 = -102;
		* assertEquals(true, sss.subsetSum(arr7, sumToCheck7)); 
		*/ 
		
		// Test 8
		int[] arr8 = {1,4,10,1,3}; 
		int sumToCheck8 = 8;
		assertEquals(true, sss.subsetSum(arr8, sumToCheck8)); 
	}

}
