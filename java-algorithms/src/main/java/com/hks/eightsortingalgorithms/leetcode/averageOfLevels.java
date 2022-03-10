package com.hks.eightsortingalgorithms.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class averageOfLevels {
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
    
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> dq = new LinkedList<>();
        dq.offer(root);

        while(!dq.isEmpty()) {
            int size = dq.size();
            double levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = dq.poll();
                levelSum += node.val;
                if(node.left != null) {
                    dq.offer(node.left);
                }
                if(node.right != null) {
                    dq.offer(node.right);
                }
            }
            res.add(1.0 * levelSum / size);
        }
        return res;
    }
}
