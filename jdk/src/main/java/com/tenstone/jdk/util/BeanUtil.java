package com.tenstone.jdk.util;

import java.util.Arrays;
import java.util.List;

public class BeanUtil {


    public static <T> List<T> asList(T... nodeA) {
        return Arrays.asList(nodeA);
    }

}
