package com.igor.screenmatch.service;

public interface IDataParser {
    <T> T getData(String json, Class<T> c);
}
