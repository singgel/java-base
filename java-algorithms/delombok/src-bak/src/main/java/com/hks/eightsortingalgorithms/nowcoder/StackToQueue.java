package com.hks.eightsortingalgorithms.nowcoder;

import java.util.Stack;

public class StackToQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public StackToQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public void add(int val){
        stackPush.add(val);
    }

    public Integer poll(){
        if(stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.add(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
}
