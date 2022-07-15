package com.example.contentCompare.DataTranVerson2;

import com.example.contentCompare.DataTranVerson1.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("RemoteDataTran2")
public class RemoteDataTran2 {

    public Map<String, Person> getData() {
        return RemoteContent2.cache;
    }

    public void update(Map<String, Person> data) {
        RemoteContent2.cache.clear();
        RemoteContent2.cache.putAll(data);
        // 模拟通知另一个客观端更新
        QueueChannel.info.add("S");
    }
}
