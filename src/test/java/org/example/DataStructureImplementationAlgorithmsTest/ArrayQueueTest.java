package org.example.DataStructureImplementationAlgorithmsTest;

import static org.junit.Assert.*;

import org.example.DataStructureImplementationAlgorithms.ArrayQueue;
import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
    private ArrayQueue queue;

    @Before
    public void setUp() {
        queue = new ArrayQueue(5); // Initialize a queue with capacity 5
    }

    @Test
    public void testEnqueueAndDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
    }

    @Test
    public void testPeek() {
        queue.enqueue(15);
        queue.enqueue(25);

        assertEquals(15, queue.peek());
        assertEquals(15, queue.dequeue());
        assertEquals(25, queue.peek());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());

        queue.enqueue(5);
        assertFalse(queue.isEmpty());

        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertTrue(queue.isFull());

        queue.dequeue();
        assertFalse(queue.isFull());
    }

    @Test(expected = IllegalStateException.class)
    public void testQueueOverflow() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        // This should throw a Queue Overflow exception
        queue.enqueue(6);
    }

    @Test(expected = IllegalStateException.class)
    public void testQueueUnderflow() {
        // This should throw a Queue Underflow exception
        queue.dequeue();
    }

    @Test
    public void testSize() {
        assertEquals(0, queue.size());

        queue.enqueue(10);
        queue.enqueue(20);

        assertEquals(2, queue.size());

        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    public void testCircularQueueBehavior() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());

        queue.enqueue(6);
        queue.enqueue(7);

        assertEquals(3, queue.dequeue());
        assertEquals(4, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(6, queue.dequeue());
        assertEquals(7, queue.dequeue());
    }
}