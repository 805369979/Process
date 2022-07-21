package com.example.reCalculate.price;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChainProcess {
    @Autowired
    Chain1 chain1;
    @Autowired
    Chain2 chain2;

    public void run(Context context){
        chain1.nextHandler = chain2;
        boolean process = chain1.process(context);
        if (!process){
            throw new RuntimeException("推演失败");
        }
    }


}
