package com.example.process.ProcessNode.nodes;

import com.example.process.Node;
import com.example.process.ProcessNode.context.ReviewContext;
import org.springframework.stereotype.Component;

/**
 * 审批节点2
 */
@Component
public class ReviewNode_2 extends Node<ReviewContext> {
    @Override
    public void process(ReviewContext context) {
        double quantity = context.getQuantity();

        if (quantity <= 0) {
            return;
        }
        quantity = quantity - 100;
        context.setQuantity(quantity);
    }

    @Override
    public String getNodeName() {
        return "产品供应量推演-推演节点2";
    }

}
