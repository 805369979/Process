package com.example.reCalculate;

/**
 * 重算接口定义，用于接收消息队列的信息
 */
public interface Listener {
    void action(Event event);
}
