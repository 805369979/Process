package com.example.scheduleTask;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ScheduleCode(code = "Task1")
@EnableScheduling
public class Task1 extends TaskHandler{

    @Scheduled(cron = "")
    @Override
    public boolean handle(InstanceTask instanceTask, Context context) {
        Map<String, Object> param = context.getParam();
        System.out.println("调度任务1");
        postHandle(instanceTask,context);
        return true;
    }

    @Override
    public void postHandle(InstanceTask task, Context context) {

    }
}
