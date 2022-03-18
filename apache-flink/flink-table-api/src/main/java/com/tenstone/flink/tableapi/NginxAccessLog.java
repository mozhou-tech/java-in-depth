package com.tenstone.flink.tableapi;

import org.apache.flink.table.api.*;

/**
 * Created by liuyuancheng on 2022/3/18  <br/>
 *
 * @author liuyuancheng
 */
public class NginxAccessLog {
    public static void main(String[] args) {
        EnvironmentSettings settings = EnvironmentSettings.newInstance()
                .inBatchMode()
                .build();
        TableEnvironment tableEnv = TableEnvironment.create(settings);

        tableEnv.createTemporaryTable("accessLogTable", TableDescriptor.forConnector("datagen")
                .schema(Schema.newBuilder()
                        .column("time", DataTypes.TIMESTAMP())
                        .build())
                .build()
        );
        tableEnv.executeSql("");
    }
}
