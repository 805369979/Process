/*
 * Alibaba.com Inc.
 * Copyright (c) 1999-2021 Alibaba All Rights Reserved.
 */
package com.example.scheduleTask;

import org.springframework.beans.factory.InitializingBean;

/**
 *   任务抽象类
 */
public abstract class TaskHandler implements InstanceTaskHandler, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        InstanceTaskFactory.register(this);
    }
}
