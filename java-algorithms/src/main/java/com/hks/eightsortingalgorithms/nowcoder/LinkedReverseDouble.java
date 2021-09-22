package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedReverseDouble {
    public static class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node dummy = head;
        Node pre = null;
        for (int i = 0; i < 5; i++) {
            dummy.pre = pre;
            dummy.next = new Node(i);
            pre = dummy;
            dummy = dummy.next;
        }
        Node reverseNode = reverseList(head);
        System.out.println(reverseNode);
    }
}
