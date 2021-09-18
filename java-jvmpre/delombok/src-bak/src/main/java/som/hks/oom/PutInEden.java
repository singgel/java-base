package som.hks.oom;

/**
 * 所示代码尝试分配 4MB 内存空间，观察一下它的内存使用情况
 */
public class PutInEden {

    public static void main(String[] args){
        byte[] b1,b2,b3,b4;//定义变量
        //分配 1MB 堆空间，考察堆空间的使用情况
        b1=new byte[1024*1024];
        b2=new byte[1024*1024];
        b3=new byte[1024*1024];
        b4=new byte[1024*1024];
    }

}
