package com.tenstone.jdk.io;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 *
 * @author liuyuancheng
 */
public class FileDemo {

    public static void main(String[] args) throws IOException {
        randomAccessFileWrite();
        randomAccessFileRead();
    }


    /**
     * 文件随机读
     *
     * @throws IOException
     */
    public static void randomAccessFileRead() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile(IOConstansts.filename, "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针开始读
        byte[] contents = new byte[128];
        file.read(contents);
        long pointerEnd = file.getFilePointer();
        System.out.println("pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n" + new String(contents));
        file.close();
    }

    public static void randomAccessFileWrite() throws IOException {
        // 创建一个RandomAccessFile对象
        RandomAccessFile file = new RandomAccessFile(IOConstansts.filename, "rw");
        // 通过seek方法来移动读写位置的指针
        file.seek(10);
        // 获取当前指针
        long pointerBegin = file.getFilePointer();
        // 从当前指针位置开始写
        file.write("HELLO WORLD!".getBytes());
        file.write(DateFormatUtils.format(new Date(),"Y-M-d HH:MM:SS").getBytes(StandardCharsets.UTF_8));
        long pointerEnd = file.getFilePointer();
        System.out.println("pointerBegin:" + pointerBegin + "\n" + "pointerEnd:" + pointerEnd + "\n");
        file.close();
    }
}
