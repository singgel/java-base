package com.hks.eightsortingalgorithms.leetcode;

public class traverTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverTree(root);
        return max;
    }

    int traverTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = traverTree(node.left);
        int right = traverTree(node.right);
        int sum = node.val + left+right;
        max = Math.max(max,sum);

        return Math.max(0,node.val+Math.max(left,right));
    }

}
