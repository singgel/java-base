package com.hks.eightsortingalgorithms;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class EncodeTest {

    public static void main(String[] ags){
        try{
            String s = "这是一段中文字符串";
            byte[] b = s.getBytes("UTF-8");
            String n = new String(b,"UTF-8");
            System.out.print(n);

            /*ByteToCharConverter charConverter = ByteToCharConverter.getConverter("UTF-8");
            char c[] = charConverter.convertAll(byteArray);
            CharToByteConverter byteConverter = CharToByteConverter.getConverter("UTF-8");
            byte[] b = byteConverter.convertAll(c);*/

            Charset charset = Charset.forName("UTF-8");
            ByteBuffer byteBuffer = charset.encode(n);
            CharBuffer charBuffer = charset.decode(byteBuffer);
            System.out.print(charBuffer);

            ByteBuffer heapByteBuffer = ByteBuffer.allocate(1024);
            ByteBuffer byteBuffer1 = heapByteBuffer.putChar(n.charAt(0));
            System.out.print(byteBuffer1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
