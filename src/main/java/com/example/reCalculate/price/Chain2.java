package com.example.reCalculate.price;

import org.springframework.stereotype.Component;

/**
 * 秦同学
 */
@Component
public class Chain2 extends AbstractChain {

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public boolean process(Context context) {
        System.out.println("推演节点2");
        return true;
    }

}
