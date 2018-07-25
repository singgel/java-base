package com.hks.eightsortingalgorithms;

public class EncodeTest {

    public static void main(String[] ags){
        try{
            String s = "这是一段中文字符串";
            byte[] b = s.getBytes("UTF-8");
            String n = new String(b,"UTF-8");
            System.out.print(n);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
