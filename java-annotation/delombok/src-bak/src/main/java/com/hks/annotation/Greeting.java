package com.hks.annotation;


import java.lang.annotation.Inherited;

/**
 * @Inherited 元注解是一个标记注解，@Inherited阐述了某个被标注的类型是被继承的。
 * 如果一个使用了@Inherited修饰的annotation类型被用于一个class，则这个annotation将被用于该class的子类。

　　注意：@Inherited annotation类型是被标注过的class的子类所继承。
    类并不从它所实现的接口继承annotation，方法并不从它所重载的方法继承annotation。
 */
@Inherited
public @interface Greeting {

    enum FontColor{ BULE,RED,GREEN};
    String name();
    FontColor fontColor() default FontColor.GREEN;

}
