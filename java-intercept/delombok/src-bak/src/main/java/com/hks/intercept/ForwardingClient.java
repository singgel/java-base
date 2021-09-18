package com.hks.intercept;

/**
 * 用于包装Client到另一个Client
 */
public abstract class ForwardingClient extends Client{
    //要包装的对象
    protected abstract Client delegate();

    @Override
    public void start(String say) {
        delegate().start(say);
    }
}
