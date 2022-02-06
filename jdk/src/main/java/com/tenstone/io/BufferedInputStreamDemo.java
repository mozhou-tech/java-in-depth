package com.tenstone.io;

import java.io.*;

/**
 * Created by liuyuancheng on 2022/1/31  <br/>
 * <p>
 * 对流进行写入时提供一个buffer来提高IO效率。在进行磁盘或网络IO时，原始的InputStream对数据读取的过程都是一个字节一个字节操作的，
 * 而BufferedInputStream在其内部提供了一个buffer，在读数据时，会一次读取一大块数据到buffer中，这样比单字节的操作效率要高的多，
 * 特别是进程磁盘IO和对大量数据进行读写的时候,能提升IO性能。
 *
 * @author liuyuancheng
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) throws IOException {
        String filename = "/Users/jerrylau/Documents/GitHub/leetcode/jdk/src/main/java/com/tenstone/io/test.txt";
        readByBufferedInputStream(filename);
    }

    public static void readByBufferedInputStream(String filename) throws IOException {
        File file = new File(filename);
        byte[] byteArray = new byte[(int) file.length()];
        // 可以在构造参数中传入buffer大小
        // 使用BufferedInputStream十分简单，只要把普通的输入流和BufferedInputStream组合到一起即可。
        InputStream is = new BufferedInputStream(new FileInputStream(file), 2 * 1024);
        int size = is.read(byteArray);
        System.out.println("BufferedInputStreamDemo\n 大小:" + size + ";内容:" + new String(byteArray));
        is.close();
    }
}
