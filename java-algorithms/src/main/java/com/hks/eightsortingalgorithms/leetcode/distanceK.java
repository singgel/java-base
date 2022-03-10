package com.hks.eightsortingalgorithms.leetcode;

import java.util.*;

public class distanceK {
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

    // 记录父节点：node.val -> parentNode
    // 题目说了树中所有节点值都是唯一的，所以可以用 node.val 代表 TreeNode
    HashMap<Integer, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // 遍历所有节点，记录每个节点的父节点
        traverse(root, null);

        // 开始从 target 节点施放 BFS 算法，找到距离为 k 的节点
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(target);
        visited.add(target.val);
        // 记录离 target 的距离
        int dist = 0;
        List<Integer> res = new LinkedList<>();

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if(dist == k) {
                    res.add(cur.val);
                }
                TreeNode par = parent.get(cur.val);
                if(par != null && !visited.contains(par.val)) {
                    q.offer(par);
                    visited.add(par.val);
                }
                if(cur.left != null && !visited.contains(par.val)) {
                    q.offer(cur.left);
                    visited.add(cur.left.val);
                }
                if(cur.right != null && !visited.contains(par.val)) {
                    q.offer(cur.right);
                    visited.add(cur.right.val);
                }
            }
            dist++;
        }

        return res;
    }

    private void traverse(TreeNode root, TreeNode parentNode) {
        if (root == null) {
            return;
        }
        parent.put(root.val, parentNode);
        // 二叉树递归框架
        traverse(root.left, root);
        traverse(root.right, root);
    }

}
