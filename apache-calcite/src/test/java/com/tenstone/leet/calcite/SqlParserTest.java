package com.tenstone.leet.calcite;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.SqlNodeList;
import org.apache.calcite.sql.SqlSelect;
import org.apache.calcite.sql.SqlSetOption;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created by liuyuancheng on 2022/1/24  <br/>
 *
 * @author liuyuancheng
 */
public class SqlParserTest {

    @Test
    void parse() throws SqlParseException {
        final String sql = "select id, name from calcite_test where id < 5 and name = 'zhang'";
        final SqlParser.Config config = SqlParser.configBuilder().setLex(Lex.MYSQL).build();
        final SqlParser parser = SqlParser.create(sql, config);
        // 解析sql
        final SqlNode sqlNode = parser.parseQuery();

    }

}
