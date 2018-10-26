package com.hks.eightsortingalgorithms.staticClass;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 * <p>
 * base static
 * test static
 * base constructor
 * test constructor
 * <p>
 * 在执行开始，先要寻找到main方法，因为main方法是程序的入口，但是在执行main方法之前，
 * 必须先加载Test类，而在加载Test类的时候发现Test类继承自Base类，
 * 因此会转去先加载Base类，在加载Base类的时候，发现有static块，便执行了static块。
 * <p>
 * 在Base类加载完成之后，便继续加载Test类，然后发现Test类中也有static块，便执行static块。
 * <p>
 * 在加载完所需的类之后，便开始执行main方法。
 * 在main方法中执行new Test()的时候会先调用父类的构造器，然后再调用自身的构造器。
 */
public class Test extends Base {


    static {
        System.out.println("test static");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new Test();
    }

    @org.junit.Test
    public void test() {
        /**
         * intVal BigInteger 这个BigDecimal的未缩放值
         *
         * intCompact long 如果此BigDecimal的有效数的绝对值小于或等于{@code..MAX_VALUE}，
         *          则该值可以紧凑地存储在该字段中并在计算中使用。
         *
         * scale int BigDecimal的规模
         *
         * precision int BigDecimal中的十进制数字的数目，或如果数字不知道（查找信息），则为0。
         *          如果非零值，则保证值正确。使用precision()方法获取和设置值，当然可能是0。这个字段是可变的，直到设置为非零为止。
         *
         * stringCache string 用于存储规范字符串表示形式，如果计算的话。
         *
         *
         */
        BigDecimal bigDecimal = BigDecimal.valueOf(0.1);
        System.out.print("bigDecimal->" + bigDecimal);
        System.out.print("\n");
        BigDecimal bigDecimal1 =  new BigDecimal(Double.toString(0.1));
        System.out.print("bigDecimal1->" + bigDecimal1);
        System.out.print("\n");

        BigDecimal bigDecimal2 = new BigDecimal(0.1, new MathContext(64));
        System.out.print("bigDecimal2->" + bigDecimal2);
        System.out.print("\n");
        BigDecimal bigDecimal3 = bigDecimal.add(bigDecimal2);
        System.out.print("bigDecimal3->" + bigDecimal3.toString());
        System.out.print("\n");

        double d = 0.1;
        System.out.print("double->" + (1-d));
        System.out.print("\n");

        System.out.print("=============");
        System.out.print(ThisClass.value);
        System.out.print("-------------");
        ThisClass.value = 0;
        System.out.print(ThisClass.value);
    }
}

class Base {

    static {
        System.out.println("base static");
    }

    public Base() {
        System.out.println("base constructor");
    }
}