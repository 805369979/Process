package com.example.standardRule;

import org.apache.commons.collections4.MapUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SoftwareMajor extends AbstractMajorHandler {

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
        System.out.println("软件技术的教案规则是什么");
    }

    @Override
    public void howRule() {
        System.out.println("软件技术的教案规则怎么制定");
    }

    @Override
    public void doRule() {
        System.out.println("软件技术的教案规则怎么执行");
    }

    @Override
    public boolean support(String majorCode) {
        return "software".equals(majorCode);
    }
}