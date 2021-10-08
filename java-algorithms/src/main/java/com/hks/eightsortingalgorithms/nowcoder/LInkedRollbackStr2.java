package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class LInkedRollbackStr2 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean rollbackStr(Node head) {
        Node dummy = head;
        Node next = head.next;
        while (dummy != null && dummy.next.next != null) {
            next = dummy.next;
            dummy = dummy.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        while (next != null) {
            stack.push(next.value);
            next = next.next;
        }
        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node cur = head;
        for (int i = 0; i < 2; i++) {
            cur.next = new Node(i);
            cur = cur.next;
        }
        boolean reverseNode = rollbackStr(head);
        System.out.println(reverseNode);
    }
}
