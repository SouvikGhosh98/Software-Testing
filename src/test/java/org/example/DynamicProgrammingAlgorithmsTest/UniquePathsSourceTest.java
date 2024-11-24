package org.example.DynamicProgrammingAlgorithmsTest;
import static org.junit.Assert.assertEquals;

import org.example.DynamicProgrammingAlgorithms.UniquePathsSource;
import org.junit.Test;

public class UniquePathsSourceTest {

	@Test
	public void testUniquePathsDP() {
		UniquePathsSource ups = new UniquePathsSource();
		
		// Test 1
		int m1 = 1;
		int n1 = 1;
		assertEquals(1, ups.uniquePathsDP(m1, n1));
		
		// Test 2
		int m2 = 1; 
		int n2 = 100; 
		assertEquals(1, ups.uniquePathsDP(m2, n2)); 
		
		// Test 3
		int m3 = 5;
		int n3 = 100; 
		assertEquals(4421275, ups.uniquePathsDP(m3, n3)); 
		
		// Test 4
		int m4 = 4;
		int n4 = 4;
		assertEquals(20, ups.uniquePathsDP(m4, n4)); 
	}
	
	@Test
	public void testUniquePathsNaive() {
		UniquePathsSource ups = new UniquePathsSource(); 
		
		// Test 1
		int m1 = 1;
		int n1 = 1;
		assertEquals(1, ups.uniquePathsNaive(m1, n1));
		
		// Test 2
		int m2 = 10;
		int n2 = 10;
		assertEquals(48620, ups.uniquePathsNaive(m2, n2)); 
		
		// Test 3
		int m3 = 50;
		int n3 = 9;
		
		assertEquals(1652411475, ups.uniquePathsNaive(m3, n3)); 
	}
}