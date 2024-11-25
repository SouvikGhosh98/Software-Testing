package org.example.TreeAlgorithmsTest;

import static org.junit.Assert.assertEquals;

import org.example.TreeAlgorithms.BinaryTreeTraversal;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class BinaryTreeTraversalTest {
    private BinaryTreeTraversal binaryTree;

    @Before
    public void setUp() {
        binaryTree = new BinaryTreeTraversal();
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(70);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(60);
        binaryTree.insert(80);
    }

    @Test
    public void testIterativeInorder() {
        assertEquals(
                Arrays.asList(20, 30, 40, 50, 60, 70, 80),
                binaryTree.iterativeInorder()
        );
    }

    @Test
    public void testIterativePreorder() {
        assertEquals(
                Arrays.asList(50, 30, 20, 40, 70, 60, 80),
                binaryTree.iterativePreorder()
        );
    }

    @Test
    public void testIterativePostorder() {
        assertEquals(
                Arrays.asList(20, 40, 30, 60, 80, 70, 50),
                binaryTree.iterativePostorder()
        );
    }

    @Test
    public void testEmptyTree() {
        BinaryTreeTraversal emptyTree = new BinaryTreeTraversal();
        assertEquals(Arrays.asList(), emptyTree.iterativeInorder());
        assertEquals(Arrays.asList(), emptyTree.iterativePreorder());
        assertEquals(Arrays.asList(), emptyTree.iterativePostorder());
    }
}