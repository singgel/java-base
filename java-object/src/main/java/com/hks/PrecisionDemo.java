package com.hks;

public class PrecisionDemo {

    public static void main(String[] args){
        float calNum1;
        double calNum2;
        calNum1 = (float)(1.03-.42);
        calNum2 = 1.03-.42;
        System.out.println("calNum1="+ calNum1);
        System.out.println("calNum2="+ calNum2);
        System.out.println(1.03-.42);
        calNum1 = (float)(1.00-9*.10);
        calNum2 = 1.00-9*.10;
        System.out.println("calNum1="+ calNum1);
        System.out.println("calNum2="+ calNum2);
        System.out.println(1.00-9*.10);
    }
}
