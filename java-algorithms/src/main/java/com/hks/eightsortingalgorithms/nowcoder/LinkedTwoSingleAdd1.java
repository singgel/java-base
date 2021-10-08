package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class LinkedTwoSingleAdd1 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node addList(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (head1 != null) {
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (head2 != null) {
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new Node(n % 10);
            node.next = pre;
            ca = n / 10;
        }
        if (ca == 1) {
            pre = node;
            node = new Node(ca);
            node.next = pre;
        }
        return node;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 3; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node sum = addList(head,head);
        System.out.println(sum);
    }
}
