package com.example.scheduleTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ScheduleCode(code = "Task2")
public class Task2 extends TaskHandler{

    @Override
    public boolean handle(InstanceTask instanceTask, Context context) {
        Map<String, Object> param = context.getParam();
        System.out.println("调度任务2");
        preHandle(instanceTask,context);
        return true;
    }

    @Override
    public void postHandle(InstanceTask task, Context context) {

    }
}
