package com.hks.eightsortingalgorithms.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class widthOfBinaryTree {
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
    // 记录节点和对应编号
    class Pair {
        TreeNode node;
        int id;

        public Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 记录最大的宽度
        int maxWidth = 0;
        // 标准 BFS 层序遍历算法
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));
        // 从上到下遍历整棵树
        while (!q.isEmpty()) {
            int sz = q.size();
            int start = 0, end = 0;
            // 从左到右遍历每一行
            for (int i = 0; i < sz; i++) {
                Pair cur = q.poll();
                TreeNode curNode = cur.node;
                int curId = cur.id;
                // 记录当前行第一个和最后一个节点的编号
                if (i == 0) {
                    start = curId;
                }
                if (i == sz - 1) {
                    end = curId;
                }
                // 左右子节点入队，同时记录对应节点的编号
                if (curNode.left != null) {
                    q.offer(new Pair(curNode.left, curId * 2));
                }
                if (curNode.right != null) {
                    q.offer(new Pair(curNode.right, curId * 2 + 1));
                }
            }
            // 用当前行的宽度更新最大宽度
            maxWidth = Math.max(maxWidth, end - start + 1);
        }
        return maxWidth;
    }
}
