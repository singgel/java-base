package com.hks.eightsortingalgorithms.builder;

import static java.lang.System.out;
/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 */
public class BuilderTest {

    public static void main(String[] args) {
        User.Builder builder = new User.Builder();
        User user = builder.setName("corn").setAge(100).setAddress("广州").build();
        out.print(user.toString());
    }

}
