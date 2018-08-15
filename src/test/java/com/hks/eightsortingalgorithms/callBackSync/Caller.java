package com.hks.eightsortingalgorithms.callBackSync;

public class Caller {
    private MyCallInterface callInterface;

    public Caller() {
    }

    public void setCallFunc(MyCallInterface callInterface) {
        this.callInterface = callInterface;
    }

    public void call() {
        callInterface.printName();
    }
}
