package com.example.contentCompare.DataTranVerson1;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("RemoteDataTran1")
public class RemoteDataTran{

    @Autowired
    @Qualifier("Compare")
    Compare compare;

    public Map<String, Person> getData() {
        return RemoteContent.cache;
    }

    public String getMD5() {
        return RemoteContent.remoteCacheMD5;
    }

    public void update(Map<String, Person> data) {
        String str = JSON.toJSON(data).toString();
        String md5str = DigestUtils.md5Hex(str);
        System.out.println("远程服务器->MD5加密后的字符串为:" + md5str);
        RemoteContent.remoteCacheMD5 = md5str;
        RemoteContent.cache.clear();
        RemoteContent.cache.putAll(data);
        // 模拟通知另一个客观端更新
        compare.update();
    }
}
