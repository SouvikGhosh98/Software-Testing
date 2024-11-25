package org.example.TreeAlgorithmsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.example.TreeAlgorithms.AVLTree;
import org.junit.Before;
import org.junit.Test;

public class AVLTreeTest {
    private AVLTree tree;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        tree = new AVLTree();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void testInsertionAndInorderTraversal() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        outputStream.reset();
        tree.inorder();
        assertEquals("10 20 25 30 40 50", outputStream.toString().trim());
    }

    @Test
    public void testDeletion() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        tree.delete(25);
        outputStream.reset();
        tree.inorder();
        assertEquals("10 20 30 40 50", outputStream.toString().trim());
    }

    @Test
    public void testSearch() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        assertTrue(tree.search(10));
        assertTrue(tree.search(30));
        assertFalse(tree.search(25));
    }

    @Test
    public void testPreorderTraversal() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        outputStream.reset();
        tree.preorder();
        assertEquals("30 20 10 25 40 50", outputStream.toString().trim());
    }

    @Test
    public void testPostorderTraversal() {
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        outputStream.reset();
        tree.postorder();
        assertEquals("10 25 20 50 40 30", outputStream.toString().trim());
    }

    @Test
    public void testEmptyTreeTraversal() {
        outputStream.reset();
        tree.inorder();
        assertEquals("", outputStream.toString().trim());

        outputStream.reset();
        tree.preorder();
        assertEquals("", outputStream.toString().trim());

        outputStream.reset();
        tree.postorder();
        assertEquals("", outputStream.toString().trim());
    }
}