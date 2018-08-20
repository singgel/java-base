package com.hks.eightsortingalgorithms.stackAccess;

import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileDisplayer implements Doer{

    String fileName;
    public TextFileDisplayer(String fileName){
        this.fileName=fileName;
    }
    @Override
    public void doYourThing() {
        try {
            FileReader fr = new FileReader(fileName);
            try {
                CharArrayWriter caw = new CharArrayWriter();
                int c;
                while((c=fr.read())!=-1){
                    caw.write(c);
                }
                System.out.println(caw.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                if(fr!=null){
                    try {
                        fr.close();
                        fr=null;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


}
