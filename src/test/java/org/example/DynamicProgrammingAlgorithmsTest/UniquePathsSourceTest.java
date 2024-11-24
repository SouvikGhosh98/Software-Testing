package org.example.DynamicProgrammingAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.DynamicProgrammingAlgorithms.UniquePathsSource;
import org.junit.Test;

public class UniquePathsSourceTest {

	@Test
	public void testUniquePathsDP() {
		// Test 1
		int m1 = 1;
		int n1 = 1;
		assertEquals(1, UniquePathsSource.uniquePathsDP(m1, n1));

		// Test 2
		int m2 = 1;
		int n2 = 100;
		assertEquals(1, UniquePathsSource.uniquePathsDP(m2, n2));

		// Test 3
		int m3 = 5;
		int n3 = 100;
		assertEquals(4421275, UniquePathsSource.uniquePathsDP(m3, n3));

		// Test 4
		int m4 = 4;
		int n4 = 4;
		assertEquals(20, UniquePathsSource.uniquePathsDP(m4, n4));
	}

	@Test
	public void testUniquePathsNaive() {
		// Test 1
		int m1 = 1;
		int n1 = 1;
		assertEquals(1, UniquePathsSource.uniquePathsNaive(m1, n1));

		// Test 2
		int m2 = 10;
		int n2 = 10;
		assertEquals(48620, UniquePathsSource.uniquePathsNaive(m2, n2));

		// Test 3
		int m3 = 50;
		int n3 = 9;

		assertEquals(1652411475, UniquePathsSource.uniquePathsNaive(m3, n3));
	}
}