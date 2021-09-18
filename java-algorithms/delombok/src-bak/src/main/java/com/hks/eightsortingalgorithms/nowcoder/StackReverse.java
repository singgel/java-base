package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class StackReverse {
    public static int getLastVal(Stack<Integer> stack) {
        int val = stack.pop();
        if (stack.empty()) {
            return val;
        } else {
            int last = getLastVal(stack);
            stack.push(val);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }
        int i = getLastVal(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        reverse(stack);
        System.out.println(stack);
    }
}
