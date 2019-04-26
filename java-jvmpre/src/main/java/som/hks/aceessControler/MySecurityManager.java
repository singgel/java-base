package som.hks.aceessControler;

/**
 * 第一步：实现一个自己的类MySecurityManager，它继承自SecurityManager，
 * 重写它的checkRead方法，我们直接让他抛出一个SecurityException异常。
 * (copy吧少年，要的是你知识的储备，不是要你把代码背下来)
 */
public class MySecurityManager extends SecurityManager{

    @Override
    public void checkRead(String file) {
        //super.checkRead(file, context);
        throw new SecurityException("你没有的权限");
    }

}
