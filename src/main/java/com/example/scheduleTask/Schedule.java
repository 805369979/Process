package com.example.scheduleTask;


import com.example.scheduleTask.thread.ThreadPoolManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Schedule {

    public void runTask1(String taskCode, InstanceTask instanceTask, Context context) {
        InstanceTaskHandler task11 = InstanceTaskFactory.getInstanceTaskHandler(taskCode);
        // 调用线程池执行

        ThreadPoolManager.doRun(() -> {
            task11.handle(instanceTask, context);
        });
    }
}