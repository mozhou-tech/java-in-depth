package com.tenstone.leet.calcite;

import org.apache.calcite.util.Sources;

/**
 * Created by liuyuancheng on 2022/1/24  <br/>
 *
 * @author liuyuancheng
 */
public class TestUtil {

    public static String resourcePath(String path) {
        return Sources.of(TestUtil.class.getResource("/" + path)).file().getAbsolutePath();
    }
}
