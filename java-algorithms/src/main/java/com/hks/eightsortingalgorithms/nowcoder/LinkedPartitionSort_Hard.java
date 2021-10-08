package com.hks.eightsortingalgorithms.nowcoder;

public class LinkedPartitionSort_Hard {
    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node partitionSort(Node head, int pr) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        Node[] nodes = new Node[i];
        i = 0;
        cur = head;
        for (i = 0; i < nodes.length; i++) {
            nodes[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodes, pr);
        for (i = 1; i != nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        nodes[i - 1].next = null;
        return nodes[0];
    }

    public void arrPartition(Node[] nodes, int pr) {
        int small = -1;
        int big = nodes.length;
        int index = 0;
        while (index != big) {
            if (nodes[index].value < pr) {
                swap(nodes, ++small, index++);
            } else if (nodes[index].value == pr) {
                index++;
            } else {
                swap(nodes, --big, index);
            }
        }
    }

    public void swap(Node[] nodes, int a, int b) {
        Node tmp = nodes[a];
        nodes[a] = nodes[b];
        nodes[b] = tmp;
    }
}
