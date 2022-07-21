package com.example.reCalculate;

import com.example.reCalculate.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 重算门面
 */
@Slf4j
@Component
public class ReCalculateTemplate implements Listener {

    @Override
    public void action(Event event) {
        if (null == event) {
            throw new RuntimeException("无法重算");
        }
        // 挑选出合适的工厂用于重算
        Factory processorFactory = getFactory(event.getScene());
        processorFactory.process(event);
    }

    /**
     * 获取合适的工厂处理
     */
    private Factory getFactory(String sceneFactory) {
        return SpringUtils.getBeanOfType(Factory.class).get(sceneFactory);
    }
}
