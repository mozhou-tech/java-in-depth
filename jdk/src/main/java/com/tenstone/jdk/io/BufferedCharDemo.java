package com.tenstone.jdk.io;

import java.io.*;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 * 面向字节流的带Buffer字节流读取
 *
 * @author liuyuancheng
 */
public class BufferedCharDemo {

    public static void main(String[] args) throws IOException {
        readByBufferedReader(IOConstansts.filename);
    }

    /**
     * BufferedReader、BufferedWriter 的作用基本和BufferedInputStream、BufferedOutputStream一致，
     * 具体用法和原理都差不多 ，只不过一个是面向字符流一个是面向字节流。
     * @param filename
     * @throws IOException
     */
    public static void readByBufferedReader(String filename) throws IOException {
        File file = new File(filename);
        // 在字符流基础上用buffer流包装，也可以指定buffer的大小
        Reader reader = new BufferedReader(new FileReader(file), 2 * 1024);
        char[] byteArray = new char[(int) file.length()];
        int size = reader.read(byteArray);
        System.out.println("大小:" + size + ";内容:" + new String(byteArray));
        reader.close();
    }
}
