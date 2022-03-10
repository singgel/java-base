package com.hks.eightsortingalgorithms.leetcode;

public class isSymmetric {
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
    
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return duichenTree(root.left, root.right);
    }
    
    boolean duichenTree(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null || left.val != right.val) {
            return false;
        }
        return duichenTree(left.left, right.right) && duichenTree(left.right, right.left);
    }
}
