package com.hks.eightsortingalgorithms.factory;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23

 * 通过反射机制实现的工厂
 */
public class FoodFactory {

    public static Food getFood(String type) {
        Food food = null;
        try {
            food = (Food) Class.forName("com.hks.eightsortingalgorithms.factory." + type).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return food;
    }
}
