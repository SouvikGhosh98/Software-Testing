package org.example.DataStructureImplementationAlgorithms;

public class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1;
    }

    // Push an element onto the stack
    public void push(int value) {
        if (isFull()) {
            throw new IllegalStateException("Stack Overflow");
        }
        stack[++top] = value;
    }

    // Pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        return stack[top--];
    }

    // Peek at the top element of the stack
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if the stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }
}