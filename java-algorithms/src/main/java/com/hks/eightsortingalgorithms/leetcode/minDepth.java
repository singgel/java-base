package com.hks.eightsortingalgorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
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
    
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);
        int minDeep = 1;

        while(!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if(node.left == null && node.right == null) {
                    return minDeep;
                }
                if(node.left != null) {
                    dq.offer(node.left);
                }
                if(node.right != null) {
                    dq.offer(node.right);
                }
            }
            minDeep++;
        }
        return minDeep;
    }
}
