package com.tenstone.leet.calcite;

import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

/**
 * Created by liuyuancheng on 2022/1/24  <br/>
 *
 * @author liuyuancheng
 */
public class SqlParserDemo {
    public static void main(String[] args) throws SqlParseException {
        final String sql = "select ids, name from test where id < 5 and name = 'zhang'";
        final SqlParser.Config config = SqlParser.configBuilder().build();
        final SqlParser parser = SqlParser.create(sql, config);
        final SqlNode sqlNode = parser.parseStmt();

        System.out.println(sqlNode);

    }
}
