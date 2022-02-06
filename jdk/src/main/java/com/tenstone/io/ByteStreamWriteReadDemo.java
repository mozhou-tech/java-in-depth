package com.tenstone.io;

import java.io.*;

/**
 * Created by liuyuancheng on 2022/2/6  <br/>
 * 字节流
 *
 * @author liuyuancheng
 */
public class ByteStreamWriteReadDemo {

    public static void main(String[] args) throws IOException {
        String filename = "/Users/jerrylau/Documents/GitHub/leetcode/jdk/src/main/java/com/tenstone/io/test.txt";
        writeByte(filename);
        readByteFromFile(filename);
        convertByteToChar(filename);
    }

    /**
     * 字节流写文件
     *
     * @param filename
     * @throws IOException
     */
    public static void writeByte(String filename) throws IOException {
        String hello = "bytes hello world!\n";
        byte[] byteArray = hello.getBytes();
        File file = new File(filename);
        //因为是用字节流来写媒介，所以对应的是OutputStream
        //又因为媒介对象是文件，所以用到子类是FileOutputStream
        OutputStream os = new FileOutputStream(file, true);
        os.write(byteArray);
        os.close();
    }

    /**
     * 字节流读文件
     *
     * @param filename
     * @throws IOException
     */
    public static void readByteFromFile(String filename) throws IOException {
        File file = new File(filename);
        byte[] byteArray = new byte[(int) file.length()];
        //因为是用字节流来读媒介，所以对应的是InputStream
        //又因为媒介对象是文件，所以用到子类是FileInputStream
        InputStream is = new FileInputStream(file);
        int size = is.read(byteArray);
        System.out.println("大小:" + size + ";内容:" + new String(byteArray));
        is.close();
    }

    public static void convertByteToChar(String filename) throws IOException {
        File file = new File(filename);
        //获得一个字节流
        InputStream is = new FileInputStream(file);
        //把字节流转换为字符流，其实就是把字符流和字节流组合的结果。
        // InputStreamReader is a bridge from byte streams to character streams.
        Reader reader = new InputStreamReader(is);
        char[] charArray = new char[(int) file.length()];
        int size = reader.read(charArray);
        System.out.println("大小:" + size + ";内容:" + new String(charArray));
        is.close();
        reader.close();
    }

}
