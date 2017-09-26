package com.learning.gcs.gateway.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtil {

    public static JavaType getCollectionType(ObjectMapper objectMapper, Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }
}
