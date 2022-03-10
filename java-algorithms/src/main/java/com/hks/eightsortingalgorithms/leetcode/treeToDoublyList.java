package com.hks.eightsortingalgorithms.leetcode;

public class treeToDoublyList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }


    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        traverTree(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    void traverTree(Node node) {
        if (node == null) {
            return;
        }
        traverTree(node.left);
        if (head == null) {
            head = node;
        } else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        traverTree(node.right);
    }
}
