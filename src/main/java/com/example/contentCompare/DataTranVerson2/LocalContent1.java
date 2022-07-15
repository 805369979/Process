package com.example.contentCompare.DataTranVerson2;

import com.example.contentCompare.DataTranVerson1.Person;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class LocalContent1 {
    public static Map<String, Person> cache = new HashMap<>();
}
