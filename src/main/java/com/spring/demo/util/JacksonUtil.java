package com.spring.demo.util;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @author yuhaojie on 2022/7/16.
 * @version 1.0
 */
public class JacksonUtil {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        // 所有的日期都统一用yyyy-MM-dd HH:mm:ss格式
        MAPPER.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
        // 忽略字符串存在，对象不存在的属性
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * 将对象转换成json字符串
     *
     * @param data 要转换成json的对象
     * @return 返回json字符串
     */
    public static String objectToJsonString(Object data) {
        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @param <T>      泛型
     * @return jsonToPojo (返回想要的pojo对象)
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     * @param <T>      泛型
     * @return jsonToList (返回想要的List对象)
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);

        try {
            return MAPPER.readValue(jsonData, javaType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json字符串转换为map
     *
     * @param jsonData json数据
     * @param <T>      泛型
     * @return jsonToMap (返回想要的Map对象)
     */
    public static <T> Map<String, Object> jsonToMap(String jsonData) {
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return MAPPER.readValue(jsonData, Map.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
