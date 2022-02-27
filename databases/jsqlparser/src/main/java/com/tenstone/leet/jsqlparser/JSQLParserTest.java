package com.tenstone.leet.jsqlparser;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuyuancheng on 2022/2/27  <br/>
 * jsqlparser 基于javacc
 *
 * @author liuyuancheng
 */
public class JSQLParserTest {
    public static void main(String[] args) throws JSQLParserException {
        String sql = "SELECT\n" +
                "  a.id,\n" +
                "  username,\n" +
                "  b.workflow_name,\n" +
                "  reviewok_time\n" +
                "FROM archer.sql_users a\n" +
                "  JOIN sql_workflow b ON a.username = b.engineer\n" +
                "  JOIN archive.table3 c ON a.username = c.col5;\n";

        try {
            // 解析Select语句
            Statement stmt = CCJSqlParserUtil.parse(sql);
            Select selectStatement = (Select) stmt;
            // 查找表名
            System.out.println("===================Table=======================");
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
            for (String name: tableList) {
                System.out.println("table: " + name);
            }
            System.out.println("===================Select=======================");
            // 解析查询字段
            List<String> columnList = new ArrayList<String>();
            PlainSelect ps = (PlainSelect) selectStatement.getSelectBody();
            List<SelectItem> selectItems = ps.getSelectItems();
            // System.out.println(selectItems);
            selectItems.stream().forEach(selectItem -> columnList.add(selectItem.toString()));
            for (String name: columnList) {
                System.out.println("column: " + name);
            }
            System.out.println("===================FROM=======================");
            // 解析表的别名
            FromItem fromItem = ps.getFromItem();
            Table table = (Table) fromItem;
            System.out.println(table.getName() + ":\t" + table.getAlias());
            System.out.println("===================JOIN=======================");
            List<Join> joins = ps.getJoins();
            for (Join join : joins) {
                fromItem = join.getRightItem();
                table = (Table) fromItem;
                System.out.println(table.getName() + ":\t" + table.getAlias());
            }

        } catch (JSQLParserException e) {
            e.printStackTrace();
        }
    }

}