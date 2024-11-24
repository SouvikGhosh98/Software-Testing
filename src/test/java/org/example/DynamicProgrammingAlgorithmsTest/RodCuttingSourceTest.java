package org.example.DynamicProgrammingAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.DynamicProgrammingAlgorithms.RodCuttingSource;
import org.junit.Test;

public class RodCuttingSourceTest {

	@Test
	public void test() {
		RodCuttingSource rcs = new RodCuttingSource();
		
		// Test 1
		int[] arr1 = {1}; 
		assertEquals(1, rcs.cutRod(arr1, arr1.length)); 
		
		// Test 2
		int[] arr2 = {1,2,3,4}; 
		assertEquals(4, rcs.cutRod(arr2, arr2.length)); 
		
		// Test 3
		int[] arr3 = {1,1,1,102,100}; 
		assertEquals(103, rcs.cutRod(arr3, arr3.length)); 
	}

}
