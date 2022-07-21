package com.example.reCalculate.ReCal;

import com.example.reCalculate.Event;
import com.example.reCalculate.price.AbstractChain;
import com.example.reCalculate.price.ChainProcess;
import com.example.reCalculate.price.Context;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 */
@Slf4j
@Component("DEDUCE_QUANTITY_PROCESSOR")
public class DeduceQuantityProcessor implements ReCalProcessor {

    @Autowired
    ChainProcess chainProcess;

    @Override
    public void process(Event event) {
        // 事件类型可以参照ItemEvent.Type
        switch (event.getDeduceType()) {
            case "Price_Deduce":
                //对删除宝贝的处理逻辑
                processPriceDeduce(event);
                break;
            case "Weight_Deduce":
                //下架宝贝的处理逻辑
                processWeightDeduce(event);
                break;
            default:
                break;
        }
    }
    // 大型推演任务可以选择责任链来构建
    private void processPriceDeduce(Event event) {
        try {
            chainProcess.run(event.getContext());
        }catch (Exception e){
            throw new RuntimeException("推演过程失败");
        }
    }
    // 小型推演任务可直接在方法中实现
    private void processWeightDeduce(Event event) {
        System.out.println("重量推演");
    }
}
