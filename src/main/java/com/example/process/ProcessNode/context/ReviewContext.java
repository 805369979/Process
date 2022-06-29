package com.example.process.ProcessNode.context;

import com.example.process.Context;
import lombok.Data;

/**
 * 审批上下文
 */
@Data
public class ReviewContext implements Context {
    /**
     * 产品供应量
     */
    private double quantity;

}