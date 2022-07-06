/*
 * Alibaba.com Inc.
 * Copyright (c) 1999-2021 Alibaba All Rights Reserved.
 */
package com.example.scheduleTask;


/**
 *
 */
public interface InstanceTaskHandler {

    /**
     * 实例任务前置执行
     */
    default boolean preHandle(InstanceTask task, Context context){
        return true;
    };


    /**
     * 实例任务执行
     */
    boolean handle(InstanceTask instanceTask, Context context);

    /**
     * 实例任务后置执行
     */
    void postHandle(InstanceTask task, Context context);
}
