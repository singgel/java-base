package com.hks.eightsortingalgorithms.effective.factory;

import org.junit.Test;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 */
public class FoodFactoryTest {

    @Test
    public void test(){
        Food food = FoodFactory.getFood("Fish");
        food.introduce();
    }

}
