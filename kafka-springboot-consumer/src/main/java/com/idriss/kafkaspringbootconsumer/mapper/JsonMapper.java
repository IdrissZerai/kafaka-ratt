package com.idriss.kafkaspringbootconsumer.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonMapper {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readFromJson(String json, Class<T> clazz) throws JsonProcessingException {
            return objectMapper.readValue(json, clazz);
    }

    public static String writeToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }
}
