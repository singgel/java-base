package com.hks.eightsortingalgorithms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * 注解Table 可以用于注解类、接口(包括注解类型) 或enum声明,而注解NoDBColumn仅可用于注解类的成员变量。
 */
@Target(ElementType.FIELD)
public @interface NoDBColumn {
}
