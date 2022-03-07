package com.hks.eightsortingalgorithms.leetcode;

public class maxDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int deep = 0, maxDepth = 0;

    public int maxDepth(TreeNode root) {
        traverTree(root);
        return maxDepth;
    }

    void traverTree(TreeNode node) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, deep);
            return;
        }
        deep++;
        traverTree(node.left);
        traverTree(node.right);
        deep--;
    }
}
