package com.example.contentCompare.DataTranVerson2;


import com.example.contentCompare.DataTranVerson1.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 本地比较器
 */
@Component("Compare2")
@EnableScheduling
public class Compare2 implements Listener {

    @Autowired
    @Qualifier("RemoteDataTran2")
    RemoteDataTran2 remoteDataTran;

    @Scheduled(cron = "*/1 * * * * ?") //每五秒钟执行一次
    @Override
    public void receive() {
        String receiveData ;
        if (QueueChannel.info.size()<=0){
            return;
        }
        receiveData = QueueChannel.info.poll();
        // 测试用的
        QueueChannel.info.add("S");
        System.out.println("接收到的数据是"+receiveData);
        // 获取远程机器的数据
        Map<String, Person> stringPersonMap = remoteDataTran.getData();
        // 原来的缓存MD5清理掉
        LocalContent1.cache.clear();
        LocalContent1.cache.putAll(stringPersonMap);
    }
}
