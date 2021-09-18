package com.hks.intercept;

/**
 * 上述接口实现类
 */
public class ClientImp extends Client {
    @Override
    public void start(String say) {
        System.out.println(say);
    }
}
