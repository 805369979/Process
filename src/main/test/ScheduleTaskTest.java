import com.example.MainApplication;
import com.example.process.NodeTask;
import com.example.scheduleTask.*;
import com.example.scheduleTask.thread.ThreadPoolManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ScheduleTaskTest {

//    @Autowired
//    Task1 taskSchedule1;
    @Autowired
    Schedule schedule;

    @Test
    public void testAnno(){
        // 设置任务实例属性
        InstanceTask task1 = new InstanceTask();
        task1.setName("任务1");
        task1.setId(UUID.randomUUID().toString());
        // 设置上下文参数
        Context context = new Context();
        HashMap<String, Object> param = new HashMap<>();
        context.setParam(param);
        // 调用线程池执行
        schedule.runTask1("Task1",task1,context);

        // 任务2执行,设置参数
        InstanceTask task2 = new InstanceTask();
        task2.setName("任务2");
        task2.setId(UUID.randomUUID().toString());
        schedule.runTask1("Task2",task2,context);
    }
}
