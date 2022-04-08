package com.hks.eightsortingalgorithms.leetcode;

import java.util.LinkedList;
import java.util.List;

public class binaryTreePaths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        // 遍历一遍二叉树就能出结果了
        traverse(root);
        return res;
    }

    // 记录 traverse 函数递归时的路径
    LinkedList<String> path = new LinkedList<>();
    // 记录所有从根节点到叶子节点的路径
    LinkedList<String> res = new LinkedList<>();

    void traverse(TreeNode root) {
       if(root == null) {
           return;
       }
       if(root.left == null && root.right == null) {
           path.addLast(root.val + "");
           res.add(String.join("->", path));
           path.removeLast();
       }
       path.addLast(root.val + "");
       traverse(root.left);
       traverse(root.right);
       path.removeLast();
    }

}
