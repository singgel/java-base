package com.hks.eightsortingalgorithms.aceessControler;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 第一步:编写MyFileInputStream
 * (copy吧少年，不要自己狂敲)
 */
public class MyFileInputStream {

    public MyFileInputStream(String name) throws FileNotFoundException {
        this(name != null ? new File(name) : null);
    }

    public MyFileInputStream(File file) throws FileNotFoundException {
        String name = (file != null ? file.getPath() : null);
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkRead(name);
        }
    }


}
