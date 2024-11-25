package org.example.OtherAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.OtherAlgorithms.LongestValidParenthesisSource;
import org.junit.Test;

public class LongestValidParenthesisSourceTest {

	@Test
	public void testGetLongestValidParentheses() {
		LongestValidParenthesisSource lpss = new LongestValidParenthesisSource();
		
		// Test 1
		String s1 = "";
		assertEquals(0, lpss.getLongestValidParentheses(s1));
		
		// Test 2
		String s2 = ")("; 
		assertEquals(0, lpss.getLongestValidParentheses(s2)); 
		
		// Test 3
		String s3 = "("; 
		assertEquals(0, lpss.getLongestValidParentheses(s3)); 
		
		// Test 4
		String s4 = "()";
		assertEquals(2, lpss.getLongestValidParentheses(s4)); 
		
		// Test 5
		String s5 = "((((())))))"; 
		assertEquals(10, lpss.getLongestValidParentheses(s5)); 
		
		// Test 6
		String s6 = "))))((((("; 
		assertEquals(0, lpss.getLongestValidParentheses(s6)); 
		
		// Test 7
		String s7 = "(()()()()()()())";
		assertEquals(16, lpss.getLongestValidParentheses(s7)); 
		
		// Test 8
		String s8 = "((((()(())((((((()"; 
		assertEquals(6, lpss.getLongestValidParentheses(s8)); 
	}

}
