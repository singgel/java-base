package com.hks.eightsortingalgorithms.leetcode;

import org.aspectj.weaver.loadtime.definition.Definition;

public class deleteDuplicates {

    public static void main(String[] args) {

    }
    // [1,1,2,3,3]
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2!=null) {
            if(n1.val != n2.val) {
                n1.next = new ListNode(n2.val);
                n1 = n1.next;
            } else {
                n1.next = n2.next;
            }
            n2 = n2.next;
        }
        return head;
    }
}
