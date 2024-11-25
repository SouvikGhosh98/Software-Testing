package org.example.TreeAlgorithmsTest;

import org.example.TreeAlgorithms.BinaryTreeTraversal2;
import org.example.TreeAlgorithms.TreeNode;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class BinaryTreeTraversal2Test {

    private BinaryTreeTraversal2 binaryTree;
    private TreeNode root;

    @Before
    public void setUp() {
        binaryTree = new BinaryTreeTraversal2();
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
    }

    @Test
    public void testBoundaryTraversal() {
        List<Integer> expected = Arrays.asList(1, 2, 4, 8, 9, 5, 6, 7, 3);
        assertEquals(expected, binaryTree.boundaryTraversal(root));
    }

    @Test
    public void testVerticalOrder() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(8),
                Arrays.asList(4),
                Arrays.asList(2, 9),
                Arrays.asList(1, 5, 6),
                Arrays.asList(3),
                Arrays.asList(7)
        );
        assertEquals(expected, binaryTree.verticalOrder(root));
    }

    @Test
    public void testTopView() {
        List<Integer> expected = Arrays.asList(8, 4, 2, 1, 3, 7);
        assertEquals(expected, binaryTree.topView(root));
    }

    @Test
    public void testBottomView() {
        List<Integer> expected = Arrays.asList(8, 4, 9, 6, 3, 7);
        assertEquals(expected, binaryTree.bottomView(root));
    }

    @Test
    public void testRightView() {
        List<Integer> expected = Arrays.asList(1, 3, 7, 9);
        assertEquals(expected, binaryTree.rightView(root));
    }

    @Test
    public void testLeftView() {
        List<Integer> expected = Arrays.asList(1, 2, 4, 8);
        assertEquals(expected, binaryTree.leftView(root));
    }
}