package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class LInkedRollbackStr1 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean rollbackStr(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node dummy = head;
        while (dummy != null) {
            stack.push(dummy.value);
            dummy = dummy.next;
        }
        while (head != null) {
            int val = stack.pop();
            if (val != head.value) {
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
