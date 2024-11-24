package org.example.DataStructureImplementationAlgorithms;

import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer, Node> cache;
    private final Node head, tail;

    // Node structure for doubly linked list
    private static class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Get a value by key
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insert(node); // Move node to the front
        return node.value;
    }

    // Put a key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        } else if (cache.size() == capacity) {
            cache.remove(tail.prev.key); // Remove LRU
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);
    }

    // Remove a node from the doubly linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node at the front of the doubly linked list
    private void insert(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}