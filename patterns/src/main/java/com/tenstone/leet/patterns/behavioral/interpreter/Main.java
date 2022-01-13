package com.tenstone.leet.patterns.behavioral.interpreter;

import com.tenstone.leet.patterns.behavioral.interpreter.node.Node;
import com.tenstone.leet.patterns.behavioral.interpreter.node.ProgramNode;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liuyuancheng on 2022/1/13  <br/>
 *
 * @author liuyuancheng
 */
public class Main {

    public static String rootDir = System.getProperty("user.dir") +
            "/patterns/src/main/java/com/tenstone/leet/patterns/behavioral/interpreter/";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rootDir + "program.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
