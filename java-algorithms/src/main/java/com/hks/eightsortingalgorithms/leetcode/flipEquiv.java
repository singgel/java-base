package com.hks.eightsortingalgorithms.leetcode;

public class flipEquiv {
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

    // 定义：输入两棵二叉树，判断这两棵二叉树是否是翻转等价的
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return true;
        }
        return flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
    }

}
