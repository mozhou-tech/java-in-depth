package com.tenstone.jdk.error;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liuyuancheng on 2022/2/10  <br/>
 *
 * @author liuyuancheng
 */
public class CheckedExceptionDemo {

    /**
     * These are the exceptions that are checked at compile time.
     * If some code within a method throws a checked exception,
     * then the method must either handle the exception or it must specify the exception using the throws keyword.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        // Reading file from path in local directory
        FileReader file = new FileReader("C:\\test\\a.txt");

        // Creating object as one of ways of taking input
        BufferedReader fileInput = new BufferedReader(file);

        // Printing first 3 lines of file "C:\test\a.txt"
        for (int counter = 0; counter < 3; counter++) {
            System.out.println(fileInput.readLine());
        }

        // Closing file connections
        // using close() method
        fileInput.close();
    }
}
