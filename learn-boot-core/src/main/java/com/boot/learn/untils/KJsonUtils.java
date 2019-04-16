package com.boot.learn.untils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: taozhengzhi
 * @Date: 2019/4/12 下午5:08
 * @Version 1.0
 */
public class KJsonUtils {
    
    private static Logger logger = LoggerFactory.getLogger(KJsonUtils.class);
    private static ObjectMapper mapper = new ObjectMapper();
    
    static {
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }
    
    public static String toJson(Object object) {
        String json = null;
        try {
            json = mapper.writeValueAsString(object);
            logger.debug(object.getClass() + " - " + json);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
        }
        return json;
    }
    
    public static <T> T toObject(String json, Class<T> clazz) {
        try {
            logger.debug(clazz + " - " + json);
            return mapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
    
    
    public static <T> List<T> toList(String json, Class<T> clazz) {
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, clazz);
        logger.debug(clazz + " - " + json);
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
    
    public static <K, V> Map<K, V> toObjectMap(String json, Class<K> keyClass, Class<V> valueClass) {
        JavaType type = mapper.getTypeFactory().constructParametricType(HashMap.class, keyClass, valueClass);
        logger.debug(keyClass + "/" + valueClass + " - " + json);
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }
}

