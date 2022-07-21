package com.example.reCalculate.price;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 秦同学
 */
@Component
public class Chain1 extends AbstractChain {

    public void setName(String name){
         this.name = name;
    }
    public String getName(){
        return this.name;
    }

    @Override
    public boolean process(Context context) {
        System.out.println("推演节点1");
        return nextHandler.process(context);
    }

}
