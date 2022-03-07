package com.hks.eightsortingalgorithms.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
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
    
    /* BFS 层序遍历解法 */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        // BFS 层序遍历，计算右侧视图
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // while 循环控制从上向下一层层遍历
        while (!q.isEmpty()) {
            int sz = q.size();
            // 每一层头部就是最右侧的元素
            TreeNode last = q.peek();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 控制每一层从右向左遍历
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
            }
            // 每一层的最后一个节点就是二叉树的右侧视图
            res.add(last.val);
        }
        return res;
    }
}
