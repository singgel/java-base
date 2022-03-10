package com.hks.eightsortingalgorithms.leetcode;

public class distributeCoins {
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
    
    public int distributeCoins(TreeNode root) {
        getRest(root);
        return res;
    }

    int res = 0;

    // 定义：输入一棵二叉树，返回这棵二叉树中多出的硬币个数，返回负数代表缺少硬币
    int getRest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getRest(root.left);
        int right = getRest(root.right);
        // 让当前这棵树平衡所需的移动次数
        res += Math.abs(left) + Math.abs(right) + (root.val - 1);
        // 实现函数的定义
        return left + right + (root.val - 1);
    }
}
