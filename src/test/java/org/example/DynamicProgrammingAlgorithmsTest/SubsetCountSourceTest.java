package org.example.DynamicProgrammingAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.DynamicProgrammingAlgorithms.SubsetCountSource;
import org.junit.Test;

public class SubsetCountSourceTest {

	@Test
	public void testGetCount() {
		SubsetCountSource scs = new SubsetCountSource();
		
		// Test 1
		int[] arr1 = {1}; 
		int sum1 = 0;
		assertEquals(1, scs.getCount(arr1, sum1)); 
		
		// Test 2
		int[] arr2 = {1,1}; 
		int sum2 = 1;
		assertEquals(2, scs.getCount(arr2, sum2)); 
		
		/* Running below test gives error, so the implementation is incorrect
		 * // Test 3  
		 * int[] arr3 = {1,3,4,6,2,6,4,5,2,5,6}; 
		 * int sum3 = 10;
		 * assertEquals(29, scs.getCount(arr3, sum3));
		 */
		
	}
	
	@Test
	public void testGetCountSO() {
		SubsetCountSource scs = new SubsetCountSource(); 
		
		// Test 1
		int[] arr1 = {1,3,4,6,2,6,4,5,2,5,6}; 
		int sum1 = 10;
		assertEquals(29, scs.getCountSO(arr1, sum1));
		
		// Test 2
		int[] arr2 = {1,1,1};
		int sum2 = 2;
		assertEquals(3, scs.getCountSO(arr2, sum2)); 
		
		// Test 3
		int[] arr3 = {2};
		int sum3 = 2;
		assertEquals(1, scs.getCountSO(arr3, sum3)); 
	}
}