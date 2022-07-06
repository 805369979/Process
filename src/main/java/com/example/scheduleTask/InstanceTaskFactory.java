package com.example.scheduleTask;
import java.util.*;
/**
 *  定时任务工厂
 */
public class InstanceTaskFactory {
    /**
     * 定时任务缓存
     */
    private static Map<String, InstanceTaskHandler> instanceTaskHandlers = new HashMap<>();

    /**
     * 注册任务处理器
     */
    public static void register(InstanceTaskHandler taskHandler) {
        ScheduleCode annotation = taskHandler.getClass().getAnnotation(ScheduleCode.class);
        String code = annotation.code();
        instanceTaskHandlers.put(code, taskHandler);
    }

    /**
     * 获取任务
     */
    public static InstanceTaskHandler getInstanceTaskHandler(String taskCode) {
        return instanceTaskHandlers.get(taskCode);
    }

}