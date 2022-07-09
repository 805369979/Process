package com.example.standardRule;

import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AIMajor extends AbstractMajorHandler {

    @Override
    public Result export(Request param) {
        super.export(param);
        int a = 10;
        int b = 10;
        // 模拟返回结果
        boolean isFinish =( a==b);
        String message = "顺利完成,具体内容请查看www.baidu.com";
        return Result.of(isFinish, message);
    }

    @Override
    protected void parseCondition(Map<String, Object> condition) {
        // 随便写两个检查，具体的看你使用的场景
        if (MapUtils.isEmpty(condition)){
            return;
        }
        if (!condition.containsKey("reviewer")){
            return;
        }
    }

    @Override
    public void whatRule() {

    }

    @Override
    public void howRule() {

    }

    @Override
    public void doRule() {

    }


    @Override
    public boolean support(String majorCode) {
        return "AIMajor".equals(majorCode);
    }
}