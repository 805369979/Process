package com.example.scheduleTask.thread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池定义
 */
@Slf4j
public class ThreadPoolManager {

    public static ExecutorService taskExecutor = new ThreadPoolExecutor(5, 100, 1L,
            TimeUnit.MINUTES, new ArrayBlockingQueue<>(128), runnable -> {
        Thread t = new Thread(runnable);
        t.setName("taskThread");
        t.setDaemon(true);
        return t;
    });



    public static void doRun(Runnable runnable, Object... param) {
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    log.error("param={0}", param);
                }
            }
        });
    }
}
