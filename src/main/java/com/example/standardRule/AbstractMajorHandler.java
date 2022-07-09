package com.example.standardRule;

import lombok.Data;
import java.util.Map;

@Data
public abstract class AbstractMajorHandler implements StandardHandler {

    @Override
    public Result export(Request param) {
        // 解析导出参数
        try {
            this.parseCondition(param.getCondition());
            whatRule();
            howRule();
            doRule();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    protected abstract void parseCondition(Map<String, Object> condition);
}
