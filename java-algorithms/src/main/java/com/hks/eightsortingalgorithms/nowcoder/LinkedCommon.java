package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedCommon {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printCommonValue(Node node1, Node node2) {
        while (node1.next != null && node2.next != null) {
            if (node1.value == node2.value) {
                System.out.println(node1.value);
                node1 = node1.next;
                node2 = node2.next;
            } else if (node1.value < node2.value) {
                node1 = node1.next;
            } else {
                node2 = node2.next;
            }
        }
    }

    public static void main(String[] args) {
        Node head = null;
        Node node = null;
        for (int i = 0; i < 5; i++) {
            Node node1 = new Node(i);
            if (head == null) {
                head = node1;
            } else {
                node.next = node1;
            }
            node = node1;
        }
        printCommonValue(head, head);
    }
}
