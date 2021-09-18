package com.hks.serializable;

import java.io.*;
/**
 * @Author: hekuangsheng
 * @Date: 2018/10/15
 */

public class DeserializeDemo
{
    public static void main(String [] args)
    {
        Employee e = null;
        try
        {
            FileInputStream fileIn = new FileInputStream("/Users/yiche/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);
    }
}
