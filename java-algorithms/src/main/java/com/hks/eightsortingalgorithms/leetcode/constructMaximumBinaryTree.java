package com.hks.eightsortingalgorithms.leetcode;

public class constructMaximumBinaryTree {
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
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null||nums.length==0) {
            return null;
        }
        if(nums.length==1){
            return new TreeNode(nums[0]);
        }
        return dfs(nums, 0, nums.length-1);
    }

    TreeNode dfs(int[] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        int index = -1, max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            if(nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, left, index-1);
        root.right = dfs(nums, index+1, right);
        return root;
    }
}
