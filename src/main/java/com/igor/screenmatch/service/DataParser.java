package com.igor.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataParser implements IDataParser {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getData(String json, Class<T> c) {
        try {
            return mapper.readValue(json, c);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
