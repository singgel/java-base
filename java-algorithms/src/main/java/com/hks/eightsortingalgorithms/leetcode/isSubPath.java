package com.hks.eightsortingalgorithms.leetcode;

public class isSubPath {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(head.val == root.val) {
            if(check(head, root)){
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // 检查是否能够将链表嵌入二叉树
    boolean check(ListNode head, TreeNode root) {
        if(head == null) {
            return true;
        }
        if(root == null) {
            return false;
        }
        if(head.val == root.val) {
            return check(head.next, root.left) || check(head.next, root.right);
        }
        return false;
    }
}
