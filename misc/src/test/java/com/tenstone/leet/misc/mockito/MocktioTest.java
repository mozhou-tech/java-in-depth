package com.tenstone.leet.misc.mockito;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class MocktioTest {

    @Test
    void configMockObject(){
        List mockedList = Mockito.mock(List.class);
        Assertions.assertTrue(mockedList instanceof List);
        // mock 方法不仅可以 Mock 接口类, 还可以 Mock 具体的类型.
        ArrayList mockedArrayList = Mockito.mock(ArrayList.class);
        Assertions.assertTrue(mockedArrayList instanceof List);
        Assertions.assertTrue(mockedArrayList instanceof ArrayList);
        // 模拟操作和返回
        Mockito.when(mockedList.add(1)).thenReturn(true);
        // 执行特定操作时，按预期返回
        Assertions.assertTrue(mockedList.add(1));
        Assertions.assertFalse(mockedList.add(2));
    }

}
