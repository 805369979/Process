package com.example.standardRule;

import lombok.Data;

import java.util.Map;

@Data
public class Request {
    /**
     * 哪个专业的教案
     */
    private String major;

    /**
     * 额外的要求
     */
    private Map<String, Object> condition;
}
