package com.hks;

public class FinallyDemo {

    public static void main(String[] args){
        System.out.println(m_1());
        System.out.println(m_2());
    }

    public static int m_1(){
        int i = 10;
        try{
            System.out.println("start");
            return i += 10;
        }catch(Exception e){
            System.out.println("error:"+e);
        }finally{
            if(i>10){
                System.out.println(i);
            }
            System.out.println("finally");
            return 50;
        }
    }

    public static int m_2(){
        int i = 10;
        try{
            System.out.println("start");
            return i += 10;
        }catch(Exception e){
            System.out.println("error:"+e);
        }finally{
            if(i>10){
                System.out.println(i);
            }
            System.out.println("finally");
            i = 50;
        }
        return i;
    }

}
