package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedLoop {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; //n2-> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {
        Node head = new Node(0);
        Node cur = head;
        for (int i = 1; i < 3; i++) {
            cur.next = new Node(i);
            cur = cur.next;
            if (i == 2) {
               cur.next = head.next;
            }
        }

        Node sum = getLoopNode(head);
        System.out.println(sum);
    }
}
