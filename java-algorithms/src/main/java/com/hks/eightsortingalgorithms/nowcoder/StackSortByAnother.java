package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class StackSortByAnother {

    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.empty()) {
            int tmp = stack.pop();
            while (!help.empty() && help.peek() < tmp) {
                stack.push(help.pop());
            }
            help.push(tmp);
        }
        while (!help.empty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(4);
        stack.add(5);
        stack.add(6);
        stack.add(3);
        sortStackByStack(stack);
        System.out.println(stack);
    }

}
