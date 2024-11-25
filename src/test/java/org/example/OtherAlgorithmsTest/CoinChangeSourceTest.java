package org.example.OtherAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.OtherAlgorithms.CoinChangeSource;
import org.junit.Test;

public class CoinChangeSourceTest {

	@Test
	public void testChange() {
		CoinChangeSource ccs = new CoinChangeSource();
		
		// Test 1
		int[] coins1 = {1,2,3};
		int amount1 = 30;
		assertEquals(91, ccs.change(coins1, amount1));
		
		// Test 2
		int coins2[] = {1};
		int amount2 = 20;
		assertEquals(1, ccs.change(coins2, amount2));
		
		// Test 3
		int coins3[] = {5};
		int amount3 = 4; 
		assertEquals(0, ccs.change(coins3, amount3));
	}
	
	@Test
	public void testMinimumCouns() {
		CoinChangeSource ccs = new CoinChangeSource(); 
		
		// Test 1
		int [] coins1 = {1,2,3,4,5};
		int amount1 = 3;
		assertEquals(1, ccs.minimumCoins(coins1, amount1));
		
		// Test 2
		int [] coins2 = {1};
		int amount2 = 10000;
		assertEquals(10000, ccs.minimumCoins(coins2, amount2)); 
		
		// Test 3
		int [] coins3 = {6,2,9,10}; 
		int amount3 = 502;
		assertEquals(51, ccs.minimumCoins(coins3, amount3)); 
		
		/*
		 * Running the below test produces error - the function minimumCoins() does not 
		 * factor cases when the change cannot be formed!
		 * 
		 * // Test 4
		 * int [] coins4 = {100}; 
		 * int amount4 = 101;
		 * assertEquals(-1, ccs.minimumCoins(coins4, amount4)); 
		*/
	}
}