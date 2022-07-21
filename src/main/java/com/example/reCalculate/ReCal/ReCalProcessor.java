package com.example.reCalculate.ReCal;

import com.example.reCalculate.Event;

/**
 * 重算功能定义
 */
public interface ReCalProcessor {
    /**
     * 逻辑处理
     */
    void process(Event event);
}
