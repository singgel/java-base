package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedDelLastK {
    public static class Node {
        public int value;
        public Node pre;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node removeLastK(Node head, int k) {
        if (head == null || k < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            k--;
            cur = cur.next;
        }
        if (k == 0) {
            head = head.next;
            head.pre = null;
        }
        cur = head;
        while (k < 0) {
            k++;
            if (k == 0) {
                Node del = cur.next;
                cur.next = del.next;
                del.pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            Node node1 = new Node(i);
            cur.next = node1;
            node1.pre = cur;
            cur = cur.next;
        }
        Node delK = removeLastK(head, 6);
        System.out.println(delK);
    }
}
