package com.hks.eightsortingalgorithms.leetcode;

public class invertTree {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    
    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return root;
        }
        invertTree(root.left);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.right);
        return root;
    }
}
