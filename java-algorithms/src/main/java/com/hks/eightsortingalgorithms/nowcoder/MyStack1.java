package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

/**
 * @author heks
 * @description: TODO
 * @date 2020/9/22
 */
public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num) {
        stackData.push(num);
        if (stackMin.empty() || num <= stackMin.peek()) {
            stackMin.push(num);
        }
    }

    public int pop() {
        if (stackData.empty()) {
            throw new RuntimeException("your stack is empty");
        }
        int pop = stackData.pop();
        if (pop == stackMin.peek()) {
            stackMin.pop();
        }
        return pop;
    }

    public int getMin(){
        if(stackMin.empty()){
            throw new RuntimeException("your stack is empty");
        }
        return stackMin.peek();
    }
}
