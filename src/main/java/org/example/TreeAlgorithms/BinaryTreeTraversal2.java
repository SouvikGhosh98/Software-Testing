package org.example.TreeAlgorithms;

import java.util.*;

public class BinaryTreeTraversal2 {

    // Boundary Traversal of Binary Tree
    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.add(root.val);

        // Left boundary (excluding leaf nodes)
        TreeNode curr = root.left;
        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                result.add(curr.val);
            }
            curr = (curr.left != null) ? curr.left : curr.right;
        }

        // Leaf nodes (left to right)
        addLeaves(root, result);

        // Right boundary (excluding leaf nodes)
        List<Integer> rightBoundary = new ArrayList<>();
        curr = root.right;
        while (curr != null) {
            if (curr.left != null || curr.right != null) {
                rightBoundary.add(curr.val);
            }
            curr = (curr.right != null) ? curr.right : curr.left;
        }
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);

        return result;
    }

    private void addLeaves(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }
        addLeaves(root.left, result);
        addLeaves(root.right, result);
    }

    // Vertical Order Traversal
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(new Pair<>(root, 0));
        }

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();
            map.putIfAbsent(column, new ArrayList<>());
            map.get(column).add(node.val);

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, column + 1));
            }
        }

        return new ArrayList<>(map.values());
    }

    // Top View of Binary Tree
    public List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int hd = pair.getValue();

            if (!map.containsKey(hd)) {
                map.put(hd, node.val);
            }

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }

    // Bottom View of Binary Tree
    public List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int hd = pair.getValue();

            map.put(hd, node.val);

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, hd - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, hd + 1));
            }
        }

        result.addAll(map.values());
        return result;
    }

    // Right View of Binary Tree
    public List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }

    // Left View of Binary Tree
    public List<Integer> leftView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }
}