package com.example.contentCompare.DataTranVerson1;


import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 本地比较器
 */
@Component("Compare")
public class Compare implements CompareInter{

    @Autowired
    @Qualifier("RemoteDataTran1")
    RemoteDataTran remoteDataTran;

    // 最好在事务中运行
    @Override
    public Boolean equalData(String remoteMD5){
        String compute = compute(LocalContent.cache);
        if (StringUtils.isEmpty(compute) || StringUtils.isEmpty(remoteMD5)){
            return false;
        }

        if (remoteMD5.equals(compute)){
            System.out.println("本地的MD5是"+LocalContent.localCacheMD5);
            return false;
        }
        dataTran();
        return true;
    }

    public Boolean update(){
        dataTran();
        return true;
    }

    @Override
    public void dataTran() {
        // 获取远程机器的数据
        Map<String, Person> stringPersonMap = remoteDataTran.getData();
        // 原来的缓存MD5清理掉
        LocalContent.localCacheMD5 = null;
        LocalContent.cache.clear();
        LocalContent.cache.putAll(stringPersonMap);
        // 更新本地缓存的MD5
        compute(LocalContent.cache);
    }

    /**
     * 计算本地缓存的MD5
     */
    public String compute(Map<String,Person> localData){
        if (MapUtils.isEmpty(localData)){
            return null;
        }
        // 如果我们本地缓存内容没有变，则不需要重新计算
        if (!StringUtils.isEmpty(LocalContent.localCacheMD5)){
            return LocalContent.localCacheMD5;
        }
        String str = JSON.toJSON(localData).toString();
        String md5str = DigestUtils.md5Hex(str);
        System.out.println("MD5加密后的字符串为:" + md5str);
        LocalContent.localCacheMD5 = md5str;
        return md5str;
    }
}
