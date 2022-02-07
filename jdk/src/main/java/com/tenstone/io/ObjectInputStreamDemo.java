package com.tenstone.io;

import java.io.*;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 * ObjectInputStream能够让你从输入流中读取Java对象，而不需要每次读取一个字节。
 * 你可以把InputStream包装到ObjectInputStream中，然后就可以从中读取对象了
 *
 * @author liuyuancheng
 */
public class ObjectInputStreamDemo {

    public static void main(String[] args) throws Exception {
        writeObject();
        readObject1();
    }


    public static void readObject1() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream(IOConstansts.serialize));
        MyClass object = (MyClass) input.readObject();
        input.close();
    }


    public static void writeObject() throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(IOConstansts.serialize));
        MyClass object = new MyClass();
        output.writeObject(object);
        output.close();
    }
}
