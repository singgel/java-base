package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedDelMid {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node delK = removeMidNode(head);
        System.out.println(delK);
    }
}
