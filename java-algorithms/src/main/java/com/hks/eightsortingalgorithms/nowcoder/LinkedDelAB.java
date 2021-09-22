package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedDelAB {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil((double) (a * n) / (double) b);
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node delK = removeByRatio(head, 3, 5);
        System.out.println(delK);
    }
}
