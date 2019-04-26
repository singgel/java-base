package com.hks.eightsortingalgorithms.builder;

/**
 * @Author: hekuangsheng
 * @Date: 2018/10/23
 * <p>
 * 通过静态内部类等方式实现的零件无序话构造：
 */
public class User {

    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private User user = new User();

        public Builder setName(String name) {
            user.name = name;
            return this;
        }

        public Builder setAge(int age){
            user.age = age;
            return this;
        }

        public Builder setAddress(String address){
            user.address =address;
            return this;
        }

        public User build(){
            return user;
        }
    }
}
