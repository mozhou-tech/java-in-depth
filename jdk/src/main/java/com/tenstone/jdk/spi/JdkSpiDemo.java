package com.tenstone.jdk.spi;

import java.util.ServiceLoader;

/**
 * Created by liuyuancheng on 2022/2/15  <br/>
 *
 * @author liuyuancheng
 */
public class JdkSpiDemo {

    /**
     * 注意resources下的    META-INF/services目录
     * @param args
     */
    public static void main(String[] args) {
        final ServiceLoader<SpiDemoInterface> loaded = ServiceLoader.load(SpiDemoInterface.class);
        for (SpiDemoInterface spiDemoInterface : loaded) {
            System.out.println(spiDemoInterface.print());
        }
    }

}
