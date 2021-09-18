package com.hks.genericity;

public class Animal {

    private String type;
    private String describe;
    public Animal(){

    }
    public Animal(String type,String describe){
        this.type = type;
        this.describe = describe;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }

}
