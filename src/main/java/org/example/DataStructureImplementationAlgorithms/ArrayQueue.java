package org.example.DataStructureImplementationAlgorithms;

public class ArrayQueue {
    private int[] queue;
    private int front, rear, capacity, size;

    // Constructor to initialize the queue
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue an element into the queue
    public void enqueue(int value) {
        if (isFull()) {
            throw new IllegalStateException("Queue Overflow");
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
    }

    // Dequeue an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue Underflow");
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        return value;
    }

    // Peek at the front element of the queue
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the size of the queue
    public int size() {
        return size;
    }
}