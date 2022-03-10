package com.hks.eightsortingalgorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class isCompleteTree {
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

    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> dq = new LinkedList<>();
        dq.add(root);
        boolean flag = false;

        while(!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                if(node == null) {
                    flag = true;
                } else {
                    if(flag) {
                        return false;
                    }
                    dq.offer(node.left);
                    dq.offer(node.right);
                }
            }
        }
        return true;
    }

}
