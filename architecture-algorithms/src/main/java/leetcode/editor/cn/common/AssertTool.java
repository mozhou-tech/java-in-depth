package leetcode.editor.cn.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/3/1  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class AssertTool extends Assertions {

    public static void assertListEquals(List<Integer> src, List<Integer> expected) {
        if (src.size() != expected.size()) {
            log.info("src {}",src);
            log.info("expected {}",expected);
            fail("数组长度不一致");
        }
        for (int i = 0; i < expected.size(); i++) {
            if (!src.get(i).equals(expected.get(i))){
                log.info("第{}位不匹配，预期为{} 实际为{}",i,expected,src);
                break;
            }
        }
    }

}
