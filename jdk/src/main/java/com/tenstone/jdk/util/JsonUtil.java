package com.tenstone.jdk.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;


import java.io.UnsupportedEncodingException;
import java.util.Map;

public class JsonUtil {
    public static final TypeReference<JSONObject> JSONOBJECT_TYPE = new TypeReference<JSONObject>() {
    };
    public static final TypeReference<Map<String, Object>> MAP_OBJECT_TYPE = new TypeReference<Map<String, Object>>() {
    };



    //Object对象转成JSON字符串后，进一步转成字节数组
    public static byte[] object2JsonBytes(Object obj) {

        //把对象转换成JSON

        String json = pojoToJson(obj);
        try {
            return json.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反向：字节数组，转成JSON字符串，转成Object对象
    public static <T> T jsonBytes2Object(byte[] bytes, Class<T> tClass) {
        //字节数组，转成JSON字符串
        try {
            String json = new String(bytes, "UTF-8");
            T t = jsonToPojo(json, tClass);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //使用谷歌 Gson 将 POJO 转成字符串
    public static String pojoToJson(Object obj) {
        //String json = new Gson().toJson(obj);

        return JSON.toJSONString(obj);
    }

    //使用阿里 Fastjson 将字符串转成 POJO对象
    public static <T> T jsonToPojo(String json, Class<T> tClass) {
        T t = JSONObject.parseObject(json, tClass);
        return t;
    }

    //使用阿里 Fastjson 将字符串转成 POJO对象
    public static <T> T jsonToPojo(String json, TypeReference<T> type) {
        T t = JSON.parseObject(json, type);
        return t;
    }


}
