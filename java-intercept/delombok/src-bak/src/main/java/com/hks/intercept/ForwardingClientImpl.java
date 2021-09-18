package com.hks.intercept;

/**
 * 一个简单的包装实现类,必须要传入要包装的对象
 */
public class ForwardingClientImpl extends ForwardingClient{

    //被委托对象
    private final Client client;

    public ForwardingClientImpl(Client client) {
        this.client = client;
    }

    @Override
    protected Client delegate() {
        return client;
    }
}
