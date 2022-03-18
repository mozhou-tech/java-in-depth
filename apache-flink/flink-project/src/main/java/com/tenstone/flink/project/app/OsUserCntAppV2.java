package com.tenstone.flink.project.app;

import com.alibaba.fastjson.JSON;
import com.tenstone.flink.project.domain.Access;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.Objects;

/**
 * 新老用户的统计分析
 */
public class OsUserCntAppV2 {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        SingleOutputStreamOperator<Access> cleanStream = environment
                .readTextFile("data/access.json")
                .map((MapFunction<String, Access>) value -> {
                    try {
                        return JSON.parseObject(value, Access.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .filter((FilterFunction<Access>) value -> "startup".equals(value.event));

        cleanStream
                .map((MapFunction<Access, Tuple2<Integer, Integer>>) value -> Tuple2.of(value.nu, 1))
                .keyBy(x -> x.f0)
                .sum(1).print("总的新老用户:").setParallelism(1);


        /**
         * (iOS,1,38)
         * (Android,1,29)
         * (iOS,0,17)
         * (Android,0,16)
         *
         * ==>
         * (1, 67)
         * (0, 33)
         */
        environment.execute("OsUserCntAppV2");

    }
}
