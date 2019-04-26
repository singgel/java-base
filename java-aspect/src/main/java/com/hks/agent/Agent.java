package com.hks.agent;

import java.lang.instrument.Instrumentation;

/**
 * Agent 类必须打成jar包，然后里面的 META-INF/MAINIFEST.MF 必须包含 Premain-Class这个属性。
 下面是一个MANIFEST.MF的例子：
 ---------------------
 Manifest-Version: 1.0
 Premain-Class:MyAgent1
 Created-By:1.6.0_06
 ---------------------
 然后把MANIFEST.MF 加入到你的jar包中。
 */
public class Agent {
    public static void premain(String args, Instrumentation inst){
        System.out.println("Hi, I'm agent!");
        inst.addTransformer(new TestTransformer());
    }
}
