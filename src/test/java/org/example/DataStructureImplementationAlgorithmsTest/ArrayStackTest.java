package org.example.DataStructureImplementationAlgorithmsTest;

import static org.junit.Assert.*;

import org.example.DataStructureImplementationAlgorithms.ArrayStack;
import org.junit.Before;
import org.junit.Test;

public class ArrayStackTest {
    private ArrayStack stack;

    @Before
    public void setUp() {
        stack = new ArrayStack(5); // Initialize a stack with capacity 5
    }

    @Test
    public void testPushAndPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop());
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    public void testPeek() {
        stack.push(15);
        stack.push(25);

        assertEquals(25, stack.peek());
        assertEquals(25, stack.pop());
        assertEquals(15, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());

        stack.push(5);
        assertFalse(stack.isEmpty());

        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertTrue(stack.isFull());

        stack.pop();
        assertFalse(stack.isFull());
    }

    @Test(expected = IllegalStateException.class)
    public void testStackOverflow() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // This should throw a Stack Overflow exception
        stack.push(6);
    }

    @Test(expected = IllegalStateException.class)
    public void testStackUnderflow() {
        // This should throw a Stack Underflow exception
        stack.pop();
    }

    @Test
    public void testSize() {
        assertEquals(0, stack.size());

        stack.push(10);
        stack.push(20);

        assertEquals(2, stack.size());

        stack.pop();
        assertEquals(1, stack.size());
    }
}