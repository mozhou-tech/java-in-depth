package leetcode.editor.cn.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.List;

import static leetcode.editor.cn.common.ListNodeUtil.toArrayString;

/**
 * Created by liuyuancheng on 2022/3/1  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class AssertTool extends Assertions {

    public static void assertEqual(int[] src, int[] expected) {
        assertEquals(Arrays.asList(src), Arrays.asList(expected));
    }

    public static void assertEquals(List<Integer> src, List<Integer> expected) {
        if (src.size() != expected.size()) {
            log.info("src {}", src);
            log.info("expected {}", expected);
            fail("数组长度不一致");
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!src.get(i).equals(expected.get(i))) {
                log.info("第{}位不匹配，预期为{} 实际为{}", i, expected, src);
                break;
            }
        }
    }

    public static void assertEquals(ListNode src, ListNode expected) {
        ListNode srcc = src;
        ListNode expectedc = expected;
        int index = 0;
        while (srcc != null && expectedc != null) {
            if (srcc.val != expectedc.val)
                fail(String.format("当前结果 %s 期望结果 %s", toArrayString(src), toArrayString(expected)));
            index++;
            srcc = srcc.next;
            expectedc = expectedc.next;
        }
        if (srcc != null || expectedc != null)
            fail(String.format("当前结果 %s 期望结果 %s", toArrayString(src), toArrayString(expected)));
    }

}
