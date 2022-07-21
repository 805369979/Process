package com.example.reCalculate.ReCal;

import com.example.reCalculate.Event;
import com.example.reCalculate.Factory;
import com.example.reCalculate.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 工厂1
 */
@Slf4j
@Component("QUANTITY_CAL")  // 每个工厂的名字对应这请求中的scene
public class ProcessorFactory1 implements Factory {
    /**
     * 处理重算任务
     */
    public void process(Event event) {
        ReCalProcessor processors = getProcessors(event.getType());
        if (Objects.isNull(processors)) {
            log.warn("缺少重算逻辑: {}", event);
            return;
        }
        try {
            processors.process(event);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取所有处理器
     */
    private ReCalProcessor getProcessors(String name) {
        return (ReCalProcessor) SpringUtils.getBean(name);
    }
}
