package com.tenstone.jdk.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * Created by liuyuancheng on 2022/9/5  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class NumberOverflow {

    @Test
    void integerOverflow() {
        log.info("Integer.MAX_VALUE + 1 = {}", Integer.MAX_VALUE + 1);
        log.info("Integer.MIN_VALUE - 1 = {}", Integer.MIN_VALUE - 1);
    }

}
