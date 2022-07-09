package com.example.standardRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FacadeImpl {

    @Autowired
    private List<StandardHandler> standardHandlers;

    public Result export(Request param) {
        for (StandardHandler standardHandler : standardHandlers) {
            if (standardHandler.support(param.getMajor())) {
                Result export = standardHandler.export(param);
                return export;
            }
        }
        throw new IllegalArgumentException(String.format("不支持导出专业为%s的数据", param.getMajor()));
    }
}
