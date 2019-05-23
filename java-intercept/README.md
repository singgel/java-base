1.一个拦截器的小例子

有一个接口如下:
/**
 * 主调用接口
 */
public abstract class Client {
    public abstract void start(String say);
}
/**
 * 上述接口实现类
 */
public class ClientImp extends Client {
    @Override
    public void start(String say) {
        System.out.println(say);
    }
}

对此接口相关的转换器:
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

然后在下列方法中调用:
public class InterceptTest {
    public static void main(String[] args) {
        Client client = new ClientImp();//主要想执行的方法
        //构造第一个拦截器
        Client intercept1 = new ForwardingClientImpl(client){
            @Override
            public void start(String say) {
                System.out.println("拦截器1");
                super.start(say);
            }
        };
        //构造第二个拦截器
        Client intercept2 = new ForwardingClientImpl(intercept1){
            @Override
            public void start(String say) {
                System.out.println("拦截器2");
                super.start(say);
            }
        };
        //执行主方法
        intercept2.start("这是要执行的方法");
    }
}

毫无疑问会输出
拦截器2
拦截器1
这是要执行的方法