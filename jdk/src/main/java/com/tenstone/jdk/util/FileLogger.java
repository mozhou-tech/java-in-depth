/**
 * Created by 尼恩@疯狂创客圈
 * Date: 17-12-30
 * Time: 下午4:50
 */
package com.tenstone.jdk.util;


import java.io.*;

public class FileLogger {

    private static File logFile;

    static {
        try {
            String logDir = com.crazymakercircle.util.IOUtil.builderResourcePath("/AOP/");
            File dir = new File(logDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            String filePath = logDir + com.crazymakercircle.util.DateUtil.getToday() + ".txt";

            logFile = new File(filePath);
            if (!logFile.exists()) {

                logFile.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 带着方法名输出，方法名称放在前面
     *
     * @param s 待输出的字符串形参
     */
    public static void info(Object s) {
        Writer fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(logFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.append(com.crazymakercircle.util.DateUtil.getNow());
            bufferedWriter.append(" ");
            bufferedWriter.append(s.toString());
            bufferedWriter.append("\r");
            bufferedWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            com.crazymakercircle.util.IOUtil.closeQuietly(bufferedWriter);

        }
    }

}
