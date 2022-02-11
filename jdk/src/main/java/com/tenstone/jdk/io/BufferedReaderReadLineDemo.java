package com.tenstone.jdk.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by liuyuancheng on 2022/2/7  <br/>
 * BufferedReader提供一个readLine()可以方便地读取一行，
 * 而FileInputStream和FileReader只能读取一个字节或者一个字符，因此BufferedReader也被称为行读取器.
 *
 * @author liuyuancheng
 */
public class BufferedReaderReadLineDemo {

    public static void main(String[] args) {
        try (//InputStreamReader是从byte转成char的桥梁
             InputStreamReader reader = new InputStreamReader(System.in);
             //BufferedReader(Reader in)是char类型输入的包装类
             BufferedReader br = new BufferedReader(reader)) {

            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals("exit")) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
