package com.example.process;

import com.example.process.ProcessNode.context.ReviewContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NodeTask {

    @Autowired
    private ProcessEngin processEngin;

    public boolean handle() {
        // 调用流程节点执行
        double run = processEngin.<ReviewContext, Double>fire(QuantityType.ABILITY_CAL)
                .contextBuilder(() -> {
                    ReviewContext context = new ReviewContext();
                    context.setQuantity(1000);
                    return context;
                }).resultBuilder(context -> {
                    double quantity = context.getQuantity();
                    return quantity;
                }).run();
        if (run<0){
            return false;
        }
        return true;
    }
}
