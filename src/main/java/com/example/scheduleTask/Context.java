package com.example.scheduleTask;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文参数
 */
@Data
public class Context {
    public Map<String, Object> param = new HashMap<>();
}
