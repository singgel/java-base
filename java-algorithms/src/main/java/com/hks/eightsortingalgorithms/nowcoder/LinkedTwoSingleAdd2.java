package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class LinkedTwoSingleAdd2 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node addList(Node head1, Node head2) {
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node c1 = head1;
        Node c2 = head2;
        Node node = null;
        Node pre = null;
        while (c1 != null || c2 != null) {
            n1 = c1 == null ? 0 : c1.value;
            n2 = c2 == null ? 0 : c2.value;
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
            c1 = c1 == null ? c1 : c1.next;
            c2 = c2 == null ? c2 : c2.next;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(ca);
            node.next = pre;
        }
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        return node;
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
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 3; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node sum = addList(head, head);
        System.out.println(sum);
    }
}
