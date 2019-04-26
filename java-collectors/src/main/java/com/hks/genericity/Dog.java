package com.hks.genericity;

public class Dog extends Animal {
    private String name;
    private int age;
    public Dog(String type,String describe,String name,int age){
        super(type,describe);
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}
