package com.hks.eightsortingalgorithms.leetcode;

public class maxProductTree {
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

    long res = 0;
    int treeSum = 0;

    public int maxProduct(TreeNode root) {
        // 先利用求和函数得到整棵树的节点之和
        treeSum = getSum(root);
        // 再次调用，利用后序位置计算子树之积
        getSum(root);
        return (int) (res % (1e9 + 7));
    }

    int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);
        int rootSum = left + right + root.val;
        res = Math.max(res, rootSum * (treeSum - rootSum));
        return rootSum;
    }
}
