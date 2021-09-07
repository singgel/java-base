import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author heks
 * @description: TODO
 * @date 2020/11/11
 */
public class PredicateTest {
    /**
     * Predicate谓词测试，谓词其实就是一个判断的作用类似bool的作用
     */
    @Test
    public void test_Predicate() {
        //① 使用Predicate接口实现方法,只有一个test方法，传入一个参数，返回一个bool值
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 5){
                    return true;
                }
                return false;
            }
        };

        System.out.println(predicate.test(6));

        System.out.println("********************");

        //② 使用lambda表达式，
        predicate = (t) -> t > 5;
        System.out.println(predicate.test(1));
        System.out.println("********************");

    }

    /**
     * Predicate谓词测试，Predicate作为接口使用
     */
    @Test
    public void test_Predicate2() {
        //① 将Predicate作为filter接口，Predicate起到一个判断的作用
        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer > 5){
                    return true;
                }
                return false;
            }
        };

        Stream<Integer> stream = Stream.of(1, 23, 3, 4, 5, 56, 6, 6);
        List<Integer> list = stream.filter(predicate).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("********************");

    }
}
