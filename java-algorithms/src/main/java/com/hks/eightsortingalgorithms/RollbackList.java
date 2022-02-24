package com.hks.eightsortingalgorithms;

public class RollbackList {
    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(0);
        Node cur = node;
        for (int i = 1; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node newNode = rollbackList(node);
        while (newNode != null) {
            System.out.println("=========" + newNode.val);
            newNode = newNode.next;
        }
    }

    static Node rollbackList(Node head) {
        Node pre = null;
        Node cur = head;
        Node dummy = head;
        while (dummy != null) {
            cur = new Node(dummy.val);
            cur.next = pre;
            pre = cur;
            dummy = dummy.next;
        }
        return cur;
    }
}
