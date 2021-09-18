package com.heks.stream;

/**
 * @author heks
 * @description: TODO
 * @date 2020/11/11
 */
/**
 * 下一个元素求值过程
 */
public class NextItemEvalProcess {

    /**
     * 求值方法
     * */
    private EvalFunction evalFunction;

    public NextItemEvalProcess(EvalFunction evalFunction) {
        this.evalFunction = evalFunction;
    }

    MyStream eval(){
        return evalFunction.apply();
    }
}
