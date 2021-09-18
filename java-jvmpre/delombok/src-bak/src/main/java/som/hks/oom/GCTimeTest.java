package som.hks.oom;

import java.util.HashMap;

/**
 * 所示代码运行 1 万次循环，每次分配 512*100B 空间，
 * 采用不同的垃圾回收器，输出程序运行所消耗的时间
 */
public class GCTimeTest {

    static HashMap map = new HashMap();

    public static void main(String[] args){
        long begintime = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            if(map.size()*512/1024/1024>=400){
                //保护内存不溢出
                map.clear();
                System.out.println("clean map");
            }
            byte[] b1;
            for(int j=0;j<100;j++){
                b1 = new byte[512];
                map.put(System.nanoTime(), b1);//不断消耗内存
            }
        }
        long endtime = System.currentTimeMillis();
        System.out.println(endtime-begintime);
    }

}
