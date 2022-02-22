package com.hks.eightsortingalgorithms.nowcoder;

import java.util.HashMap;
import java.util.Map;

public class LinkedRandomCopy {
    public static class Node {
        public int value;
        public Node next;
        public Node random;

        public Node(int value) {
            this.value = value;
        }
        public Node next(Node node) {
            next = node;
            return this;
        }

        public Node random(Node node) {
            random = node;
            return this;
        }
    }

    Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        return dfs(head);
    }

    Node dfs(Node node) {
        if(node==null) {
            return  null;
        }
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.value);
        map.put(node, copy);
        copy.next(dfs(node.next));
        copy.random(dfs(node.random));
        return copy;
    }
}
