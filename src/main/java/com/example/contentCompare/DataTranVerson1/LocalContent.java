package com.example.contentCompare.DataTranVerson1;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocalContent {
    public static String localCacheMD5;
    public static Map<String, Person> cache = new HashMap<>();
}
