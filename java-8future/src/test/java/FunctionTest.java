import org.junit.Test;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author heks
 * @description: TODO
 * @date 2020/11/11
 */
public class FunctionTest {
    /**
     * Function测试，function的作用是转换，将一个值转为另外一个值
     */
    @Test
    public void test_Function() {
        //① 使用map方法，泛型的第一个参数是转换前的类型，第二个是转化后的类型
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();//获取每个字符串的长度，并且返回
            }
        };

        Stream<String> stream = Stream.of("aaa", "bbbbb", "ccccccv");
        Stream<Integer> stream1 = stream.map(function);
        stream1.forEach(System.out::println);

        System.out.println("********************");

        System.out.println(function.apply("heks"));
    }
}
