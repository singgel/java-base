package com.hks.eightsortingalgorithms.hashmap;

public class A {

    private String code;
    private String name;
    @Override
    public int hashCode() {
        // TODO Auto-generated method stub
        return code.hashCode()+name.hashCode();
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return code.toString()+name.toString();
    }

}
