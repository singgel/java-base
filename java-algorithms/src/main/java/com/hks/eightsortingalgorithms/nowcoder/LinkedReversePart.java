package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedReversePart {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reversePart(Node head, int from, int to) {
        int len = 0;
        Node node1 = head;
        Node fNode = null;
        Node tNode = null;
        while (node1 != null) {
            len++;
            fNode = len == from - 1 ? node1 : fNode;
            tNode = len == to + 1 ? node1 : tNode;
            node1 = node1.next;
        }
        if (from > to || from < 1 || to > len || (to - from < 2)) {
            return head;
        }
        node1 = fNode == null ? head : fNode.next;
        Node node2 = node1.next;
        node1.next = tNode;
        Node next = null;
        while (node2 != tNode) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if (fNode != null) {
            fNode.next = node1;
            return head;
        }
        return node1;
    }

    public static void main(String[] args) {
        Node head = new Node(-1);
        Node cur = head;
        for (int i = 0; i < 5; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        Node reverseNode = reversePart(head, 1, 5);
        System.out.println(reverseNode);
    }

}
