package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedReverseSingle {
    public static class Node{
        public int value;
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
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node reverseNode = reverseList(head);
        System.out.println(reverseNode);
    }
}
