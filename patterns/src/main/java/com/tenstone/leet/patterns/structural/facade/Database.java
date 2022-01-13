package com.tenstone.leet.patterns.structural.facade;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 *
 * @author liuyuancheng
 */
public class Database {

    private Database() {
    }

    public static Properties getProperties(String dbname) {
        String filename = Constants.rootDir + dbname + ".txt";
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(filename));
        } catch (IOException e) {
            System.out.println("Warning: " + filename + " is not found.");
        }
        return prop;
    }
}
