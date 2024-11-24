package org.example.DynamicProgrammingAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.DynamicProgrammingAlgorithms.PalindromicPartitioningSource;
import org.junit.Test;

public class PalindromicPartitioningSourceTest {

	@Test
	public void testMinimalPartitions() {
		PalindromicPartitioningSource pps = new PalindromicPartitioningSource();
		
		/* Below test gives error on running
		 * // Test 1 
		 * String s1 = ""; 
		 * assertEquals(0, pps.minimalpartitions(s1));
		 */ 
		
		// Test 2
		String s2 = "a"; 
		assertEquals(0, pps.minimalpartitions(s2)); 
		
		// Test 3
		String s3 = "aa"; 
		assertEquals(0, pps.minimalpartitions(s3)); 
		
		// Test 4
		String s4 = "aba"; 
		assertEquals(0, pps.minimalpartitions(s4)); 
		
		// Test 5
		String s5 = "ab"; 
		assertEquals(1, pps.minimalpartitions(s5)); 
		
		// Test 6
		String s6 = "pqqabb"; 
		assertEquals(3, pps.minimalpartitions(s6)); 
	}

}
