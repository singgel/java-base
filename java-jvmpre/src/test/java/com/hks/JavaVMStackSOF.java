package com.hks;

//-Xss160k
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws  Throwable{
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        } catch (Exception ex){
            System.out.println(ex.getStackTrace().length);
            throw ex;
        }
    }
}
