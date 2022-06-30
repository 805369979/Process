package com.example.process.ProcessNode.context;

import com.example.process.Context;
import lombok.Data;

/**
 * 产品供应推演上下文
 */
@Data
public class ReviewContext implements Context {
    /**
     * 产品供应量
     */
    private double quantity;

}
