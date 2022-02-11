package com.tenstone.jdk.io;

import java.io.*;

/**
 * Created by liuyuancheng on 2022/2/6  <br/>
 * 字符流
 *
 * @author liuyuancheng
 */
public class CharStreamWriteReadDemo {

    public static void main(String[] args) throws IOException {

        writeCharToFile(IOConstansts.filename);
        readCharFromFile(IOConstansts.filename);
    }

    /**
     * 字符流写入文件
     *
     * @param filename
     * @throws IOException
     */
    public static void writeCharToFile(String filename) throws IOException {
        String hello = "char hello world!\n";
        File file = new File(filename);
        //因为是用字符流来读媒介，所以对应的是Writer，又因为媒介对象是文件，所以用到子类是FileWriter
        Writer os = new FileWriter(file,true);
        os.write(hello);
        os.close();
    }

    /**
     * 从文件读取字符流
     * @param filename
     * @throws IOException
     */
    public static void readCharFromFile(String filename) throws IOException {
        File file = new File(filename);
        //因为是用字符流来读媒介，所以对应的是Reader
        //又因为媒介对象是文件，所以用到子类是FileReader
        Reader reader = new FileReader(file);
        char[] charArray = new char[(int) file.length()];
        int size = reader.read(charArray);
        System.out.println("大小:" + size + ";内容:\n" + new String(charArray));
        reader.close();
    }
}
