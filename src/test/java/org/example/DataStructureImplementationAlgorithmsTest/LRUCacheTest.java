package org.example.DataStructureImplementationAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.DataStructureImplementationAlgorithms.LRUCache;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    private LRUCache lruCache;

    @Before
    public void setUp() {
        lruCache = new LRUCache(3); // Capacity = 3
    }

    @Test
    public void testBasicOperations() {
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);

        // Check existing keys
        assertEquals(10, lruCache.get(1));
        assertEquals(20, lruCache.get(2));
        assertEquals(30, lruCache.get(3));

        // Check non-existent key
        assertEquals(-1, lruCache.get(4));
    }

    @Test
    public void testEvictionPolicy() {
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);

        // Access key 1 to make it recently used
        assertEquals(10, lruCache.get(1));

        // Add a new key, causing key 2 to be evicted (LRU)
        lruCache.put(4, 40);

        // Check eviction and presence
        assertEquals(-1, lruCache.get(2)); // Key 2 should be evicted
        assertEquals(10, lruCache.get(1)); // Key 1 should still be present
        assertEquals(30, lruCache.get(3));
        assertEquals(40, lruCache.get(4));
    }

    @Test
    public void testUpdateValue() {
        lruCache.put(1, 10);
        lruCache.put(2, 20);
        lruCache.put(3, 30);

        // Update key 2's value
        lruCache.put(2, 200);

        // Check updated value
        assertEquals(200, lruCache.get(2));

        // Ensure order and values are correct
        lruCache.put(4, 40); // Key 1 should be evicted
        assertEquals(-1, lruCache.get(1));
        assertEquals(200, lruCache.get(2));
        assertEquals(30, lruCache.get(3));
        assertEquals(40, lruCache.get(4));
    }

    @Test
    public void testSingleCapacity() {
        LRUCache singleCapacityCache = new LRUCache(1);
        singleCapacityCache.put(1, 10);
        assertEquals(10, singleCapacityCache.get(1));

        singleCapacityCache.put(2, 20); // Key 1 should be evicted
        assertEquals(-1, singleCapacityCache.get(1));
        assertEquals(20, singleCapacityCache.get(2));
    }
}