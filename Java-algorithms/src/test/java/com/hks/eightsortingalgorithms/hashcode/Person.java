package com.hks.eightsortingalgorithms.hashcode;

public class Person {

    private Integer age;

    private String name;

    @Override
    public int hashCode () {
        return this.age;
    }

    @Override
    public boolean equals (Object obj) {
        return obj instanceof Person &&
                this.age == ((Person) obj).age;
    }

    public Person() {
    }

    public Person(Integer age) {
        this.age = age;
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
