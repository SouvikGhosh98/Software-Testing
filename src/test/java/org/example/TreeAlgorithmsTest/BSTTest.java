package org.example.TreeAlgorithmsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.example.TreeAlgorithms.BST;
import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    private BST bst;

    @Before
    public void setUp() {
        bst = new BST();
    }

    @Test
    public void testInsertionAndInorderTraversal() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        assertEquals("20 30 40 50 60 70 80", bst.inorder());
    }

    @Test
    public void testSearch() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        assertTrue(bst.search(30));
        assertTrue(bst.search(70));
        assertFalse(bst.search(100));
        assertFalse(bst.search(10));
    }

    @Test
    public void testDeleteLeafNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        bst.delete(20);
        assertEquals("30 40 50 70", bst.inorder());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(35);

        bst.delete(40);
        assertEquals("20 30 35 50 70", bst.inorder());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.delete(50);
        assertEquals("20 30 40 60 70 80", bst.inorder());
    }

    @Test
    public void testDeleteNonExistentNode() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);

        bst.delete(100);
        assertEquals("30 50 70", bst.inorder());
    }

    @Test
    public void testEmptyTree() {
        assertEquals("", bst.inorder());

        assertFalse(bst.search(10));
        bst.delete(10); // Should not throw an exception
    }
}