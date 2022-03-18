package com.tenstone.flink.project.app;

import com.alibaba.fastjson.JSON;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.tenstone.flink.project.domain.Access;
import org.apache.flink.api.common.functions.FilterFunction;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.KeyedProcessFunction;
import org.apache.flink.util.Collector;

import java.util.Objects;

public class OsUserCntAppV4 {

    public static void main(String[] args) throws Exception {

        StreamExecutionEnvironment environment = StreamExecutionEnvironment.getExecutionEnvironment();

        SingleOutputStreamOperator<Access> cleanStream = environment.socketTextStream("localhost", 9527)
                .map((MapFunction<String, Access>) value -> {
                    // TODO...  json ==> Access
                    try {
                        return JSON.parseObject(value, Access.class);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .filter((FilterFunction<Access>) value -> "startup".equals(value.event));


        cleanStream.keyBy(x -> x.deviceType)
                .process(new KeyedProcessFunction<String, Access, Access>() {

                    private transient ValueState<BloomFilter<String>> state;

                    @Override
                    public void open(Configuration parameters) throws Exception {
                        ValueStateDescriptor<BloomFilter<String>> descriptor = new ValueStateDescriptor<>("s", TypeInformation.of(new TypeHint<BloomFilter<String>>() {
                        }));
                        state = getRuntimeContext().getState(descriptor);
                    }

                    @Override
                    public void processElement(Access value, Context ctx, Collector<Access> out) throws Exception {
                        String device = value.device;
                        BloomFilter<String> bloomFilter = state.value();
                        if (null == bloomFilter) {
                            bloomFilter = BloomFilter.create(Funnels.unencodedCharsFunnel(), 100000);
                        }
                        if (!bloomFilter.mightContain(device)) {
                            bloomFilter.put(device);
                            value.nu2 = 1;
                            state.update(bloomFilter);
                        }

                        out.collect(value);
                    }
                }).print();


        environment.execute("OsUserCntAppV2");

    }
}
