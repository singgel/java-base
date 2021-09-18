package com.hks.genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RelationTest {

    @Test
    public void relationTest(){
        Content<Animal> animalContent = new Content<>();

        ///上界通配符
        /*List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("dog","wangwang","wangcai",10));
        animalContent.setContent(dogs);*/

        ///下界通配符
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("dog","wangwang","wangcai",10));
        animalContent.setContent(animals);
        animalContent.add(new Dog("cat","miaomiao","mimi",5));

        List<Animal> animalList = animalContent.getContent();
        Dog dog = (Dog)animalList.get(1);
        System.out.println(dog.getDescribe());
    }

}
